package com.junny.dojoOverflow.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.junny.dojoOverflow.models.Tag;
import com.junny.dojoOverflow.services.TagService;

@RestController
public class TagsApi {
	 private final TagService tagService;
	 public TagsApi(TagService tagService){
	     this.tagService = tagService;
	 }
	 @GetMapping("/api/tags") 
	 public List<Tag> index() {
	     return tagService.allTags(); 
	 }
	 
	 @RequestMapping(value="/api/tags", method=RequestMethod.POST)
	 public Tag create(@RequestParam(value="subject") String subject){
	     Tag t = new Tag(subject); // creating/instantiating a new Tag tccording to the Tag Model
	     return tagService.createTag(t);
	 }
	 
	 @RequestMapping("/api/tags/{id}")
	 public Tag show(@PathVariable("id") Long id) {
	     Tag t = tagService.findTag(id); 
	     return t;
	 }
	 
	 @RequestMapping(value="/api/tags/{id}", method=RequestMethod.PUT)
	 public Tag update(@PathVariable("id") Long id, 
	 		@RequestParam(value="subject") String subject){
	     Tag t = tagService.updateTag(id, subject);
	     return t;
	 }
	 
	 @RequestMapping(value="/api/tags/{id}", method=RequestMethod.DELETE)
	 public void destroy(@PathVariable("id") Long id) {
	     tagService.deleteTag(id);
	 }

}




