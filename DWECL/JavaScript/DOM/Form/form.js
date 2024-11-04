submitButton.addEventListener('click', (event) => {
	event.preventDefault();

	const labels = document.getElementsByTagName("label");
	// const inputs = document.getElementsByTagName("input");
	const inputs = document.querySelectorAll("input, textarea, select, datalist");
	let res = document.querySelector(".res");
	let counter = 0;

	while (counter < inputs.length) {
		if (inputs[counter].type == "radio" || inputs[counter].type == "checkbox") {
			if (inputs[counter].checked) {
				res.innerHTML += `<p><b>${labels[counter].textContent}</b>${inputs[counter++].value}</p>`
			}
		}
		res.innerHTML += `<p><b>${labels[counter].textContent}</b>${inputs[counter++].value}</p>`
	}
})