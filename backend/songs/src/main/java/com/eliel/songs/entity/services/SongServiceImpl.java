package com.eliel.songs.entity.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eliel.songs.entity.dao.ISongDao;
import com.eliel.songs.entity.models.Song;


@Service
public class SongServiceImpl implements ISongService {
	
	@Autowired
	ISongDao songDao;

	@Override
	public List<Song> getAll() {
		// TODO Auto-generated method stub
		return (List<Song>) songDao.findAll();
	}

	@Override
	public List<Song> findByName(String name) {
		// TODO Auto-generated method stub
		System.out.println("hola");
		System.out.println(name);
		List<Song> listing = songDao.findAllSongsByName(name);
		return listing;
	}

	@Override
	public void addSong(Song song) {
		// TODO Auto-generated method stub
		songDao.save(song);
	}

	@Override
	public void deleteSong(int id) {
		// TODO Auto-generated method stub
		songDao.deleteById(id);
	}

	@Override
	public void updateSong(int id, Song song) {
		// TODO Auto-generated method stub				
		Optional<Song> sng = songDao.findById(id);
		if (sng.isPresent()) {
			song.setId(id);
			songDao.save(song);
		}
	}

}
