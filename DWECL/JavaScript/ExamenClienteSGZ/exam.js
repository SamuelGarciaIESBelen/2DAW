const fillCountries = () => {
	const select = document.querySelector("#countrySelect");
	
	countries.forEach(elem => {
		let option = document.createElement("option");
		option.setAttribute("value", elem);
		option.textContent = elem;
		
		select.appendChild(option);
	});
}

const fillGenres = () => {
	const genresCont = document.querySelector("#genresContainer");

	genders.sort().forEach(elem => {
		genresCont.innerHTML += `
		<input type="checkbox" name="genres" id="${elem}" value="${elem}">${elem}
		`
	});
}

const controlAllGenres = () => {
	const genresContainer = document.getElementById("genresContainer");
	const allCheckbox = document.getElementById("all");
	const checkboxes = genresContainer.querySelectorAll("input[name='genres']:not(#all)");

	allCheckbox.addEventListener("change", () => {
		checkboxes.forEach(checkbox => {
			checkbox.checked = allCheckbox.checked;
		});
	});

	genresContainer.addEventListener("change", (event) => {
		if (event.target.name === "genres" && event.target.id !== "all") {
			const allSelected = [...checkboxes].every(check => check.checked);
			allCheckbox.checked = allSelected;
		}
	});
}

const fillYears = (id) => {
	const select = document.querySelector(`#${id}`);
	const yearEnd = new Date().getFullYear();
	const yearBegin = 2000;
 
	for (let year = yearEnd; year >= yearBegin; year--) {
		let option = document.createElement("option");
		option.setAttribute("value", year);
		option.textContent = year;
		
		select.appendChild(option);		
	}
}

const filterMovies = () => {
	const form = document.querySelector("form");
	
	form.addEventListener("submit", () => {

		const textInput = document.querySelector("#textInput").value.toLowerCase();
		const textFilters = [...document.querySelectorAll("input[name='textFilter']")].filter(check => check.checked).map(check => check.value);
		const selectedCountry = document.querySelector("#countrySelect").value;
		const selectedGenres = [...document.querySelectorAll("input[name='genres']")].filter(check => check.checked).map(check => check.value);
		const yearBegin = document.querySelector("#yearBegin").value;
		const yearEnd = document.querySelector("#yearEnd").value;

		console.log(textInput);
		console.log(textFilters);
		console.log(selectedCountry);
		console.log(selectedGenres);
		console.log("From " + yearBegin + " to " + yearEnd);
		
		if (!textInput) {
			alert("Text is required");
		}

		const filteredMovies = pelis.filter(p => {
			const country = selectedCountry === "all" || p.Country.includes(selectedCountry);
			const genres = selectedGenres.length === 0 || selectedGenres.some(g => p.Genre.includes(g));
			const year = (!isNaN(yearBegin) ? parseInt(p.Year) >= yearBegin : true) &&
				(!isNaN(yearEnd) ? parseInt(p.Year) <= yearEnd : true);
	
			let checkboxes = [];
			const titleCB = document.getElementById("checkTitulo").checked;
			const directorCB = document.getElementById("checkDirector").checked;
			const actorCB = document.getElementById("checkActors").checked;
	
			if (titleCB) { checkboxes.push(p.Title.toLowerCase().includes(textInput)); }
			if (directorCB) { checkboxes.push(p.Director.toLowerCase().includes(textInput)); }
			if (actorCB) { checkboxes.push(p.Actors.toLowerCase().includes(textInput)); }
	
			const text = checkboxes.length === 0 || checkboxes.includes(true);
	
			return country && genres && year && text;
		});
		return filteredMovies;
	});
}

