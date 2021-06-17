package com.junny.lookify.services;

import java.util.Optional;
import java.util.List;

import org.springframework.stereotype.Service;

import com.junny.lookify.models.Song;
import com.junny.lookify.repositories.SongRepository;

@Service
public class SongService {
 // adding the song repository as a dependency
 private final SongRepository songRepository;
 
 public SongService(SongRepository songRepository) {
     this.songRepository = songRepository;
 }
 // returns all the songs
 public List<Song> allSongs() {
     return songRepository.findAll(); // https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#reference 
 }
 // returns all matched songs by artist
 public List<Song> allMatchedSongs(String name) {
	 return songRepository.findByArtistContaining(name);
 }
 //top ten songs
 public List<Song> topTenSongs(){
	 return songRepository.topTenSongs();
 }
 // creates a song
 public Song createSong(Song s) {
     return songRepository.save(s); // save() fn from extending from Crud
 }
 // retrieves a song
 public Song findSong(Long id) {
     Optional<Song> optionalSong = songRepository.findById(id); // Optional is saying "if it is here, i'll get you the song"
     if(optionalSong.isPresent()) {
         return optionalSong.get();
     } else {
         return null;
     }
 }
 // updates a song
 public Song updateSong(Long id, String title, String artist, Integer rating) {
 	Song song = findSong(id);
 	song.setTitle(title);
 	song.setArtist(artist);
 	song.setRating(rating);
 	return songRepository.save(song);
 }
 
 public Song updateSong(Song s) {
 	return songRepository.save(s);
 }
 
 // deletes a song
 public void deleteSong(Long id) {
 	songRepository.deleteById(id);
 }
}