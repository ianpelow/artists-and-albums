package org.wecancodeit.artistsandalbums;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {
	
	@Autowired
	ArtistRepository artistRepo;

	@Autowired
	AlbumRepository albumRepo;

	@Autowired
	SongRepository songRepo;
	
	@RequestMapping("/artists")
	public Collection<Artist> getArtist() {
		return (Collection<Artist>) artistRepo.findAll();
	}
	
	@RequestMapping("/artists/{artistId}/albums")
	public Collection<Album> getArtistAlbums(@PathVariable(name = "album") String album) {
		return (Collection<Album>) artistRepo.findByAlbum(album).getAlbums();
	}
	
	@RequestMapping("/albums")
	public Collection<Album> getAlbum() {
		return (Collection<Album>) albumRepo.findAll();
	}
	
	@RequestMapping("/albums/{artistId}/songs")
	public Collection<Song> getAlbumSongs(@PathVariable(name = "song") String song) {
		return (Collection<Song>) albumRepo.findBySongName(song).getSongs();
	}

	@RequestMapping(value = "/artists", method = RequestMethod.POST)
	public Collection<Artist> addArtist(@RequestParam(value = "artistName") String artistName,
			@RequestParam(value = "artistId") Long artistId,
			@RequestParam(value = "album") String album,
			@RequestParam(value = "recordLabel") String recordLabel) {

		if (artistRepo.findByArtistName(artistName) == null) {
			artistRepo.save(new Artist(artistName, artistId, album, recordLabel));
		}

		return (Collection<Artist>) artistRepo.findAll();
	}

	@RequestMapping(value = "/artists/{artistId}", method = RequestMethod.GET)
	public Artist returnArtist(@PathVariable(name = "artistId") String artistName) {
		return artistRepo.findByArtistName(artistName);
	}

	@RequestMapping(value = "/artists", method = RequestMethod.PUT)
	public Collection<Artist> editArtist(@RequestParam(value = "artistName") String artistName,
			@RequestParam(value = "artistId") Long artistId,
			@RequestParam(value = "album") String album,
			@RequestParam(value = "recordLabel") String recordLabel) {
		Artist artistToEdit = artistRepo.findByArtistName(artistName);
		if (artistToEdit != null) {
			artistToEdit.setArtistName(artistName);
			artistToEdit.setArtistId(artistId);
			artistToEdit.setAlbum(album);
			artistToEdit.setRecordLabel(recordLabel);
			artistToEdit = artistRepo.save(artistToEdit);
		}
		return (Collection<Artist>) artistRepo.findAll();
	}
	
	@RequestMapping(value = "/artists/{artistId}/albums", method = RequestMethod.DELETE)
	public String deleteAlbum(@PathVariable(name = "albumId") String albumName,
			@RequestParam(value = "albumId") Long albumId) {
		albumRepo.delete(albumId);
		return albumRepo.findByAlbumName(albumName).getAlbumName();
	}
	
	@RequestMapping(value = "/artists", method = RequestMethod.DELETE)
	public Collection<Artist> deleteArtist(@RequestParam(value = "artistId") Long artistId) {
		for (Album album : artistRepo.findByArtistId(artistId).getAlbums()) {
			albumRepo.delete(album);
		}
		artistRepo.delete(artistRepo.findByArtistId(artistId));
		System.out.println("Deleted Artist");
		return (Collection<Artist>) artistRepo.findAll();
	}
	
	@RequestMapping("/albums")
	public Collection<Album> getAlbums() {
		return (Collection<Album>) albumRepo.findAll();
	}
	
	@RequestMapping("/songs")
	public Collection<Song> getSongName() {
		return (Collection<Song>) songRepo.findAll();
	}

	@RequestMapping(value = "/albums", method = RequestMethod.POST)
	public Collection<Album> addAlbum(@RequestParam(value = "albumName") String albumName,
			@RequestParam(value = "albumId") Long albumId,
			@RequestParam(value = "albumReleaseDate") String albumReleaseDate,
			@RequestParam(value = "albumSongs") String albumSongs,
			@RequestParam(value = "albumGenre") String albumGenre,
			@RequestParam(value = "albumCoverImage") String albumCoverImage ) {

		if (albumRepo.findByAlbumName(albumName) == null) {
			albumRepo.save(new Album(albumName, albumId, albumReleaseDate, albumSongs, albumGenre, albumCoverImage));
		}

		return (Collection<Album>) albumRepo.findAll();
	}
	
	@RequestMapping(value = "/albums", method = RequestMethod.PUT)
	public Collection<Album> editAlbum(@RequestParam(value = "albumName") String albumName,
			@RequestParam(value = "albumId") Long albumId,
			@RequestParam(value = "albumReleaseDate") String albumReleaseDate,
			@RequestParam(value = "albumSongs") String albumSongs,
			@RequestParam(value = "albumGenre") String albumGenre,
			@RequestParam(value = "albumCoverImage") String albumCoverImage) {
		Album albumToEdit = albumRepo.findByAlbumName(albumName);
		if (albumToEdit != null) {
			albumToEdit.setAlbumName(albumName);
			albumToEdit.setAlbumId(albumId);
			albumToEdit.setAlbumReleaseDate(albumReleaseDate);
			albumToEdit.setAlbumSongs(albumSongs);
			albumToEdit.setAlbumGenre(albumGenre);
			albumToEdit.setAlbumCoverImage(albumCoverImage);
			albumToEdit = albumRepo.save(albumToEdit);
		}
		return (Collection<Album>) albumRepo.findAll();
	}

//			@RequestMapping(value = "/albums", method = RequestMethod.DELETE)
//			public Collection<Album> deleteAlbum(@RequestParam(value = "albumId") Long albumId) {
//				for (Song song : albumRepo.findByAlbumId(albumId).getSongs()) {
//					songRepo.delete(song);
//				}
//				songRepo.delete(albumRepo.findByAlbumId(albumId));
//				System.out.println("Deleted Album");
//				return (Collection<Album>) albumRepo.findAll();
//			}
//			
//	}
}




