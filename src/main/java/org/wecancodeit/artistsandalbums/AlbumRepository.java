package org.wecancodeit.artistsandalbums;

import org.springframework.data.repository.CrudRepository;

public interface AlbumRepository extends CrudRepository<Album, Long> {
	
	Album findByAlbumName (String albumName);

	Album findBySongName(String songName);

	Long findByAlbumId(Long albumId);
	
}