const createCards = () => {
	const moviesContainer = document.querySelector("#movies");
	moviesContainer.innerHTML = "";
			
	const textInput = document.querySelector("#textInput").value.toLowerCase();
	const textFilters = [...document.querySelectorAll("input[name='textFilter']")].filter(check => check.checked).map(check => check.value);
	const selectedCountry = document.querySelector("#countrySelect").value;
	const selectedGenres = [...document.querySelectorAll("input[name='genres']")].filter(check => check.checked).map(check => check.value);
	const yearBegin = document.querySelector("#yearBegin").value;
	const yearEnd = document.querySelector("#yearEnd").value;
	
	console.log(textInput);
	console.log(textFilters);
	console.log(selectedCountry);
	console.log(selectedGenres);
	console.log("From " + yearBegin + " to " + yearEnd);
	
	if (!textInput) {
		alert("Text is required");
		return;
	}
	
	const filteredMovies = pelis.filter(p => {
		const country = selectedCountry === "all" || (p.Country.includes(selectedCountry));
		const genres = selectedGenres.length === 0 || selectedGenres.some(g => p.Genre.includes(g));
		const year = (!isNaN(yearBegin) ? parseInt(p.Year) >= yearBegin : true) &&
		(!isNaN(yearEnd) ? parseInt(p.Year) <= yearEnd : true);
		
		let checkboxes = [];
		const titleCB = document.querySelector("#title").checked;
		const directorCB = document.querySelector("#director").checked;
		const actorCB = document.querySelector("#actor").checked;
		
		if (titleCB) { checkboxes.push(p.Title.toLowerCase().includes(textInput)); }
		if (directorCB) { checkboxes.push(p.Director.toLowerCase().includes(textInput)); }
		if (actorCB) { checkboxes.push(p.Actors.toLowerCase().includes(textInput)); }
		
		const text = checkboxes.length === 0
        ? (p.Title && p.Title.toLowerCase().includes(textInput)) ||
          (p.Director && p.Director.toLowerCase().includes(textInput)) ||
          (p.Actors && p.Actors.toLowerCase().includes(textInput))
        : checkboxes.includes(true);
		
		return country && genres && year && text;
	});
	
	const searchRes = document.querySelector("#searchRes");
	searchRes.innerHTML = `<b>${filteredMovies.length}</b> results`;
	
	filteredMovies.forEach(p => {
		const card = document.createElement("div");
		card.classList.add("card");
		card.setAttribute("id", `${p.imdbID}`);
		
		card.innerHTML = `
		<h3>${p.Title}</h3>
		<div>
			<img src="${p.Images[1]}" height="200px">
		</div>
		<div><button id="details${p.imdbID}">Details</button></div>
		<div id="cardGenres">
			${p.Genre.split(",").map(g => `<p>${g.trim()}</p>`).join("")}
		</div>
		<div class="detailsContainer" id="detailsContainer${p.imdbID}"></div>
		`;
		
		moviesContainer.appendChild(card);

		document.querySelector(`#details${p.imdbID}`).addEventListener("click", () => {
			showDetails(p);
			card.style.backgroundColor = "skyblue";
		});
	});
}

const showDetails = (p) => {
	const btnDetails = document.querySelector(`#details${p.imdbID}`);
	btnDetails.disabled = true;

	const details = document.querySelector(`#detailsContainer${p.imdbID}`);

	details.innerHTML = `
	<div id="imdbR">
		<h4>IMDb Rating</h4>
		<button id="close${p.imdbID}">X</button>
	</div>
	<div id="imdbRInput">
		<label for="imdbInput${p.imdbID}"></label>
		<input type="text" id="imdbInput${p.imdbID}" value="${p.imdbRating || ''}">
		<button id="update${p.imdbID}">Update</button>
	</div>
	<div>
		<pre>${JSON.stringify(p, null, 2)}</pre>
	</div>
	`;

	document.querySelector(`#imdbInput${p.imdbID}`).addEventListener("input", (event) => {
		const pattern = /^[0-9]?(\.[0-9]?)?$/;
		const input = event.target;

		if (!pattern.test(input.value)) {
			input.value = input.value.slice(0, -1);
		}
	});

	document.querySelector(`#update${p.imdbID}`).addEventListener("click", () => {
		const newRating = document.querySelector(`#imdbInput${p.imdbID}`).value;
		p.imdbRating = newRating;
		showDetails(p);
	});

	document.querySelector(`#close${p.imdbID}`).addEventListener("click", () => {
		btnDetails.disabled = false;
		details.innerHTML = "";
		const card = document.querySelector(`#${p.imdbID}`);
		card.style.backgroundColor = "white";
	});
}

fillCountries();
fillGenres();
controlAllGenres();
fillYears("yearBegin");
fillYears("yearEnd");
document.querySelector("#search").addEventListener("click", (event) => {
	event.preventDefault();
	createCards();
});