const fillTable = () => {
	// Rellenar thead
	let thead = document.querySelector("thead");
	let tr = document.createElement("tr");
	
	Object.keys(libros[0]).forEach(value => {
		let th = document.createElement("th");
		th.textContent = value.toLocaleUpperCase();
		tr.appendChild(th);
	});
	thead.appendChild(tr);
	
	// Rellenar tbody
	let tbody = document.querySelector("tbody");
	
	for (let l of libros) {
		let tr = document.createElement("tr");
		tr.setAttribute("id", `${l.id}`)
		Object.values(l).forEach(value => {
			let td = document.createElement("td");
			td.textContent = value;
			tr.appendChild(td);
		});
		tbody.appendChild(tr);
	}
}
fillTable();

const clearHighlight = () => {
	const rows = document.querySelectorAll("tr");
	rows.forEach(r => r.classList.remove("table-info"));
}

const genres = () => {
	clearHighlight();
	let res = document.querySelector("#a1");
	res.innerHTML = "";
	const genres = [];

	libros.forEach(l => {
		l.genero.forEach(g => {
			if (!genres.includes(g)) {
				genres.push(g);
			}
		});
	});

	// const genres = [...new Set(libros.flatMap(libro => libro.genero))];		

	res.innerHTML = genres.join(", ");
}

const moreThan300pages = () => {
	clearHighlight();
	let res = document.querySelector("#a2");
	res.innerHTML = "";
	let tr;

	libros.filter(l => l.pags > 300)
		.forEach(l => {
			res.innerHTML += `<p>${l.titulo}</p>`
			tr = document.getElementById(`${l.id}`);
			tr.classList.add("table-info");
		});
}

const moreThan2yearsAgo = () => {
	clearHighlight();
	let res = document.querySelector("#a3");
	res.innerHTML = "";
	let tr;

	libros.filter(l => l.fecha < "2021")
		.forEach(l => {
			res.innerHTML += `<p>${l.titulo}</p>`;
			tr = document.getElementById(`${l.id}`);
			tr.classList.add("table-info");
		});
}

const authors = () => {
	clearHighlight();
	let res = document.querySelector("#a4");
	let autorNum = {};
	res.innerHTML = "";

	libros.forEach(l => {
		l.autor.forEach(a => {
			if (autorNum[a]) {
				autorNum[a]++;
			} else {
				autorNum[a] = 1;
			}
		});
	});

	for (a in autorNum) {
		res.innerHTML += `<p>${a} -- Books written: ${autorNum[a]}</p>`;
	}
}

const booksRead = () => {
	clearHighlight();
	let res = document.querySelector("#a5");
	res.innerHTML = "";
	let tr;

	libros.filter(l => l.leido)
		.sort((a, b) => new Date(a.fecha) - new Date(b.fecha))
		.forEach(l => {
			res.innerHTML += `<p>${l.titulo} -- Published in ${l.fecha}</p>`;
			tr = document.getElementById(`${l.id}`);
			tr.classList.add("table-info");
		});
}

document.querySelector("#ba1").addEventListener("click", genres);
document.querySelector("#ba2").addEventListener("click", moreThan300pages);
document.querySelector("#ba3").addEventListener("click", moreThan2yearsAgo);
document.querySelector("#ba4").addEventListener("click", authors);
document.querySelector("#ba5").addEventListener("click", booksRead);