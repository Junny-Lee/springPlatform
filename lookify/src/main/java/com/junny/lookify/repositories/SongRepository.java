package com.junny.lookify.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository; // gives us access to a bunch of functionalities from the DB
import org.springframework.stereotype.Repository;

import com.junny.lookify.models.Song;

@Repository
public interface SongRepository extends CrudRepository<Song, Long>{
    List<Song> findAll();
//    List<Song> findAllByArtist(String name); // what i was using before that matches on just the artist
    List<Song> findByArtistContaining(String name);
    @Query(value = "SELECT * FROM songs ORDER BY rating DESC LIMIT 10", nativeQuery = true)
    List<Song> topTenSongs();
}
