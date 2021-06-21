package com.junny.dojoOverflow.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.junny.dojoOverflow.models.Tag;
import com.junny.dojoOverflow.services.TagService;

@Controller
public class TagsController {
	 private final TagService tagService;
	 
	 public TagsController(TagService tagService) {
	     this.tagService = tagService;;
	 }
	 
	 @RequestMapping("/tags") // READ ALL
	 public String index(Model model) {  // @RequestParam for artist searches
	     List<Tag> tags = tagService.allTags();
	     model.addAttribute("tags", tags);
	     return "/tags/index.jsp";
	 }

	 @RequestMapping("/tags/new") // CREATE
	 public String newTag(@ModelAttribute("tag") Tag tag) {
	     return "/tags/new.jsp";
	 }

	 @RequestMapping(value="/tags", method=RequestMethod.POST) // NEW // long hand
	 public String create(@Valid @ModelAttribute("tag") Tag tag, BindingResult result) {
	     if (result.hasErrors()) {
	         return "/tags/new.jsp";
	     } else {
	         tagService.createTag(tag);
	         return "redirect:/tags";
	     }
	 }
	 
	 @RequestMapping("/tags/{id}") // READ ONE
	 public String show(Model model, @PathVariable("id") Long id) {
		 Tag tag = tagService.findTag(id);
		 model.addAttribute("tag", tag);
		 return "/tags/show.jsp";
	 }
	 
	 @RequestMapping("/tags/{id}/edit") // display jsp file 
	 public String edit(@PathVariable("id") Long id, Model model) {
	     Tag tag = tagService.findTag(id);
	     model.addAttribute("tag", tag);
	     return "/tags/edit.jsp";
	 }
	 
	 @RequestMapping(value="/tags/{id}", method=RequestMethod.PUT) // actually doing the put
	 public String update(@Valid @ModelAttribute("tag") Tag tag, BindingResult result) {
	     if (result.hasErrors()) {
	         return "/tags/edit.jsp";
	     } else {
	         tagService.updateTag(tag);
	         return "redirect:/tags";
	     }
	 }
	 
	 @RequestMapping(value="/tags/{id}/delete", method=RequestMethod.DELETE) // delete
	 public String destroy(@PathVariable("id") Long id) {
	     tagService.deleteTag(id);
	     return "redirect:/tags";
	 }
 
}