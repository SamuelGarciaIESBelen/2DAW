// =====================
// **MANEJO DEL DOM Y EVENTOS EN JAVASCRIPT MODERNO**
// =====================

// **EVENTOS EN JAVASCRIPT**
// Un evento es una señal de que algo ha ocurrido en la página web. Puede ser un clic del ratón, una pulsación de tecla, el envío de un formulario, entre otros.

// **TIPOS DE EVENTOS MÁS COMUNES**
// - Mouse Events: click, contextmenu, mouseover, mouseout, mousedown, mouseup, mousemove.
// - Keyboard Events: keydown, keyup.
// - Form Events: submit, focus.
// - Document Events: DOMContentLoaded.
// - CSS Events: transitionend.

// **EJEMPLO DE EVENTOS DEL MOUSE**
const btn = document.createElement("button");
btn.textContent = "Click me";
document.body.appendChild(btn);

// **Manejadores de eventos con addEventListener**
// La mejor forma de asignar manejadores de eventos es mediante el método `addEventListener()`.

// Ejemplo básico de `addEventListener` para un clic
btn.addEventListener("click", () => {
    alert("¡Botón clicado!");
});

// **MÚLTIPLES MANEJADORES CON addEventListener**
// Podemos añadir múltiples manejadores al mismo evento utilizando `addEventListener` varias veces
btn.addEventListener("click", () => {
    console.log("Primer manejador");
});
btn.addEventListener("click", () => {
    console.log("Segundo manejador");
});

// **REMOVER MANEJADORES CON removeEventListener**
// Para eliminar un manejador, necesitamos hacer referencia a la misma función
function handler() {
    console.log("Este manejador será eliminado");
}

btn.addEventListener("click", handler);
btn.removeEventListener("click", handler); // Se elimina el manejador asociado

// **EL OBJETO EVENTO**
// Cada vez que ocurre un evento, se crea un objeto `event` que contiene información sobre el evento
btn.addEventListener("click", (event) => {
    console.log(`Tipo de evento: ${event.type}`); // Tipo de evento (e.g., "click")
    console.log(`Elemento objetivo: ${event.target.tagName}`); // Elemento donde ocurrió el evento
    console.log(`Coordenadas: X=${event.clientX}, Y=${event.clientY}`); // Coordenadas del cursor
});

// **PREVENIR ACCIONES POR DEFECTO**
// Algunos elementos tienen acciones por defecto (como enlaces y formularios). Podemos evitar estas acciones con `preventDefault()`
const link = document.createElement("a");
link.href = "https://www.google.com";
link.textContent = "Ir a Google";
document.body.appendChild(link);

link.addEventListener("click", (event) => {
    event.preventDefault(); // Evita la navegación al hacer clic
    alert("Navegación evitada");
});

// **PROPAGACIÓN DE EVENTOS: BUBBLING Y CAPTURING**
// Cuando ocurre un evento, primero se ejecuta en el elemento objetivo y luego "burbujea" hacia arriba por sus ancestros
const container = document.createElement("div");
const innerBtn = document.createElement("button");
innerBtn.textContent = "Clic dentro";
container.appendChild(innerBtn);
document.body.appendChild(container);

container.addEventListener("click", () => {
    alert("Div clicado");
});

innerBtn.addEventListener("click", (event) => {
    alert("Botón clicado");
    event.stopPropagation(); // Detiene la propagación, el div no recibirá el evento
});

// **DELEGACIÓN DE EVENTOS**
// En lugar de agregar un manejador a cada elemento, podemos usar un manejador en el elemento padre y detectar los eventos en los hijos
const list = document.createElement("ul");
list.innerHTML = `
  <li>Elemento 1</li>
  <li>Elemento 2</li>
  <li>Elemento 3</li>
`;
document.body.appendChild(list);

list.addEventListener("click", (event) => {
    if (event.target.tagName === "LI") {
        alert(`Has clicado en ${event.target.textContent}`);
    }
});

// **RESUMEN FINAL**
// - Utiliza `addEventListener` para asignar manejadores de eventos, ya que permite múltiples manejadores por evento.
// - `removeEventListener` se usa para eliminar manejadores específicos.
// - El objeto `event` proporciona información útil como el tipo de evento, el objetivo, y las coordenadas del cursor.
// - `preventDefault()` evita el comportamiento por defecto de los elementos.
// - `stopPropagation()` detiene la propagación del evento hacia elementos padres.
// - La delegación de eventos permite manejar múltiples elementos similares con un solo manejador, mejorando el rendimiento y la eficiencia del código.
