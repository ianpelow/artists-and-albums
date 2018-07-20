package org.wecancodeit.artistsandalbums;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Album {

	@Id
	@GeneratedValue
	
	@OneToMany(mappedBy = "albums")
	private Collection<Song> songs;
	
	private String albumName;
	private Long albumId;
	private String albumReleaseDate;
	private String albumSongs;
	private String albumGenre;
	private String albumCoverImage;
	
	public Album(String albumName, Long albumId, String albumReleaseDate, String albumSongs, String albumGenre, String albumCoverImage) {
		super();
		this.albumName = albumName;
		this.albumId = albumId;
		this.albumReleaseDate = albumReleaseDate;
		this.albumSongs = albumSongs;
		this.albumGenre = albumGenre;
		this.albumCoverImage = albumCoverImage;
	}


	public String getAlbumName() {
		return albumName;
	}

	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}

	public Long getAlbumId() {
		return albumId;
	}
	
	public void setAlbumId(Long albumId) {
		this.albumId = albumId;
	}
	
	public String getAlbumReleaseDate() {
		return albumReleaseDate;
	}

	public void setAlbumReleaseDate(String albumReleaseDate) {
		this.albumReleaseDate = albumReleaseDate;
	}

	public String getAlbumSongs() {
		return albumSongs;
	}

	public void setAlbumSongs(String albumSongs) {
		this.albumSongs = albumSongs;
	}

	public String getAlbumGenre() {
		return albumGenre;
	}

	public void setAlbumGenre(String albumGenre) {
		this.albumGenre = albumGenre;
	}

	public String getAlbumCoverImage() {
		return albumCoverImage;
	}

	public void setAlbumCoverImage(String albumCoverImage) {
		this.albumCoverImage = albumCoverImage;
	}
	
	public Collection<Song> getSongs() {
		return songs;	
	}
	
	public void setSongs(Collection<Song> songs) {
		this.songs = songs;
	}
	
	@Override
	public String toString() {
		return albumName;
	}
	
}
