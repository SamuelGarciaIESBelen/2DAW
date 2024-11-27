const teams = [
	{
		"id": 1,
		"teamName": "Justice League",
		"leader": "Superman",
		"location": {
			"lat": 40.7128,
			"lon": -74.0060
		},
		"active": true,
		"heroes": [ 1, 2 ],
		/* "heroes": [ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10], */
	},
	{
		"id": 2,
		"teamName": "Vengadores",
		"leader": "Capitán América",
		"location": {
			"lat": 40.71,
			"lon": -74
		},
		"active": true,
		"heroes": [ 5, 6 ]
	},
	{
		"id": 3,
		"teamName": "Teen Titans",
		"leader": "Nightwing",
		"location": {
			"lat": 37.77,
			"lon": -122.41
		},
		"active": true,
		"heroes": [ 3, 4 ]
	},
	{
		"id": 4,
		"teamName": "X-Men",
		"leader": "Cyclops",
		"location": {
			"lat": 41.15,
			"lon": -73.77
		},
		"active": true,
		"heroes": [ 7, 8 ]
	},
	{
		"id": 5,
		"teamName": "4 Fantásticos",
		"leader": "Cyclops",
		"location": {
			"lat": 40.75,
			"lon": -73.98
		},
		"active": true,
		"heroes": [ 9, 10 ]
	}
]

const heroes = {
    1: "Batman", 
    2: "Superman", 
    3: "Nightwing", 
    4: "Raven", 
    5: "Captain America", 
    6: "Spiderman", 
    7: "Wolverine", 
    8: "Cyclops",
    9: "Mr. Fantastic",
    10: "Antorcha Humana"
}


const teamsList = document.querySelector(".teams-list");

let showList = () => {
	teamsList.innerHTML = "";

	teams.forEach(team => {
		const card = document.createElement("div");
		card.classList.add("card");

        let heroesList = "";
        if (team.heroes.length > 0) {
            heroesList = `<ul>${team.heroes.map(hero => `<li>&nbsp;${heroes[hero]}</li>`).join("")}</ul>`
        } else {
            heroesList = "&nbsp;Aún no hay héroes"
        }

		card.innerHTML = `
		<h2>${team.teamName}</h2>
		<p><strong>Líder:</strong> ${team.leader}</p>
		<p><strong>Localización:</strong> ${team.location.lat}, ${team.location.lon}</p>
		<p><strong>Activo:</strong> ${team.active ? "Sí" : "No"}</p>
		<p><strong>Héroes:</strong>${heroesList}</p>
		<div class="btn-container">
			<button class="edit-btn"><a href="./editTeam.html">Editar</a></button>
			<button class="delete-btn">Eliminar</button>
		</div>
		`
		teamsList.appendChild(card);
	});
}

showList();