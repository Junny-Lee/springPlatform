package com.junny.languages.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.junny.languages.models.Language;
import com.junny.languages.services.LanguageService;

@RestController
public class LanguagesApi {
    private final LanguageService languageService; // backend. think of it like a const variable (won't change)
    public LanguagesApi(LanguageService languageService){
        this.languageService = languageService;
    }
    @RequestMapping("/api/languages") // create routes
    public List<Language> index() {
        return languageService.allLanguages(); // calling on functions from LanguageService.java (calling from back-end)
    }
    
    @RequestMapping(value="/api/languages", method=RequestMethod.POST)
    public Language create(@RequestParam(value="name") String name, 
    		@RequestParam(value="creator") String creator, 
    		@RequestParam(value="currentVersion") double currentVersion) {
        Language language = new Language(name, creator, currentVersion); // creating/instantiating a new Language according to the Language Model
        return languageService.createLanguage(language); // calling on functions from LanguageService.java (calling from back-end)
    }
    
    @RequestMapping("/api/languages/{id}")
    public Language show(@PathVariable("id") Long id) {
        Language language = languageService.findLanguage(id); // calling on functions from LanguageService.java (calling from back-end)
        return language;
    }
    
    @RequestMapping(value="/api/languages/{id}", method=RequestMethod.PUT)
    public Language update(@PathVariable("id") Long id, 
    		@RequestParam(value="name") String name, 
    		@RequestParam(value="creator") String creator, 
    		@RequestParam(value="currentVersion") double currentVersion) {
        Language language = languageService.updateLanguage(id, name, creator, currentVersion);
        return language;
    }
    
    @RequestMapping(value="/api/languages/{id}", method=RequestMethod.DELETE)
    public void destroy(@PathVariable("id") Long id) {
        languageService.deleteLanguage(id);
    }

}

