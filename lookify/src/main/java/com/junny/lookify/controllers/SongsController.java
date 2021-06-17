package com.junny.lookify.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.junny.lookify.models.Song;
import com.junny.lookify.services.SongService;

@Controller
public class SongsController {
	 private final SongService songService;
	 
	 public SongsController(SongService songService) {
	     this.songService = songService;
	 }
	 
	 @RequestMapping("/songs") // READ ALL
	 public String index(Model model) {  // @RequestParam for artist searches
	     List<Song> songs = songService.allSongs();
	     model.addAttribute("songs", songs);
	     return "/songs/index.jsp";
	 }
	 
	 @RequestMapping("/search/{name}") // READ matched songs
	 public String viewSearch(Model model,
			 @PathVariable(value = "name") String name) {
	     List<Song> songs = songService.allMatchedSongs(name);
	     model.addAttribute("songs", songs);
	     return "/songs/index.jsp";
	 }
	 // model holds info while you are on that page, but not accessible globally
	 // session holds onto info later on 
	 
	 @PostMapping("/search") // READ ALL MATCHED SONGS // short hand of post
	 public String search(@RequestParam(value = "name") String name) {
//	     return "/songs/index.jsp";
	     return "redirect:/search/" + name;
	 }
	 
	 @RequestMapping("/search/topTen") // Top Ten
	 public String topTen(Model model) {
		 List<Song> songs = songService.topTenSongs();
		 model.addAttribute("songs", songs);
	     return "/songs/topTen.jsp";
	 }
	 
	 @RequestMapping("/songs/new") // CREATE
	 public String newSong(@ModelAttribute("song") Song song) {
	     return "/songs/new.jsp";
	 }
	 
	 
	 // anything rendering a jsp = can be a get method
	 // put mapping can be used for the edit 
	 // also delete method 
	 
	 @RequestMapping(value="/songs", method=RequestMethod.POST) // NEW // long hand
	 public String create(@Valid @ModelAttribute("song") Song song, BindingResult result) {
	     if (result.hasErrors()) {
	         return "/songs/new.jsp";
	     } else {
	         songService.createSong(song);
	         return "redirect:/songs";
	     }
	 }
	 
	 @RequestMapping("/songs/{id}") // READ ONE
	 public String show(Model model, @PathVariable("id") Long id) {
		 Song song = songService.findSong(id);
		 model.addAttribute("song", song);
		 return "/songs/show.jsp";
	 }
	 
	 @RequestMapping("/songs/{id}/edit") // display jsp file 
	 public String edit(@PathVariable("id") Long id, Model model) {
	     Song song = songService.findSong(id);
	     model.addAttribute("song", song);
	     return "/songs/edit.jsp";
	 }
	 
	 @RequestMapping(value="/songs/{id}", method=RequestMethod.PUT) // actually doing the put
	 public String update(@Valid @ModelAttribute("song") Song song, BindingResult result) {
	     if (result.hasErrors()) {
	         return "/songs/edit.jsp";
	     } else {
	         songService.updateSong(song);
	         return "redirect:/songs";
	     }
	 }
	 
	 @RequestMapping(value="/songs/{id}/delete", method=RequestMethod.DELETE) // delete
	 public String destroy(@PathVariable("id") Long id) {
	     songService.deleteSong(id);
	     return "redirect:/songs";
	 }
 
}


