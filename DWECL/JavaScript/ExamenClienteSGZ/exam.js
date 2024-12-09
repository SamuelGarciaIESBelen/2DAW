const fillCountries = () => {
	const select = document.querySelector("#countrySelect");
	
	countries.forEach(elem => {
		let option = document.createElement("option");
		option.setAttribute("value", elem);
		option.textContent = elem;
		
		select.appendChild(option);
	});
}

const fillGenders = () => {
	const gendersCont = document.querySelector("#genresContainer");

	genders.sort().forEach(elem => {
		gendersCont.innerHTML += `
		<input type="checkbox" name="genres" id="${elem}" value="${elem}">${elem}
		`
	});
}

const controlAllGenders = () => {
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
		
		/* const filteredMovies = pelis.filter(p => {
			for (let tf of textFilters) {
				if (tf === "Title") {
					
				}
			}
		});
		
		console.log(filteredMovies);
		
		return filteredMovies; */
	});
}

const createCards = (event) => {
	event.preventDefault();

	const searchRes = document.querySelector("#searchRes");
	const moviesContainer = document.querySelector("#movies");
	searchRes.innerHTML = `<b>${pelis.length}</b> results`;
	moviesContainer.innerHTML = "";

	pelis.forEach(p => {
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
			${p.Genre.split(',').map(g => `<p>${g.trim()}</p>`).join('')}
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
		<label for="imdbInput${p.imdbID}"> </label>
		<input type="text" id="imdbInput${p.imdbID}" value="${p.imdbRating || ''}">
		<button id="update${p.imdbID}">Update</button>
	</div>
	<div>
		<pre>${JSON.stringify(p, null, 2)}</pre>
	</div>
	`;

	const btnUpdate = document.querySelector(`#update${p.imdbID}`);
	btnUpdate.addEventListener("click", () => {
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
fillGenders();
controlAllGenders();
fillYears("yearBegin");
fillYears("yearEnd");
document.querySelector("#search").addEventListener("click", createCards);