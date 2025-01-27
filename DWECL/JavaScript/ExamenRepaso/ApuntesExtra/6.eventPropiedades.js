// =====================
// **OBJETO EVENTO EN JAVASCRIPT - PROPIEDADES**
// =====================

// El objeto `event` en JavaScript se crea automáticamente cada vez que ocurre un evento. Este objeto contiene información útil sobre el evento que se está manejando y permite interactuar con detalles específicos de dicho evento.

// **PROPIEDADES PRINCIPALES DEL OBJETO EVENT**

// 1. **event.type**
// - Tipo del evento que ocurrió.
// - Ejemplo: "click", "keydown", "mouseover", etc.
const button = document.createElement("button");
button.textContent = "Haz clic aquí";
document.body.appendChild(button);

button.addEventListener("click", (event) => {
    console.log(`Tipo de evento: ${event.type}`); // "click"
});

// 2. **event.currentTarget** (equivalente a `this`)
// - Representa el elemento actual que está manejando el evento (es decir, donde se ha registrado el `addEventListener`).
// - Nota: Si se usa una función flecha como manejador, el valor de `this` no se referencia correctamente al elemento, por lo que es mejor usar `event.currentTarget`.
button.addEventListener("click", function(event) {
    console.log(`Elemento actual: ${event.currentTarget.tagName}`); // "BUTTON"
    console.log(`Elemento actual con this: ${this.tagName}`); // "BUTTON"
});

// 3. **event.clientX / event.clientY**
// - Coordenadas del cursor relativas a la ventana en eventos de puntero (por ejemplo, clic o movimiento del ratón).
button.addEventListener("click", (event) => {
    console.log(`Coordenadas del clic - X: ${event.clientX}, Y: ${event.clientY}`);
});

// 4. **event.target**
// - El elemento más anidado en el que ocurre el evento. Esto es útil cuando se trabaja con delegación de eventos, ya que puede determinar exactamente en qué elemento sucedió.
const container = document.createElement("div");
const innerButton = document.createElement("button");
innerButton.textContent = "Clic aquí (anidado)";
container.appendChild(innerButton);
document.body.appendChild(container);

container.addEventListener("click", (event) => {
    console.log(`Elemento objetivo: ${event.target.tagName}`); // Puede ser "BUTTON" o "DIV" dependiendo de dónde se haga clic
});

// 5. **event.eventPhase**
// - Indica la fase actual del flujo del evento: captura (1), objetivo (2), o burbujeo (3).
// - Esto es útil para saber en qué parte del ciclo de propagación se está ejecutando el manejador.
container.addEventListener("click", (event) => {
    switch (event.eventPhase) {
        case Event.CAPTURING_PHASE:
            console.log("Fase de captura");
            break;
        case Event.AT_TARGET:
            console.log("Fase de objetivo");
            break;
        case Event.BUBBLING_PHASE:
            console.log("Fase de burbujeo");
            break;
    }
});

// **PROPIEDADES ADICIONALES SEGÚN EL TIPO DE EVENTO**
// Algunas propiedades del objeto `event` dependen del tipo de evento que ocurrió. Aquí hay algunas propiedades específicas útiles:

// **Eventos de teclado (keydown, keyup)**
document.addEventListener("keydown", (event) => {
    console.log(`Tecla presionada: ${event.key}`); // Representa la tecla que se ha presionado, como "a", "Enter"
    console.log(`Código de la tecla: ${event.code}`); // Código físico de la tecla, como "KeyA", "Enter"
});

// **Eventos de puntero (click, mouseover)**
button.addEventListener("mousemove", (event) => {
    console.log(`Botón del ratón presionado: ${event.buttons}`); // Indica qué botón del ratón se presiona
    console.log(`Alt presionado: ${event.altKey}`); // `true` si la tecla Alt estaba presionada durante el evento
});

// **Eventos de formulario (submit)**
const form = document.createElement("form");
const input = document.createElement("input");
input.type = "text";
const submitButton = document.createElement("button");
submitButton.textContent = "Enviar";
form.appendChild(input);
form.appendChild(submitButton);
document.body.appendChild(form);

form.addEventListener("submit", (event) => {
    event.preventDefault(); // Prevenir el envío por defecto del formulario
    console.log(`Formulario enviado. Valor del input: ${input.value}`);
});

// **RESUMEN FINAL**
// - `event.type`: Tipo de evento ("click", "keydown", etc.).
// - `event.currentTarget`: El elemento que maneja el evento.
// - `event.clientX` / `event.clientY`: Coordenadas del cursor para eventos de puntero.
// - `event.target`: El elemento más anidado en el que ocurre el evento.
// - `event.eventPhase`: La fase actual del evento (captura, objetivo, burbujeo).
// - Propiedades adicionales según el tipo de evento, como `event.key` y `event.code` para eventos de teclado.

// Estas propiedades del objeto `event` permiten un manejo flexible y detallado de los eventos, haciendo posible una mejor interacción con los usuarios y la página web.
