submitButton.addEventListener('click', (event) => {
	event.preventDefault();

	const form = document.querySelector("form");
	const labels = form.getElementsByTagName("label");
	const inputs = form.getElementsByTagName("input");
	// const inputs = form.querySelectorAll("input, textarea, select, datalist");
	let counter = 0;
	let res = "";

	/* inputs.forEach(i => {
		let value;

		if (i.type == "checkbox" || i.type == "radio") {
			value = i.checked ? i.textContent : "";
		} else if (i.tagName == "select" || i.tagName == "datalist") {
			value = i.options[counter].textContent;
		} else {
			value = i.value;
		}

		if (value) {
			res += `<p><b>${labels[counter].textContent}</b>${inputs[counter].value}</p>`
		}
		counter++;
	}) */
	
	while (counter < inputs.length) {
		res += `<p><b>${labels[counter].textContent}</b>${inputs[counter++].value}</p>`
	}

	document.querySelector(".res").innerHTML = res;
})