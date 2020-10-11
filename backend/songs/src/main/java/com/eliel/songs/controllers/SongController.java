package com.eliel.songs.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eliel.songs.entity.models.Song;
import com.eliel.songs.entity.services.ISongService;

@CrossOrigin(origins = "http://localhost:8100")
@RestController
public class SongController {
	
	@Autowired
	ISongService songService;
	// Here are the end-points

	@GetMapping("/api/songs")
	private List<Song> getAll(){
		return songService.getAll();
	}
	
	@GetMapping("/api/songs/{name}") 
	private List<Song> findByName(@PathVariable(value = "name") String name){ 
		System.out.println(name);
		return songService.findByName(name); 
	}
	
	@PostMapping("/api/songs")
	private void addSong(Song song) {
		songService.addSong(song);
	}
	
	@DeleteMapping("/api/songs/{id}")
	private void deleteSong(@PathVariable(value = "id") int id) {
		songService.deleteSong(id);
	}
	
	@PutMapping("/api/songs/{id}")
	private void updateSong(@PathVariable(value = "id") int id, Song song) {
		songService.updateSong(id, song);
	}
}
