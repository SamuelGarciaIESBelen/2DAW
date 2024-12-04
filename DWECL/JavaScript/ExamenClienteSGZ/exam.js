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
	
	form.addEventListener("submit", (event) => {
		event.preventDefault();

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

const createCards = () => {
	const searchRes = document.querySelector("#searchRes");
	const moviesContainer = document.querySelector("#movies");
	searchRes.textContent = `${pelis.length} results`;
	moviesContainer.innerHTML = "";

	pelis.forEach(p => {
		const card = document.createElement("div");
		card.classList.add("card");

		card.innerHTML = `
		<h3>${p.Title}</h3>
		<div>
			<img src="${p.Images[0]}" height="150px">
			<button id="details">Details</button>
		</div>
		<div>
			<p>${p.Genre}</p>
		</div>
		`;
		
		moviesContainer.appendChild(card);
	});
}

const showDetails = () => {

}

fillCountries();
fillGenders();
controlAllGenders();
fillYears("yearBegin");
fillYears("yearEnd");
filterMovies();
createCards();