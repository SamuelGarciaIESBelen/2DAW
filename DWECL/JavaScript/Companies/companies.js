const fillSelect = () => {
	const select = document.querySelector("#selectContinents");

	companies.forEach(elem => {
		let option = document.createElement("option");
		option.setAttribute("value", elem.continent);
		option.textContent = elem.continent;
		
		select.appendChild(option);
	});
}

const fillCountries = () => {
	let tbody = document.querySelector("#tableContinents");
	let selectValue = document.querySelector("#selectContinents").value;
	let countries = [];
	tbody.innerHTML = "";
	
	if (selectValue) {
		let continent = companies.find((c) => c.continent === selectValue);

		if (continent) {
			continent.countries.forEach((country) => {
				countries.push(country.name);
			});
		}
	} else {
		companies.forEach((continent) => {
			continent.countries.forEach((country) => {
				countries.push(country.name);
			});
		});
	}
	
	countries.sort();

	countries.forEach((c) => {
		let tr = document.createElement("tr");
		let td = document.createElement("td");
		
		td.textContent = c;
		tr.appendChild(td);
		tbody.appendChild(tr);
	});
}

const fillCompaniesNumber = () => {
	let tbody = document.querySelector("#tableContinents");
	let selectValue = document.querySelector("#selectContinents").value;
	let countries = [];
	tbody.innerHTML = "";
	
	if (selectValue) {
		let continent = companies.find((c) => c.continent === selectValue);

		if (continent) {
			continent.countries.forEach((country) => {
				countries.push(country);
			});
		}
	} else {
		companies.forEach((continent) => {
			continent.countries.forEach((country) => {
				countries.push(country);
			});
		});
	}
	
	countries.sort((a, b) => a.name.localeCompare(b.name));

	countries.forEach((c) => {
		let tr = document.createElement("tr");
		let tdCountry = document.createElement("td");
		let tdCompaniesNumber = document.createElement("td");

		tdCountry.textContent = c.name;
		tdCompaniesNumber.textContent = c.companies.length;
		
		tr.appendChild(tdCountry);
		tr.appendChild(tdCompaniesNumber);
		
		tbody.appendChild(tr);
	});
}

const fillCompaniesNames = () => {
	let tbody = document.querySelector("#tableContinents");
	let selectValue = document.querySelector("#selectContinents").value;
	let countries = [];
	tbody.innerHTML = "";
	
	if (selectValue) {
		let continent = companies.find((c) => c.continent === selectValue);

		if (continent) {
			continent.countries.forEach((country) => {
				countries.push(country);
			});
		}
	} else {
		companies.forEach((continent) => {
			continent.countries.forEach((country) => {
				countries.push(country);
			});
		});
	}
	
	countries.sort((a, b) => a.name.localeCompare(b.name));

	countries.forEach((c) => {
		let tr = document.createElement("tr");
		let tdCountry = document.createElement("td");
		let tdCompaniesNumber = document.createElement("td");
		let tdCompaniesNames = document.createElement("td");
		let companiesNames = c.companies.map(e => Object.keys(e)[0]);
		
		tdCountry.textContent = c.name;
		tdCompaniesNumber.textContent = c.companies.length;
		tdCompaniesNames.innerText = companiesNames.join("\n");
		
		tr.appendChild(tdCountry);
		tr.appendChild(tdCompaniesNumber);
		tr.appendChild(tdCompaniesNames);

		tbody.appendChild(tr);
	});
}

fillSelect();
fillCountries();
document.querySelector("#btn-countries").addEventListener("click", fillCountries);
document.querySelector("#btn-companies-number").addEventListener("click", fillCompaniesNumber);
document.querySelector("#btn-companies-names").addEventListener("click", fillCompaniesNames);