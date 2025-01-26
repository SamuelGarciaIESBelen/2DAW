const cargarProductos = () => {
	productsContainer = document.querySelector("#productos");
	products.forEach(p => {
		let producto = document.createElement("div");

		producto.classList.add("col-3", "d-flex", "flex-column", "border", "border-dark", "rounded", "p-0", "m-3");
		
		producto.innerHTML = `
			<img src="${p.imagen}" height="200px">
			<div class="p-3">
				<h4>${p.nombre}</h4>
				<p>Precio: ${parseFloat(p.precio)} €</p><span id="stock${p.id}"></span>
				<input class="cantidad form-control mb-3" type="number" name="cantidad" id="cantidad${p.id}" min="1" max="${p.stock}" value="1">
				<button class="comprar btn btn-success" id="comprar${p.id}">Comprar</button>
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
	
	/* tr.innerHTML = `
	<td>
		<button class="mas btn btn-sm btn-primary">+</button>
		<span id="cantidadCarrito${producto.id}">&nbsp; 1 &nbsp;</span>
		<button class="menos btn btn-sm btn-primary">-</button>
	</td>
	<td> ${producto.nombre} </td>
	<td> ${parseFloat(producto.precio)} € </td>
	<td> ${parseFloat(producto.precio)} € </td>
	<td>
		<button class="eliminar btn btn-danger" id="eliminar${producto.id}">Eliminar</button>
	</td>
	`; */
	
	let cantidad = document.querySelector(`#cantidad${producto.id}`).value;
	
	let celdaCantidad = document.createElement("td");
	celdaCantidad.innerHTML = `
		<button class="btn btn-sm btn-primary" id="mas${producto.id}">+</button>
		<span id="cantidadCarrito${producto.id}">${cantidad}</span>
		<button class="btn btn-sm btn-primary" id="menos${producto.id}">-</button>
	`;
	
	let nombre = document.createElement("td");
	nombre.innerHTML = producto.nombre;
	
	let precio = document.createElement("td");
	precio.innerHTML = parseFloat(producto.precio);
	
	let total = document.createElement("td");
	total.classList.add("total");
	total.innerHTML = parseFloat(producto.precio) * cantidad;
	
	let accion = document.createElement("td");
	accion.innerHTML = `<button class="eliminar btn btn-danger" id="eliminar${producto.id}">Eliminar</button>`;
	
	tr.appendChild(celdaCantidad);
	tr.appendChild(nombre);
	tr.appendChild(precio);
	tr.appendChild(total);
	tr.appendChild(accion);

	tbody.appendChild(tr);
	
	document.querySelector(`#mas${producto.id}`).addEventListener("click", () => {
		if (document.querySelector(`#cantidadCarrito${producto.id}`).innerHTML < producto.stock) {
			document.querySelector(`#cantidadCarrito${producto.id}`).innerHTML++;
		}
	});
	
	document.querySelector(`#menos${producto.id}`).addEventListener("click", () => {
		if (document.querySelector(`#cantidadCarrito${producto.id}`).innerHTML > 1) {
			document.querySelector(`#cantidadCarrito${producto.id}`).innerHTML--;
		}
	});

	let spanTotal = document.querySelector("#total");
	let spanTotalValue = parseFloat(total.innerHTML);
	
	accion.addEventListener("click", () => {
		tr.innerHTML = "";
		spanTotal.innerHTML = "";
	});

	spanTotal.innerHTML += spanTotalValue;
}

document.addEventListener("DOMContentLoaded", () => {
	cargarProductos();
	document.querySelectorAll(".comprar").forEach(e => {
		e.addEventListener("click", insertarFilaCarrito);
	});
});