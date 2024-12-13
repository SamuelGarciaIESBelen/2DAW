const cargarProductos = () => {
	productsContainer = document.querySelector("#productos");
	products.forEach(p => {
		let producto = document.createElement("div");
		let cont = 0;

		producto.innerHTML = `
		<div class="d-flex flex-column border border-dark rounded mr-3 mb-3">
			<img src="${p.imagen}" height="200px">
			<div class="p-3">
				<h4>${p.nombre}</h4>
				<p>Precio: ${parseFloat(p.precio)} €</p><span id="stock${cont++}"></span>
				<input class="cantidad form-control mb-3" type="number" name="cantidad" id="cantidad${cont++}" min="1" max="${p.stock}">
				<button class="comprar btn btn-success w-50" id="comprar${cont++}">Comprar</button>
			</div>
		</div>
		`;

		productsContainer.appendChild(producto);
	});
}

const controlInput = () => {
	const input = document.querySelectorAll(".cantidad").forEach(e => {
		e.addEventListener("input", () => {
			
		});
	});
}

const insertarFilaCarrito = (e) => {
	const tbody = document.querySelector("#carrito");
	const div = e.target.parentElement;
	let producto;
	products.forEach(p => {
		if (div.firstElementChild.innerHTML === p.nombre) {
			producto = p;
		}
	});
	
	let tr = document.createElement("tr");
	let cont = 0;

	let cantidad = document.createElement("td");
	cantidad.innerHTML = `
	<button class="mas">+</button> <span id="cantidadCarrito${cont++}">1</span> <button class="menos">-</button>
	`;
	
	let nombre = document.createElement("td");
	nombre.innerHTML = producto.nombre;
	
	let precio = document.createElement("td");
	precio.innerHTML = parseFloat(producto.precio) + " €";
	
	let total = document.createElement("td");
	/* total.innerHTML = (producto.precio + parseFloat(document.querySelector(`#cantidadCarrito${cont++}`).textContent)) + " €"; */
	total.innerHTML = parseFloat(producto.precio) + " €"; /* Para que al menos enseñe algo */
	
	let accion = document.createElement("td");
	accion.innerHTML = `<button class="eliminar btn btn-danger" id="eliminar${cont++}">Eliminar</button>`;
	
	tr.appendChild(cantidad);
	tr.appendChild(nombre);
	tr.appendChild(precio);
	tr.appendChild(total);
	tr.appendChild(accion);
	tbody.appendChild(tr);
	
	let spanTotal = document.querySelector("#total");
	
	accion.addEventListener("click", () => {
		tr.innerHTML = "";
		spanTotal.innerHTML = "";
	});

	spanTotal.innerHTML += parseFloat(producto.precio);
}

document.addEventListener("DOMContentLoaded", () => {
	cargarProductos();
	document.querySelectorAll(".comprar").forEach(e => {
		e.addEventListener("click", insertarFilaCarrito);
	});
});