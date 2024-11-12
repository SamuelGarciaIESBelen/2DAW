let comunidad;
let provincia;

const resetSelect = (id, nombre) => {
	document.querySelector(id).innerHTML = "";
	
	let option = document.createElement("option");
	option.setAttribute("value", "pred");
	option.textContent = "Seleccione una " + nombre;

	document.querySelector(id).appendChild(option);
}

const selectComunidad = (provincias) => {
	for (comunidad of provincias) {
		let option = document.createElement("option");
		option.setAttribute("value", comunidad.code);
		option.textContent = comunidad.label;

		document.querySelector("#comunidad").appendChild(option);
	}
}

const selectProvincia = (event) => {
	comunidad = provincias.find(c => c.code == event.target.value)
	resetSelect("#provincia", "provincia");
	resetSelect("#localidad", "localidad");
	
	if (event.target.value) {
		for (provincia of comunidad.provinces) {
			let option = document.createElement("option");
			option.setAttribute("value", provincia.code);
			option.textContent = provincia.label;
			
			document.querySelector("#provincia").appendChild(option);
		}
	}
}

const selectLocalidad = (event) => {
	provincia = comunidad.provinces.find(p => p.code == event.target.value)
	resetSelect("#localidad", "localidad");
	
	if (event.target.value) {
		for (localidad of provincia.towns) {
			let option = document.createElement("option");
			option.setAttribute("value", localidad.code);
			option.textContent = localidad.label;
			
			document.querySelector("#localidad").appendChild(option);
		}
	}
}

selectComunidad(provincias);
document.querySelector("#comunidad").addEventListener("change", selectProvincia);
document.querySelector("#provincia").addEventListener("change", selectLocalidad);