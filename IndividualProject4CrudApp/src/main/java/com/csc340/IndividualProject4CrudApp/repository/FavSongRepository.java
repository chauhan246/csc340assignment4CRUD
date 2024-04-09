package com.csc340.IndividualProject4CrudApp.repository;

import org.springframework.data.repository.CrudRepository;

import com.csc340.IndividualProject4CrudApp.model.FavSongs;

public interface FavSongRepository extends CrudRepository<FavSongs, String> {
	
	FavSongs findBySongname(String songName);
}
