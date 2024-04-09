package com.csc340.IndividualProject4CrudApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.csc340.IndividualProject4CrudApp.model.FavSongs;
import com.csc340.IndividualProject4CrudApp.repository.FavSongRepository;


@Repository
public class DataControllerService {
	
	@Autowired
	FavSongRepository favSongRepository;
	
	//create
	public void addFavSong(FavSongs favSong) {
		System.out.println("Add new song: " + favSong.toString());

		favSongRepository.save(favSong);
	}
	
	//read
	public List<FavSongs> getAllFavSong() {
		System.out.println("Fetch all favorite songs.");
		
		List<FavSongs> favSongs = (List<FavSongs>) favSongRepository.findAll();
		
		return favSongs;
	}
	
	//read
	public FavSongs getSongDetails(String songname) {
		System.out.println("Fetch song: " + songname + " details.");
		
		FavSongs favSong = favSongRepository.findBySongname(songname);
		
		return favSong;
	}
	
	//update
	public void updateFavSong(FavSongs favSong) {
		System.out.println("Update song: " + favSong.toString());
		
		favSongRepository.save(favSong);
	}
	
	//delete
	public void removeFavSong(String songname) {
		System.out.println("Remove song: " + songname);

		favSongRepository.deleteById(songname);
	}
}
