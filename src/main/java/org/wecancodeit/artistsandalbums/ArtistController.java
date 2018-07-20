package org.wecancodeit.artistsandalbums;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ArtistController {
	
	@Autowired
	ArtistRepository artistRepo;

	@Autowired
	AlbumRepository albumRepo;

	@Autowired
	SongRepository songRepo;
	
	@RequestMapping("/")
	public String home() {
		return "redirect:/artists";
	}

	@RequestMapping("/artists")
	public String getArtists(Model model) {
		model.addAttribute("artists", artistRepo.findAll());
		return "artists";
	}

	@RequestMapping("/artists/{artistId}")
	public String getArtist(@PathVariable(name = "artistId") Long artistId, Model model) {
		model.addAttribute("artist", artistRepo.findByArtistId(artistId));
		return "artist";
	}
	
	@RequestMapping("/artists/{artistId}/albums/{albumId}")
	public String getAlbum(@PathVariable(name = "albumId") Long albumId, @PathVariable(name = "albumName") String albumName,
			Model model) {
		model.addAttribute("album", albumRepo.findOne(albumId));
		return "album";
	}
	
	@RequestMapping("/albums")
	public String getAlbums(Model model) {
		model.addAttribute("albums", albumRepo.findAll());
		return "albums";
	}
	
	@RequestMapping("/albums/{albumId}")
	public String getAlbum(@PathVariable(name = "albumId") Long albumId, Model model) {
		model.addAttribute("album", albumRepo.findByAlbumId(albumId));
		return "artist";
	}
	
	@RequestMapping("/albums/{albumId}/songs/{songId}")
	public String getSong(@PathVariable(name = "songId") Long songId, @PathVariable(name = "songName") String songName,
			Model model) {
		model.addAttribute("song", songRepo.findOne(songId));
		return "album";
	}
	
	@RequestMapping(value = "/artists/add-artist", method = RequestMethod.POST)
	public String addArtist(@RequestParam String artistName, @RequestParam Long artistId,
			@RequestParam String artistAlbum, @RequestParam String artistRecordLabel) {
		if (artistRepo.findByArtistId(artistId) == null) {
			Artist artistToAdd = artistRepo
					.save(new Artist(artistName, artistId, artistAlbum, artistRecordLabel));
		}

		return "redirect:/artists";
	}
	
	@RequestMapping(value = "/albums/add-album", method = RequestMethod.POST)
	public String addAlbum(@RequestParam String albumName, @RequestParam Long albumId,
			@RequestParam String albumReleaseDate, @RequestParam String albumSongs, String albumGenre, String albumCoverImage) {
		if (albumRepo.findByAlbumId(albumId) == null) {
			Album albumToAdd = albumRepo
					.save(new Album(albumName, albumId, albumReleaseDate, albumSongs, albumGenre, albumCoverImage));
		}

		return "redirect:/artists";
	}
}
