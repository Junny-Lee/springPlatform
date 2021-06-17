package com.junny.languages.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.junny.languages.models.Language;
import com.junny.languages.repositories.LanguageRepository;

@Service
public class LanguageService {
	 // adding the Language repository as a dependency
	 private final LanguageRepository languageRepository;
	 
	 public LanguageService(LanguageRepository languageRepository) {
	     this.languageRepository = languageRepository;
	 }
	 // returns all the Languages
	 public List<Language> allLanguages() {
	     return languageRepository.findAll(); // https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#reference 
	 }
	 // creates a Language
	 public Language createLanguage(Language l) {
	     return languageRepository.save(l); // save() fn from extending from Crud
	 }
	 // retrieves a Language
	 public Language findLanguage(Long id) {
	     Optional<Language> optionalLanguage = languageRepository.findById(id); // Optional is saying "if it is here, i'll get you the Language"
	     if(optionalLanguage.isPresent()) {
	         return optionalLanguage.get();
	     } else {
	         return null;
	     }
	 }
	 // updates a language
	 public Language updateLanguage(Long id, String name, String creator, double currentVersion) {
	 	Language language = findLanguage(id);
	 	language.setName(name);
	 	language.setCreator(creator);
	 	language.setCurrentVersion(currentVersion);
	 	return languageRepository.save(language);
	 }
	 
	 public Language updateLanguage(Language l) {
	 	return languageRepository.save(l);
	 }
	 
	 // deletes a Language
	 public void deleteLanguage(Long id) {
	 	languageRepository.deleteById(id);
	 }
}