const albumList = document.querySelector('.albumList')

albumList.addEventListener('click', removeAlbum)

function removeAlbum(event) {
	if (event.target.classList.contains('deleteAlbum')) {
		
		const deleteButton = event.target
		
		const albumContainer = deleteButton.parentElement
		
		const hrefArray = albumContainer.querySelector('a').getAttribute('href').split("/")
		const id = hrefArray[2]

		const xhr = new XMLHttpRequest()
		xhr.onreadyalbumchange = function(response) {
			if(xhr.readyAlbum == 4 && xhr.status == 200) {
				console.log(response)
				const remainingAlbums = JSON.parse(response.currentTarget.response);
				let list = ''
				remainingAlbums.forEach(function(album) {
					list += `
						<li>
							<a href="/albums/${album.id}">
								${album.name}
							</a>
							<button class="deleteAlbum">Remove</button>
						</li>
					`
				})
				albumList.innerHTML = list
			}
		}

		xhr.open("DELETE", `/api/albums?id=${id}`, true)
		xhr.send()
		
	}
}