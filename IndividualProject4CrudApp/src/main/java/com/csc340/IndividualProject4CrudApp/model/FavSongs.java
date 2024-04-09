package com.csc340.IndividualProject4CrudApp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name="favsongs")
public class FavSongs {
	@Id
	@NotBlank
	private String songname;
	private String genres;
	private String artist;
	
	public FavSongs() {
		super();
	}

	public FavSongs(String songname, String genres, String artist) {
		super();
		this.songname = songname;
		this.genres = genres;
		this.artist = artist;
	}

	public String getSongname() {
		return songname;
	}

	public void setSongname(String songname) {
		this.songname = songname;
	}

	public String getGenres() {
		return genres;
	}

	public void setGenres(String genres) {
		this.genres = genres;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}
	
	@Override
	public String toString() {
		return "Song Name: " + this.songname + ", Artist: " + this.artist + ", Genres: " + this.genres; 
	}
}
