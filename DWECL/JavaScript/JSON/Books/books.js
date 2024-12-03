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
		Object.values(l).forEach(value => {
			let td = document.createElement("td");
			td.textContent = value;
			tr.appendChild(td);
		});
		tbody.appendChild(tr);
	}
}
fillTable();

const genres = () => {
	let res = document.querySelector("#a1");
	res.innerHTML = "";
	const genres = [];

	libros.map(libro => libro.genero).forEach(genre => {
		for (let g of genre) {
			if (!genres.includes(g)) {
				genres.push(g);
			}
		}
	});

	// const genres = [...new Set(libros.flatMap(libro => libro.genero))];		

	res.innerHTML = genres.join(", ");
}

const moreThan300pages = () => {
	let res = document.querySelector("#a2");
	res.innerHTML = "";

	libros.filter(l => l.pags > 300)
		.forEach(l => res.innerHTML += `<p>${l.titulo}</p>`);
}

const moreThan2yearsAgo = () => {
	let res = document.querySelector("#a3");
	res.innerHTML = "";

	libros.filter(l => l.fecha < "2021")
		.forEach(l => res.innerHTML += `<p>${l.titulo}</p>`);
}

const authors = () => {
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
	let res = document.querySelector("#a5");
	res.innerHTML = "";

	libros.filter(l => l.leido)
		.sort((a, b) => new Date(a.fecha) - new Date(b.fecha))
		.forEach(l => res.innerHTML += `<p>${l.titulo} -- Published in ${l.fecha}</p>`)
}

document.querySelector("#ba1").addEventListener("click", genres);
document.querySelector("#ba2").addEventListener("click", moreThan300pages);
document.querySelector("#ba3").addEventListener("click", moreThan2yearsAgo);
document.querySelector("#ba4").addEventListener("click", authors);
document.querySelector("#ba5").addEventListener("click", booksRead);