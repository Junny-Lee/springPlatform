package com.junny.lookify.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.junny.lookify.models.Song;
import com.junny.lookify.services.SongService;

@RestController
public class SongsApi {
 private final SongService songService; // backend. think of it like a const variable (won't change)
 public SongsApi(SongService songService){
     this.songService = songService;
 }
 @RequestMapping("/api/songs") // create routes
 public List<Song> index() {
     return songService.allSongs(); // calling on functions from SongService.java (calling from back-end)
 }
 
 @RequestMapping(value="/api/songs", method=RequestMethod.POST)
 public Song create(@RequestParam(value="title") String title, 
 		@RequestParam(value="artist") String artist, 
 		@RequestParam(value="rating") Integer rating) {
     Song song = new Song(title, artist, rating); // creating/instantiating a new Song according to the Song Model
     return songService.createSong(song); // calling on functions from SongService.java (calling from back-end)
 }
 
 @RequestMapping("/api/songs/{id}")
 public Song show(@PathVariable("id") Long id) {
     Song song = songService.findSong(id); // calling on functions from SongService.java (calling from back-end)
     return song;
 }
 
 @RequestMapping(value="/api/songs/{id}", method=RequestMethod.PUT)
 public Song update(@PathVariable("id") Long id, 
 		@RequestParam(value="title") String title, 
 		@RequestParam(value="artist") String artist, 
 		@RequestParam(value="rating") Integer rating) {
     Song song = songService.updateSong(id, title, artist, rating);
     return song;
 }
 
 @RequestMapping(value="/api/songs/{id}", method=RequestMethod.DELETE)
 public void destroy(@PathVariable("id") Long id) {
     songService.deleteSong(id);
 }

}

