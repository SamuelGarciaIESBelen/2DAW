const encabezado = document.getElementById("encabezado");
const tbody = document.getElementById("tbody");
const contador = document.getElementById("contador");

const start = document.getElementById("start");
const stop = document.getElementById("stop");
const pause = document.getElementById("pause");

let contadores = [];
let segundosGlobales = 0;

// Función para formatear el tiempo como mm:ss
function formatTime(segundos) {
    let min = Math.floor(segundos / 60);
    let sec = segundos % 60;
    return `${String(min).padStart(2, "0")}:${String(sec).padStart(2, "0")}`;
}

// Crea la tabla con las tareas
function crearTabla() {
    let nombres = "";
    let datosTarea = "";

    taskAll.taskList.forEach((task, index) => {
        nombres += `<th>${task.assignedTo}</th>`;
        datosTarea += `
            <td id="celda-${index}" class="task-cell">
                <strong>${task.task}</strong><br>
                <span id="duration-${index}">${formatTime(task.duration * 60)}</span> <br>
                <span id="break-${index}">${formatTime(task.break * 60)}</span>
            </td>
        `;
    });

    encabezado.innerHTML = nombres;
    tbody.innerHTML = `<tr>${datosTarea}</tr>`;
}

// Inicia los temporizadores
function startContadores() {
    stopContadores(); // Evita múltiples temporizadores simultáneos

    taskAll.taskList.forEach((task, index) => {
        let isBreak = false;
        let remainingTime = task.duration * 60; // Convertir a segundos
        let celda = document.getElementById(`celda-${index}`);
        let durationContador = document.getElementById(`duration-${index}`);
        let breakContador = document.getElementById(`break-${index}`);

        celda.style.backgroundColor = "#0EC044"; // 🟢 Estado: tarea iniciada

        contadores[index] = setInterval(() => {
            if (remainingTime > 0) {
                remainingTime--;
                let mostrarElemento = isBreak ? breakContador : durationContador;
                mostrarElemento.innerText = formatTime(remainingTime);
            } else {
                if (!isBreak) {
                    // Cuando duration llega a 0, mostrar "Done" y activar break
                    durationContador.innerText = "Done";
                    celda.style.backgroundColor = "#F1B717"; // 🟡 Estado: periodo de break
                    remainingTime = task.break * 60;
                    isBreak = true;
                } else {
                    // Cuando break llega a 0, detener el temporizador
                    breakContador.innerText = "00:00";
                    celda.style.backgroundColor = "#FB4343"; // 🔴 Estado: tarea y break finalizados
                    clearInterval(contadores[index]);
                }
            }
        }, 1000);
    });

    // Contador global en el encabezado
    contadores["global"] = setInterval(() => {
        segundosGlobales++;
        contador.innerText = formatTime(segundosGlobales);
    }, 1000);
}

// Detiene los temporizadores
function stopContadores() {
    contadores.forEach(timer => clearInterval(timer));
    clearInterval(contadores["global"]);

    segundosGlobales = 0;
    contador.innerText = "00:00";
}

function pauseContadores() {
    taskAll.taskList.forEach((task, index) => {
        let celda = document.getElementById(`celda-${index}`);
        let durationElement = document.getElementById(`duration-${index}`);
        let breakElement = document.getElementById(`break-${index}`);

        durationElement.innerText = formatTime(task.duration * 60);
        breakElement.innerText = formatTime(task.break * 60);

        celda.style.backgroundColor = "";
    });
}

// Agregar eventos a los botones
start.addEventListener("click", startContadores);
stop.addEventListener("click", stopContadores);
pause.addEventListener("click", pauseContadores)

crearTabla();