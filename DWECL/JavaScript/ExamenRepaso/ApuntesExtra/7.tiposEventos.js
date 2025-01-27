// =====================
// **EVENTOS DE TECLADO EN JAVASCRIPT**
// =====================

// **Eventos de Teclado**
// Los eventos de teclado permiten reaccionar cuando el usuario interactúa con el teclado.

// **Eventos Principales del Teclado**
// - **keydown**: Se dispara cuando el usuario presiona una tecla (si la tecla se mantiene presionada, este evento se repite).
// - **keyup**: Se dispara cuando el usuario suelta la tecla.

// **Propiedades Importantes de los Eventos de Teclado**
// 1. **event.code**: Representa el código de la tecla presionada, como "KeyA", "ArrowLeft", etc. Este código depende de la ubicación física de la tecla en el teclado.
// 2. **event.key**: Representa el carácter asociado a la tecla. Para teclas no alfanuméricas, como "Esc", suele tener el mismo valor que `code`.
// 3. **event.shiftKey, event.ctrlKey, event.altKey, event.metaKey**: Estas propiedades devuelven `true` si las teclas Shift, Ctrl, Alt, o Meta estaban presionadas al ocurrir el evento.
// 4. **event.repeat**: Devuelve `true` si la tecla se mantiene presionada y el evento se repite.

// **Ejemplo de Evento de Teclado**
document.addEventListener("keydown", (event) => {
    console.log(`Tecla presionada: ${event.key}`); // Muestra la tecla presionada
    console.log(`Código de la tecla: ${event.code}`); // Muestra el código de la tecla
    if (event.shiftKey) {
        console.log("Shift está presionado");
    }
    if (event.repeat) {
        console.log("La tecla se está repitiendo");
    }
});

// =====================
// **EVENTOS DE CAMBIO Y ENTRADA (CHANGE Y INPUT)**
// =====================

// **Evento onchange**
// - El evento `change` se dispara cuando un elemento ha terminado de cambiar.
// - Para campos de texto, esto ocurre cuando pierden el foco.
// - Para otros elementos como `select` o `input` tipo `checkbox/radio`, se dispara inmediatamente después de un cambio.

const inputTexto = document.createElement("input");
inputTexto.type = "text";
inputTexto.placeholder = "Escribe algo y pierde el foco...";
document.body.appendChild(inputTexto);

inputTexto.addEventListener("change", (event) => {
    console.log(`El valor del input ha cambiado a: ${event.target.value}`);
});

// **Evento oninput**
// - El evento `input` se dispara cada vez que el valor de un elemento cambia.
// - A diferencia de los eventos de teclado, `input` se dispara para cualquier cambio de valor, incluso si se pega con el ratón o se dicta usando reconocimiento de voz.

inputTexto.addEventListener("input", (event) => {
    console.log(`Valor actual del input: ${event.target.value}`);
});

// =====================
// **EVENTOS DE COPIAR, CORTAR Y PEGAR**
// =====================
// - Estos eventos pertenecen a la clase `ClipboardEvent` y proporcionan acceso a los datos que se cortan/copian/pegan.
// - Los eventos son `cut`, `copy`, y `paste`.

inputTexto.addEventListener("cut", (event) => {
    console.log("Texto cortado");
});

inputTexto.addEventListener("copy", (event) => {
    console.log("Texto copiado");
});

inputTexto.addEventListener("paste", (event) => {
    console.log("Texto pegado");
});

// =====================
// **EVENTO CONTEXTMENU**
// =====================
// - El evento `contextmenu` se dispara cuando el usuario intenta abrir un menú contextual (normalmente con el botón derecho del ratón).

const areaContextual = document.createElement("div");
areaContextual.textContent = "Haz clic derecho aquí para abrir el menú contextual";
areaContextual.style.width = "300px";
areaContextual.style.height = "100px";
areaContextual.style.border = "1px solid black";
areaContextual.style.marginTop = "20px";
document.body.appendChild(areaContextual);

areaContextual.addEventListener("contextmenu", (event) => {
    event.preventDefault(); // Prevenir el menú contextual por defecto
    console.log("Menú contextual personalizado");
});

// =====================
// **OTROS EVENTOS COMUNES EN JAVASCRIPT**
// =====================

// **Evento onfocus**
// - Se dispara cuando un elemento recibe el foco, como cuando el usuario hace clic en un input.
inputTexto.addEventListener("focus", (event) => {
    console.log("El input ha recibido el foco");
});

// **Evento onblur**
// - Se dispara cuando un elemento pierde el foco, por ejemplo, cuando el usuario hace clic fuera del input.
inputTexto.addEventListener("blur", (event) => {
    console.log("El input ha perdido el foco");
});

// **Evento onload**
// - Se dispara cuando un recurso específico, como una imagen o una página web, ha sido completamente cargado.
window.addEventListener("load", () => {
    console.log("La página ha terminado de cargar");
});

// **Evento onresize**
// - Se dispara cuando se cambia el tamaño de la ventana del navegador.
window.addEventListener("resize", () => {
    console.log("La ventana ha cambiado de tamaño");
});

// **Evento onunload**
// - Se dispara cuando el usuario está a punto de abandonar la página. Esto es útil para realizar tareas de limpieza.
window.addEventListener("unload", () => {
    console.log("El usuario está abandonando la página");
});

// **Evento scroll**
// - Se dispara cuando el usuario desplaza la página o un elemento que tiene un scroll.
window.addEventListener("scroll", () => {
    console.log("La página está siendo desplazada");
});

// =====================
// **RESUMEN DE EVENTOS DE TECLADO Y OTROS EVENTOS COMUNES**
// =====================
// - **keydown**: Se dispara al presionar una tecla. Puede repetirse si se mantiene presionada.
// - **keyup**: Se dispara al soltar una tecla.
// - Propiedades como `event.key`, `event.code`, `event.shiftKey`, etc., permiten obtener detalles adicionales sobre la tecla presionada.
// - **change**: Se dispara cuando un elemento de entrada cambia y pierde el foco.
// - **input**: Se dispara cada vez que un valor cambia, independientemente de cómo ocurra el cambio.
// - **cut, copy, paste**: Eventos para manejar operaciones de portapapeles.
// - **contextmenu**: Se dispara cuando se intenta abrir un menú contextual, normalmente con el botón derecho del ratón.
// - **focus**: Se dispara cuando un elemento recibe el foco.
// - **blur**: Se dispara cuando un elemento pierde el foco.
// - **load**: Se dispara cuando la página o un recurso ha sido cargado completamente.
// - **resize**: Se dispara cuando la ventana cambia de tamaño.
// - **unload**: Se dispara cuando el usuario está a punto de abandonar la página.
// - **scroll**: Se dispara cuando el usuario desplaza la página o un elemento con scroll.
