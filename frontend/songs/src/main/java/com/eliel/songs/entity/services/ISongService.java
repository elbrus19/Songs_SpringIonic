package com.eliel.songs.entity.services;

import java.util.List;

import com.eliel.songs.entity.models.Song;

public interface ISongService {

	public List<Song> getAll();

	public List<Song> findByName(String name);

	public void addSong(Song song);

	public void deleteSong(int id);

	public void updateSong(int id, Song song);

}
