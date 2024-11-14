const fillAccordion = (provincias) => {
	let div = document.querySelector(".accordion-item");
	let header = document.createElement("h2");
	let body = document.createElement("div");

	for (let c of provincias) {
		// Añadir el encabezado del acordeón
		header.classList.add("accordion-header");
		
		let comunidad = document.createElement("button");
		comunidad.classList.add("accordion-button", "collapsed");
		comunidad.setAttribute("type", "button");
		comunidad.setAttribute("data-bs-toggle", "collapse");
		comunidad.setAttribute("data-bs-target", `.${c.label}`);
		comunidad.textContent = c.label;

		header.appendChild(comunidad);

		// Añadir el contenido del acordeón
		body.classList.add(c.label, "accordion-collapse", "collapse");
		body.setAttribute("data-bs-parent", "#provincias");

		let acbody = document.createElement("div");
		acbody.classList.add("accordion.body");
		acbody.textContent = "Prueba";

		body.appendChild(acbody);
	}
	div.appendChild(header);
	div.appendChild(body);

	document.querySelector(".accordion").appendChild(div);
}

/*
<div class="accordion-item">
	<h2 class="accordion-header">
		<button class="accordion-button collapsed" type="button" data-bs-toggle="collapse"
			data-bs-target=".collapseOne"> <!-- Quitar collapsed para que se active -->
			Accordion Item #1
		</button>
	</h2>
	<div class="accordion-collapse collapse" data-bs-parent="#accordionExample"> <!-- Añadir show para mostrar el contenido -->
		<div class="accordion-body">
			<strong>This is the first item's accordion body.</strong> It is shown by default, until the collapse
			plugin adds the appropriate classes that we use to style each element. These classes control the
			overall appearance, as well as the showing and hiding via CSS transitions. You can modify any of
			this with custom CSS or overriding our default variables. It's also worth noting that just about any
			HTML can go within the <code>.accordion-body</code>, though the transition does limit overflow.
		</div>
	</div>
*/

fillAccordion(provincias);