package org.wecancodeit.artistsandalbums;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Artist {
	
	@Id
	@GeneratedValue
	
	@OneToMany(mappedBy = "artists" )
	private Collection<Album> albums;
	
	private String artistName;
	private Long artistId;
	private String album;
	private String recordLabel;
	
	public Artist(String artistName, Long artistId, String album, String recordLabel) {
		super();
		this.artistName = artistName;
		this.artistId = artistId;
		this.album = album;
		this.recordLabel = recordLabel;
	}

	public String getArtistName() {
		return artistName;
	}
	
	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}
	
	public Long getArtistId() {
		return artistId;
	}

	public void setArtistId(Long artistId) {
		this.artistId = artistId;
	}
	

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public String getRecordLabel() {
		return recordLabel;
	}

	public void setRecordLabel(String recordLabel) {
		this.recordLabel = recordLabel;
	}
	
	public Collection<Album> getAlbums() {
		return albums;	
	}
	
	public void setlbums(Collection<Album> albums) {
		this.albums = albums;
	}

	@Override
	public String toString() {
		return artistName;
	}
}
