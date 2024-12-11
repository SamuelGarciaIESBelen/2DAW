// Ejercicio 1
const salaries = {
	"Jhon": 100,
	"Pete": 300,
	"Mary": 250
}

const sumSalaries = () => {
	let sum = 0;
	
	console.log("There are " + Object.keys(salaries).length + " properties in salaries");
	
	sum = Object.values(salaries).reduce((curr, acc) => curr + acc,);
	console.log("Salaries go up to " + sum);
	
	console.log("\nEmployees sorted:");
	for (const [k, v] of Object.entries(salaries).sort()) {
		console.log(k, v);
	}
}
//sumSalaries();


//Ejercicio 2
const person = {
	"Nombre": "Samuel",
	"Edad": 23,
	"Aficiones": ["Videojuegos", "Deporte", "Lectura", "Viajar", "Series", "Películas", "Anime", "Manga", "Senderismo"],
	"Emancipado": false,
	"Aprobado": true
}
const inputs = {
	"string": "text",
	"number": "number",
	"boolean": "checkbox"
}

// Comprobaciones
/* console.log(Object.entries(person));
console.log(Object.entries(person).map(p => typeof p[1]));
console.log(Array.isArray(Object.entries(person)[2][1]));
console.log(Object.keys(inputs)[0]); */

const renderForm = () => {
	const form = document.querySelector("form");
	
	Object.entries(person).forEach(p => {
		let input = document.createElement("div");
		input.innerHTML = "";
	
		for (const i in inputs) {
			if (typeof p[1] === i && inputs[i] !== "checkbox") {
				input.innerHTML = `
					<div class="d-flex align-items-center mb-3">
						<label class="me-3" for="${p[0]}">${p[0]}</label>
						<input class="form-control" type="${inputs[i]}" name="${p[0]}" id="${p[0]}" value="${p[1]}">
					</div>
				`;
			} else if (typeof p[1] === i && "checkbox") {
				input.innerHTML = `
					<div class="d-flex align-items-center mb-3">
						<label class="me-3" for="${p[0]}">${p[0]}</label>
						<input type="${inputs[i]}" name="${p[0]}" id="${p[0]}">
					</div>
				`;
				if (p[1]) {
					input.innerHTML = `
					<div class="d-flex align-items-center mb-3">
						<label class="me-3" for="${p[0]}">${p[0]}</label>
						<input class="" type="${inputs[i]}" name="${p[0]}" id="${p[0]}" checked>
					</div>
					`;
				}
			}
		}

		if (Array.isArray(p[1])) {
			input.innerHTML = `
			<div class="d-flex align-items-center mb-3">
				<label class="me-3" for="${p[0]}">${p[0]}</label>
				<select class="form-select" name="${p[0]}" id="${p[0]}"/>
					${p[1].map(e => `<option value="${e}">${e}</option>`)}
				</select>
			</div>
			`;
		}
		form.appendChild(input);
	});
}

document.addEventListener("DOMContentLoaded", renderForm);