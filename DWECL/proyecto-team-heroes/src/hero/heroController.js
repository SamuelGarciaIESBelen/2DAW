const heroes = [
	{
		"id": 1,
		"heroName": "Batman",
		"secretId": "Bruce Wayne",
		"gender": "Hombre",
		"height": 188,
		"powers": false,
		"team": 1
	},
	{
		"id": 2,
		"heroName": "Superman",
		"secretId": "Clark Kent / Kal-El",
		"gender": "Hombre",
		"height": 191,
		"powers": true,
		"team": 1
	},
	{
		"id": 3,
		"heroName": "Nightwing",
		"secretId": "Dick Grayson",
		"gender": "Hombre",
		"height": 178,
		"powers": false,
		"team": 3
	},
	{
		"id": 4,
		"heroName": "Raven",
		"secretId": "Rachel Roth",
		"gender": "Mujer",
		"height": 165,
		"powers": true,
		"team": 3
	},
	{
		"id": 5,
		"heroName": "Capitán América",
		"secretId": "Steve Rogers",
		"gender": "Hombre",
		"height": 188,
		"powers": true,
		"team": 2
	},
	{
		"id": 6,
		"heroName": "Spiderman",
		"secretId": "Peter Parker",
		"gender": "Hombre",
		"height": 173,
		"powers": true,
		"team": 2
	},
	{
		"id": 7,
		"heroName": "Wolverine",
		"secretId": "James Howlett",
		"gender": "Hombre",
		"height": 160,
		"powers": true,
		"team": 4
	},
	{
		"id": 8,
		"heroName": "Cyclops",
		"secretId": "Scott Summers",
		"gender": "Hombre",
		"height": 191,
		"powers": true,
		"team": 4
	},
	{
		"id": 9,
		"heroName": "Mr. Fantastic",
		"secretId": "Reed Richards",
		"gender": "Hombre",
		"height": 182,
		"powers": true,
		"team": 5
	},
	{
		"id": 10,
		"heroName": "Antorcha Humana",
		"secretId": "Jhonny Storm",
		"gender": "Hombre",
		"height": 178,
		"powers": true,
		"team": 5
	}
]

const teams = {
    1: "Justice League",
    2: "Avengers",
    3: "Teen Titans",
    4: "X-Men",
	5: "4 Fantásticos"
};


const heroesList = document.querySelector(".heroes-list");

let showList = () => {
	heroesList.innerHTML = "";

	heroes.forEach(hero => {
		const card = document.createElement("div");
		card.classList.add("card");

		card.innerHTML = `
		<h2>${hero.heroName}</h2>
		<p><strong>Nombre:</strong> ${hero.secretId}</p>
		<p><strong>Género:</strong> ${hero.gender}</p>
		<p><strong>Altura:</strong> ${hero.height} cm</p>
		<p><strong>Poderes:</strong> ${hero.powers ? "Sí" : "No"}</p>
		<p><strong>Equipo:</strong> ${teams[hero.team] || "Sin equipo"}</p>
		<div class="btn-container">
			<button class="edit-btn"><a href="./editHero.html">Editar</a></button>
			<button class="delete-btn">Eliminar</button>
		</div>
		`
		heroesList.appendChild(card);
	});
}

showList();