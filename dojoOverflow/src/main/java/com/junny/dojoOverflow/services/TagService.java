package com.junny.dojoOverflow.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.junny.dojoOverflow.models.Tag;
import com.junny.dojoOverflow.repositories.TagRepository;

@Service
public class TagService {
 // adding the tag repository as a dependency
 private final TagRepository tagRepository;
 
 public TagService(TagRepository tagRepository) {
     this.tagRepository = tagRepository;
 }
 // returns all the tags
 public List<Tag> allTags() {
     return tagRepository.findAll(); // https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#reference 
 }
 
 // creates a tag
 public Tag createTag(Tag t) {
     return tagRepository.save(t); // save() fn from extending from Crud
 }
 // retrieves a tag
 public Tag findTag(Long id) {
     Optional<Tag> optionalTag = tagRepository.findById(id); // Optional is saying "if it is here, i'll get you the tag"
     if(optionalTag.isPresent()) {
         return optionalTag.get();
     } else {
         return null;
     }
 }
 // updates a tag
 public Tag updateTag(Long id, String subject) {
 	Tag t = findTag(id);
 	t.setSubject(subject);
 	return tagRepository.save(t);
 }
 
 public Tag updateTag(Tag t) {
 	return tagRepository.save(t);
 }
 
 // deletes a tag
 public void deleteTag(Long id) {
 	tagRepository.deleteById(id);
 }
}



