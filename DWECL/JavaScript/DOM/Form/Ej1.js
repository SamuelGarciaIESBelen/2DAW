submitBtn.addEventListener('click', (event) => {
	event.preventDefault();

	const inputs = document.querySelectorAll("input, textarea, select, datalist");
	let res = document.querySelector(".res");
	res.innerHTML = "";

	for (let i of inputs) {
		if ((["radio", "checkbox"].includes(i.type) && i.checked) || !["radio", "checkbox"].includes(i.type)) {
			res.innerHTML += `<p><b>${i.name}:</b> ${i.value}</p>`
		}
	}
})

resetBtn.addEventListener("click", (event) => {
	let res = document.querySelector(".res");
	res.innerHTML = "";
})