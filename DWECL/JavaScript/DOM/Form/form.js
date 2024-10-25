submitButton.addEventListener('click', (event) => {
	event.preventDefault();

	const form = document.querySelector("form");
	const labels = form.getElementsByTagName("label");
	const inputs = form.getElementsByTagName("input");
	let counter = 0;

	let full = true;
	for (let i = 0; i < inputs.length || full; i++) {
		if (inputs[i].value.trim() == "") {
			full = false;
		}
	}
	if (!full) {
		alert("All fields must be filled");
	}
	while (counter < inputs.length) {
		document.querySelector(".res").innerHTML += "<p><b>" + labels[counter].textContent + "</b> " + inputs[counter++].value + "</p>";
	}
})