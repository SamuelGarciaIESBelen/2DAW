// =====================
// **EVENTOS DRAG AND DROP EN JAVASCRIPT**
// =====================

// **¿Qué es Drag and Drop?**
// El "drag and drop" (arrastrar y soltar) es una funcionalidad que permite a los usuarios mover elementos de un lugar
// a otro dentro de una interfaz de usuario. En JavaScript, esto se maneja mediante una serie de eventos que permiten 
//controlar y definir el comportamiento durante todo el proceso.

// **Operación de Drag and Drop**
// Una operación de arrastre consiste en:
// 1. **Inicio del arrastre**: Ocurre cuando el usuario selecciona un elemento arrastrable.
// 2. **Durante el arrastre**: El usuario arrastra el elemento hacia un objetivo donde se puede soltar (drop target).
// 3. **Fin del arrastre**: El usuario suelta el elemento en la zona de destino.

// **Eventos Básicos de Drag and Drop**
// - **dragstart**: Se dispara cuando el usuario comienza a arrastrar un elemento.
// - **dragover**: Se dispara mientras el elemento arrastrado está sobre un objetivo de soltado válido.
// - **drop**: Se dispara cuando el elemento es soltado en un objetivo de soltado válido.

// **PASOS PARA IMPLEMENTAR DRAG AND DROP**

// 1. **Identificar lo que es arrastrable**
// Para hacer que un elemento sea arrastrable, se utiliza el atributo `draggable`.
const elementoArrastrable = document.createElement("div");
elementoArrastrable.id = "arrastrable";
elementoArrastrable.draggable = true;
elementoArrastrable.textContent = "Arrástrame";
elementoArrastrable.style.width = "100px";
elementoArrastrable.style.height = "100px";
elementoArrastrable.style.backgroundColor = "lightblue";
document.body.appendChild(elementoArrastrable);

// 2. **Manejador del evento dragstart**
// El evento `dragstart` se usa para inicializar el proceso de arrastre y definir los datos que se transfieren.
elementoArrastrable.addEventListener("dragstart", (event) => {
    event.dataTransfer.setData("text/plain", event.target.id);
    console.log("Drag iniciado");
});

// 3. **Definir una imagen para el arrastre (opcional)**
// Podemos personalizar la imagen que se mostrará durante el arrastre.
elementoArrastrable.addEventListener("dragstart", (event) => {
    const img = new Image();
    img.src = "https://via.placeholder.com/50";
    event.dataTransfer.setDragImage(img, 10, 10);
});

// 4. **Definir el efecto del arrastre (drop effect)**
// Definimos el tipo de acción que sucederá al soltar el elemento: `copy`, `move` o `link`.
elementoArrastrable.addEventListener("dragstart", (event) => {
    event.dataTransfer.effectAllowed = "move";
});

// 5. **Definir una zona de soltado (drop zone)**
// Para que un elemento pueda recibir el elemento arrastrado, necesita tener los eventos `dragover` y `drop`.
const zonaSoltar = document.createElement("div");
zonaSoltar.id = "zonaSoltar";
zonaSoltar.style.width = "200px";
zonaSoltar.style.height = "200px";
zonaSoltar.style.border = "2px dashed #000";
zonaSoltar.style.marginTop = "20px";
zonaSoltar.textContent = "Suelta aquí";
document.body.appendChild(zonaSoltar);

// 6. **Permitir el evento dragover**
// Para que el elemento sea un objetivo válido de soltado, debemos prevenir el comportamiento por defecto del evento `dragover`.
zonaSoltar.addEventListener("dragover", (event) => {
    event.preventDefault(); // Permite que el elemento sea soltado aquí
});

// 7. **Manejador del evento drop**
// El evento `drop` maneja el momento en que se suelta el elemento en la zona de destino.
zonaSoltar.addEventListener("drop", (event) => {
    event.preventDefault();
    const id = event.dataTransfer.getData("text/plain");
    const elementoArrastrado = document.getElementById(id);
    zonaSoltar.appendChild(elementoArrastrado);
    console.log("Elemento soltado en la zona de destino");
});

// **EJEMPLO COMPLETO DE DRAG AND DROP**
// En el ejemplo anterior, hemos creado un elemento arrastrable y una zona de soltado, utilizando los eventos `dragstart`, `dragover` y `drop` para manejar todo el proceso de arrastrar y soltar de una manera completa y funcional.

// **RESUMEN FINAL**
// - **dragstart**: Se dispara cuando se inicia el arrastre, define los datos que se transfieren y puede personalizar la imagen del arrastre.
// - **dragover**: Necesita prevenir el comportamiento por defecto para que el elemento sea un objetivo válido de soltado.
// - **drop**: Se dispara cuando el elemento es soltado en una zona válida, permitiendo realizar acciones como mover el elemento al nuevo contenedor.
// - El atributo `draggable="true"` se usa para hacer que los elementos sean arrastrables.
// - El objeto `dataTransfer` se utiliza para manejar la información que se transfiere durante el arrastre.

// Este mecanismo mejora la interactividad de la página web y permite crear interfaces más intuitivas y amigables para el usuario.
