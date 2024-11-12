const validate = () => {
	const namePattern = /^[A-Za-z]+$/;
	const dniPattern = /^\d{8}[A-Z]$/;

	if (!nombre.value || !namePattern.test(nombre.value)) {
		nombre.classList.add("is-invalid");
		return false;
	}
	if (!apellido1.value || !namePattern.test(apellido1.value)) {
		apellido1.classList.add("is-invalid");
		return false;
	}
	if (!dni.value || !dniPattern.test(dni.value)) {
		dni.classList.add("is-invalid");
		return false;
	}

	nombre.classList.remove("is-invalid");
	apellido1.classList.remove("is-invalid");
	dni.classList.remove("is-invalid");
	
	return true;
}

const addPerson = (event) => {
	event.preventDefault();
	
	const dni = document.querySelector("#dni");
	const auth = document.querySelector("#auth");
	let counter = document.querySelector("#counter");
	
	if (validate() && counter.textContent < 5) {
		let person = document.createElement("div");
		person.classList.add("fw-bold", "col-4", "mb-4");
		
		person.innerHTML = `
		<p>${nombre.value} ${apellido1.value} 
		${(apellido2.value) ? apellido2.value: ""}<br>
		${dni.value} ${tlf.value ? " - Tlf: " + tlf.value: ""}</p>
		`
		
		let borrar = document.createElement("button");
		borrar.classList.add("btn", "btn-danger");
		borrar.textContent = "-";
		person.appendChild(borrar);
		auth.appendChild(person);
		
		counter.textContent = parseInt(counter.textContent) + 1;
		borrar.addEventListener("click", (event) => {
			event.preventDefault();
			if (counter.textContent > 1) {
				person.remove();
				counter.textContent = parseInt(counter.textContent) - 1;
			}
		});
	}
}

document.querySelector("#add").addEventListener("click", addPerson);