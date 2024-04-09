package com.csc340.IndividualProject4CrudApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.csc340.IndividualProject4CrudApp.model.FavSongs;
import com.csc340.IndividualProject4CrudApp.service.DataControllerService;

@CrossOrigin
@Controller
public class DataController {
	
	@Autowired
	DataControllerService dataControllerService;
	
	//Create
	@PostMapping("/addFavSong")
	public String addFavSong(FavSongs favSong){
		try {
			dataControllerService.addFavSong(favSong);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "redirect:/getAllFavSongs";
	}
	
	@GetMapping("/addFavSongInput")
	public String addFavSongInput(Model model) {
		FavSongs favSong = new FavSongs();
		model.addAttribute("favSong", favSong);
		return "/add-song";
	}
	
	
	//Read
	@GetMapping("/getAllFavSongs")
	public String getAllFavSongs(Model model){
		model.addAttribute("favSongs", dataControllerService.getAllFavSong());
		return "/all-fav-songs";
	} 
	
	//Update
	@PostMapping("/updateFavSong")
	public String updateFavSong(FavSongs favSong){
		try {
			dataControllerService.updateFavSong(favSong);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "redirect:/getAllFavSongs";
	}
	
	@GetMapping("/updateSongInput/song={songname}")
	public String updateSongInput(@PathVariable String songname, Model model) {
		FavSongs favSong = dataControllerService.getSongDetails(songname);
		model.addAttribute("favSong", favSong);
		return "/update-song";
	}
	
	//Delete
	@GetMapping("/removeFavSong/song={songname}")
	public String removeFavSong(@PathVariable String songname, Model model){
		dataControllerService.removeFavSong(songname);
		return "redirect:/getAllFavSongs";
	}
	

}
