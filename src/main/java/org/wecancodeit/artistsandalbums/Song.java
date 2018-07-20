package org.wecancodeit.artistsandalbums;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Song {
	
	@Id
	@GeneratedValue
	
	private String songName;
	private Long songId;
	private String length;
	private String lyrics;
	private String rating;
	
	public Song(String songName, Long songId, String length, String lyrics, String rating) {
		super();
		this.songName = songName;
		this.songId = songId;
		this.length = length;
		this.lyrics = lyrics;
		this.rating = rating;
	}
	
	public String getSongName() {
		return songName;
	}

	public void setSongName(String songName) {
		this.songName = songName;
	}

	public Long getSongId() {
		return songId;	
	}
	
	public void setSongId(Long songId) {
		this.songId = songId;	
	}
	
	public String getLength() {
		return length;
	}
	
	public void setLength(String length) {
		this.length = length;
	}
	
	public String getLyrics() {
		return lyrics;
	}
	
	public void setLyrics(String lyrics) {
		this.lyrics = lyrics;
	}
	
	public String getRating() {
		return rating;
	}
	
	public void setRating(String rating) {
		this.rating = rating;
	}

}
