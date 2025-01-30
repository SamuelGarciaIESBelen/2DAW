const tasks = [
	{ title: "Task to complete 1", date: "2025-02-08", priority: "medium", priorityID: 2, completed: false },
	{ title: "Task to complete 2", date: "2025-02-05", priority: "low", priorityID: 1, completed: false },
	{ title: "Task to complete 3", date: "2025-02-03", priority: "high", priorityID: 3, completed: false },
];

const showConsoleBtn = document.querySelector(".showConsole");
const form = document.querySelector("form");
const divTareas = document.querySelector(".divTareas");

const showConsole = () => {
	console.log(tasks);
}

const showTasks = () => {	
	divTareas.innerHTML = "";
	
	// Lo he tenido que ordenar así porque la versión que suelo usar: "(a, b) => a.priorityID > b.priorityID" no funcionaba
	tasks.sort((a, b) => {
		let res = 0;
		if (a.priorityID < b.priorityID) { res = 1; }
		if (a.priorityID > b.priorityID) { res = -1; }

		return res;
	})
	.forEach(t => {
		if (!t.completed) {
			divTareas.innerHTML += `
				<div class="col-3 border border-dark rounded-5 text-center p-4 m-3">
					<h4 class="mb-5">${t.title}</h4>
					<p class="fs-5">${t.date}</p>
					<p class="fs-5">Priority: <span class="spanPriority fw-bold">${t.priority.toUpperCase()}</span></p>
					<button class='editBtn btn btn-sm btn-primary'>Edit</button>
					<button class='deleteBtn btn btn-sm btn-danger'>Delete</button>
					<button class='completeBtn btn btn-sm btn-success mt-2'>Complete</button>
				</div>
			`;
		}
	});

	// Color prioridad
	document.querySelectorAll(".spanPriority").forEach(p => {
		if (p.textContent === "HIGH") {
			p.classList.remove("text-warning");
			p.classList.remove("text-success");
			p.classList.add("text-danger");
		} else if (p.textContent === "MEDIUM") {
			p.classList.remove("text-danger");
			p.classList.remove("text-success");
			p.classList.add("text-warning");
		} else {
			p.classList.remove("text-danger");
			p.classList.remove("text-warning");
			p.classList.add("text-success");
		}
	});

	document.querySelectorAll(".editBtn").forEach(b => b.addEventListener("click", editTask));
	document.querySelectorAll(".deleteBtn").forEach(b => b.addEventListener("click", deleteTask));
	document.querySelectorAll(".completeBtn").forEach(b => b.addEventListener("click", completeTask));
}

const controlForm = () => {
	
	document.querySelector("#titleInput").addEventListener("input", (e) => {
		if (!(e.target.value.length >= 10 && e.target.value.length <= 50)) {
			document.querySelector("#titleInput").classList.add("border-danger");
			document.querySelector(".titleWrong").classList.remove("d-none");
		} else {
			document.querySelector("#titleInput").classList.remove("border-danger");
			document.querySelector(".titleWrong").classList.add("d-none");
		}
	});
	
	document.querySelector("#dateInput").addEventListener("input", (e) => {
		
		// No he dado con la tecla
		console.log(new Date().toLocaleDateString());
		
		if (e.target.value > new Date()) {
			document.querySelector("#dateInput").classList.add("border-danger");
			document.querySelector(".dateWrong").classList.remove("d-none");
		} else {
			document.querySelector("#dateInput").classList.remove("border-danger");
			document.querySelector(".dateWrong").classList.add("d-none");
		}
	});
}

const addTask = (e) => {
	e.preventDefault();

	let title = document.querySelector("#titleInput").value;
	let date = document.querySelector("#dateInput").value;
	let priority = document.querySelectorAll("input[name='priorityInput']:checked")[0].value;

	console.log("Task info: ", title, date, priority);
	
	let priorityID;
	if (priority === "high") { priorityID = 3; }
	else if (priority === "medium") { priorityID = 2; }
	else { priorityID = 1; }
	
	let titles = tasks.map(t => t.title);

	if (document.querySelector("#titleInput").classList.contains("border-danger")) {
		alert("You can't add this task");
	} else if (titles.includes(title)) {
		alert("This task already exists");
	} else {
		tasks.push({ title, date, priority, priorityID, completed: false });
		showTasks();
	}
}

const editTask = (e) => {
	let title = document.querySelector("#titleInput");
	let date = document.querySelector("#dateInput");
	let priority = Array.from(document.querySelectorAll("input[name='priorityInput']"));
	
	// No me ha dado tiempo
	tasks.forEach(t => {
		if (t.title === e.target.parentElement.firstElementChild.textContent) {
			title.value = t.title;
			date.value = t.date;
			if (priority.value === t.priority) {
				priority.checked = true;
			}
		}
	});
}

const deleteTask = (e) => {
	console.log(e.target.parentElement.firstElementChild.textContent);
	
	tasks.forEach(t => {
		if (t.title === e.target.parentElement.firstElementChild.textContent) {
			if (confirm("Are you sure you want to delete this task?")) { tasks.splice(tasks.indexOf(t), 1) }
		}
	});

	showTasks();
}

const completeTask = (e) => {
	tasks.forEach(t => {
		if (t.title === e.target.parentElement.firstElementChild.textContent) {
			t.completed = true;
		}
	});
	
	showTasks();
}

document.addEventListener("DOMContentLoaded", () => {
	showTasks();
	showConsoleBtn.addEventListener("click", showConsole);
	controlForm();
	form.addEventListener("submit", addTask);
});