let fillTable = (libros) => {
	const tbody = document.querySelector("tbody");

	for (let libro of libros) {
		let tr = document.createElement("tr");
		
		Object.values(libro).forEach(value => {
			let td = document.createElement("td");
			td.textContent = value;
			tr.appendChild(td);
		});
		tbody.appendChild(tr);
	}
}

// 1. Name of each of the genres
let p1 = (libros) => {
	const res = document.querySelector("#uno");
	let genres = [];
	res.innerHTML = "";
	
	libros.map(l => l.genero).forEach(genero => {
		for (g of genero) {
			if (!genres.includes(g)) {
				genres.push(g);
			}
		}
	})
	
	res.innerHTML = `<p>Genres are: ${genres}</p>`;
}

// 2. Title of books with more than 300 pages
let p2 = (libros) => {
	const res = document.querySelector("#dos");
	res.innerHTML = "";
	
	libros.filter(l => l.pags > 300)
		.forEach(l => res.innerHTML += `<p>${l.titulo}</p>`);
}

// 3. Title of books published more than 2 years ago
let p3 = (libros) => {
	const res = document.querySelector("#tres");
	res.innerHTML = "";

	libros.filter(l => l.fecha < "2022")
		.forEach(l => res.innerHTML += `<p>${l.titulo} - Published in ${l.fecha}</p>`);
}

// 4. Name of the authors and number of books they have written
let p4 = (libros) => {
	const res = document.querySelector("#cuatro");
	let autorNum = {};
	res.innerHTML = "";

	libros.forEach(l => { l.autor.forEach(a => {
			if (autorNum[a]) {
				autorNum[a]++;
			} else {
				autorNum[a] = 1;
			}
		});
	});
	
	for (autor in autorNum) {
		res.innerHTML += `<p>${autor} - Books written: ${autorNum[autor]}</p>`;
	}
}


// 5. Title of the books read, ordered by date of publishing
let p5 = (libros) => {
	let res = document.querySelector("#cinco");
	res.innerHTML = "";
	
	libros.sort((a, b) => new Date(a.fecha) - new Date(b.fecha))
		.filter(l => l.leido)
		.forEach(l => res.innerHTML += `<p>${l.titulo} - Published in ${l.fecha}</p>`);

}

fillTable(libros);
document.querySelector("#p1").onclick = () => p1(libros);
document.querySelector("#h1").onclick = () => document.querySelector("#uno").innerHTML = "";
document.querySelector("#p2").onclick = () => p2(libros);
document.querySelector("#h2").onclick = () => document.querySelector("#dos").innerHTML = "";
document.querySelector("#p3").onclick = () => p3(libros);
document.querySelector("#h3").onclick = () => document.querySelector("#tres").innerHTML = "";
document.querySelector("#p4").onclick = () => p4(libros);
document.querySelector("#h4").onclick = () => document.querySelector("#cuatro").innerHTML = "";
document.querySelector("#p5").onclick = () => p5(libros);
document.querySelector("#h5").onclick = () => document.querySelector("#cinco").innerHTML = "";