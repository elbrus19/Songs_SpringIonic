package com.eliel.songs.entity.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.eliel.songs.entity.models.Song;

public interface ISongDao extends CrudRepository<Song, Integer>{

	public List<Song> findAllSongsByName(String name);
}
