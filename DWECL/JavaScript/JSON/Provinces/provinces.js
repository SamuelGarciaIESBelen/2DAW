const orderList = (order, direction, list) => {
	if (order === "name") {
		list.sort((a, b) => {
			return direction === "asc" ? a.label.localeCompare(b.label) : b.label.localeCompare(a.label);
		});
	} else if (order === "towns") {
		list.sort((a, b) => {
			const totalTownsA = a.provinces
				? a.provinces.reduce((sum, provincia) => sum + provincia.towns.length, 0)
				: a.towns.length;
			const totalTownsB = b.provinces
				? b.provinces.reduce((sum, provincia) => sum + provincia.towns.length, 0)
				: b.towns.length;
			
			return direction === "asc" ? totalTownsA - totalTownsB : totalTownsB - totalTownsA;
		});
	}
	return list;
}

const fillAccordion = (father, item, category) => {
	let totalTowns;

	if (category === "community") {
		totalTowns = item.provinces.reduce((sum, provincia) => sum + provincia.towns.length, 0);
	} else if (category === "province") {
		totalTowns = item.towns.length;
	}

	const div = document.createElement("div");
	div.classList.add("accordion-item");
	
	if (category === "community") {
		div.innerHTML = `
		<div class="accordion-item">
			<h2 class="accordion-header">
				<button class="accordion-button collapsed bg-secondary text-white" type="button" data-bs-toggle="collapse"
					data-bs-target="#${category}${item.code}" aria-expanded="false" aria-controls="${category}${item.code}">
					<div class="d-flex justify-content-between w-100 align-items-center">
						<div>
							<h3>${item.label}</h3>
							<p> <span>${(item.provinces) ? item.provinces.length : item.towns.length}</span> ${(item.provinces) ? "Provinces" : "Towns"}</p>
							</div>
						<span class="badge mx-2">${totalTowns} towns</span>
					</div>
				</button>
			</h2>
			<div id="${category}${item.code}" class="accordion-collapse collapse">
				<div class="accordion-body" id="${category}${item.code}">
				</div>
			</div>
		</div>`;
	} else if (category === "province") {
		div.innerHTML = `
		<div class="accordion-item">
			<h2 class="accordion-header">
				<button class="accordion-button collapsed bg-info" type="button" data-bs-toggle="collapse"
					data-bs-target="#${category}${item.code}" aria-expanded="false" aria-controls="${category}${item.code}">
					<div class="d-flex justify-content-between w-100 align-items-center">
						<div>
							<h3>${item.label}</h3>
							<p> <span>${(item.provinces) ? item.provinces.length : item.towns.length}</span> ${(item.provinces) ? "Provinces" : "Towns"}</p>
							</div>
						<span class="badge bg-primary mx-2">${totalTowns} towns</span>
					</div>
				</button>
			</h2>
			<div id="${category}${item.code}" class="accordion-collapse collapse">
				<div class="accordion-body" id="${category}${item.code}">
				</div>
			</div>
		</div>`;
	}

	father.appendChild(div);
}

const showAccordion = (order, direction) => {
	accordionCities.innerHTML = "";

	orderList(order, direction, provinces);

	provinces.forEach(community => {
		fillAccordion(accordionCities, community, "community");
		const provinceInt = document.querySelector("#community" + community.code);
		orderList(order, direction, community.provinces);

		community.provinces.forEach(province => {
			fillAccordion(provinceInt, province, "province");
			const towns = document.querySelector("#province" + province.code);
			
			const ul = document.createElement("ul");
			towns.appendChild(ul);

			province.towns.forEach(town => {
				const li = document.createElement("li");
				li.textContent = town.label;
				ul.appendChild(li);
			});
		});
	});
}

const order = document.querySelector("#orderBy");
const direction = document.querySelector("#orderDirection");

document.addEventListener("DOMContentLoaded", () => {
	showAccordion(order.value, direction.value);
});

document.querySelectorAll(".select-order").forEach(select => {
	select.addEventListener("change", (event) => {
		event.preventDefault();
		showAccordion(order.value, direction.value);
	});
});