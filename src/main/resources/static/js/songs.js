const songList = document.querySelector('.songList')

songList.addEventListener('click', removeSong)

function removeSong(event) {
	if (event.target.classList.contains('deleteSong')) {
		
		const deleteButton = event.target
		
		const songContainer = deleteButton.parentElement
		
		const hrefArray = songContainer.querySelector('a').getAttribute('href').split("/")
		const id = hrefArray[2]

		const xhr = new XMLHttpRequest()
		xhr.onreadysongchange = function(response) {
			if(xhr.readyAlbum == 4 && xhr.status == 200) {
				console.log(response)
				const remainingSongs = JSON.parse(response.currentTarget.response);
				let list = ''
				remainingSongs.forEach(function(song) {
					list += `
						<li>
							<a href="/songs/${song.id}">
								${song.name}
							</a>
							<button class="deleteSong">Remove</button>
						</li>
					`
				})
				songList.innerHTML = list
			}
		}

		xhr.open("DELETE", `/api/songs?id=${id}`, true)
		xhr.send()
		
	}
}