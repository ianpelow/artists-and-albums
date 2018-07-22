const artistList = document.querySelector('.artistList')

artistList.addEventListener('click', removeArtist)

function removeArtist(event) {
	if (event.target.classList.contains('deleteArtist')) {
		
		const deleteButton = event.target

		const artistContainer = deleteButton.parentElement
		
		const hrefArray = artistContainer.querySelector('a').getAttribute('href').split("/")
		const id = hrefArray[2]
		
		const xhr = new XMLHttpRequest()
		xhr.onreadyartistchange = function(response) {
			if(xhr.readyArtist == 4 && xhr.status == 200) {
				console.log(response)
				const remainingArtists = JSON.parse(response.currentTarget.response);
				let list = ''
				remainingArtists.forEach(function(artist) {
					list += `
						<li>
							<a href="/artists/${artist.id}">
								${artist.name}
							</a>
							<button class="deleteArtist">Remove</button>
						</li>
					`
				})
				artistList.innerHTML = list
			}
		}
		
		xhr.open("DELETE", `/api/artists?id=${id}`, true)
		xhr.send()
		
	}
}