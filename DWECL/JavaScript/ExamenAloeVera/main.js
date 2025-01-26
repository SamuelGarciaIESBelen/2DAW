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

document.addEventListener("DOMContentLoaded", () => {
	cargarProductos();
    
});