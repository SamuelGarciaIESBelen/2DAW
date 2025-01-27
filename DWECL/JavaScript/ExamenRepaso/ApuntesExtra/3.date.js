// =====================
// **OBJETO DATE EN JAVASCRIPT**
// =====================

// **CREAR UN OBJETO DATE**
// Crear un objeto Date para trabajar con fechas y horas.
let now = new Date(); // Hora actual
console.log(now);

// **INDICAR UNA FECHA ESPECÍFICA**
// Crear un objeto Date indicando una fecha específica
let dia = new Date("2017-1-16");
console.log(dia);

// **Date.parse()**
// Transforma una cadena con la representación de una fecha y hora, y devuelve el número de milisegundos desde las 00:00:00 del 1 de enero de 1970, hora local.
let millis = Date.parse("2017-1-16"); // Número de milisegundos desde 1970
console.log(millis);

// **MÉTODOS GET/SET**
// Métodos que permiten obtener o cambiar partes específicas de una fecha (día, mes, año, hora, etc.)

// Los meses empiezan en 0 (0 = enero, 11 = diciembre)
dia.setMonth(dia.getMonth() + 1); // Añadir un mes
dia.setFullYear(dia.getFullYear() + 1); // Añadir un año

// Obtener partes de la fecha
console.log(dia.getDay()); // Día de la semana (0 = domingo, 6 = sábado)
console.log(dia.getMonth()); // Mes actual

// Obtener el año, día del mes, horas, minutos, segundos
console.log(dia.getFullYear()); // Año actual de la fecha especificada
console.log(dia.getDate()); // Día del mes
console.log(dia.getHours()); // Hora actual
console.log(dia.getMinutes()); // Minutos actuales
console.log(dia.getSeconds()); // Segundos actuales

// **OBTENER EL NOMBRE DEL DÍA DE LA SEMANA**
// Usar un objeto para obtener el nombre del día de la semana de manera más sencilla
const week = {
    "0": "domingo",
    "1": "lunes",
    "2": "martes",
    "3": "miércoles",
    "4": "jueves",
    "5": "viernes",
    "6": "sábado"
};
console.log(week[dia.getDay()]); // Imprimir el nombre del día de la semana

// **MODIFICAR PARTES DE LA FECHA**
now.setFullYear(2025); // Cambiar el año
now.setMonth(5); // Cambiar el mes a junio (0 = enero)
now.setDate(15); // Cambiar el día del mes
now.setHours(10, 30, 0); // Cambiar la hora a 10:30:00
console.log(now);

// **SUMAR Y RESTAR DÍAS A UNA FECHA**
// Podemos sumar o restar días fácilmente usando los métodos get y set
now.setDate(now.getDate() + 7); // Añadir una semana a la fecha actual
console.log(now);
now.setDate(now.getDate() - 14); // Restar dos semanas a la fecha actual
console.log(now);

// **FORMATO DE FECHA**
// Convertir la fecha a diferentes formatos de cadena
console.log(now.toDateString()); // Formato legible de la fecha (por ejemplo, "Wed Jun 15 2025")
console.log(now.toGMTString()); // Convertir a cadena en formato GMT
console.log(now.toUTCString()); // Convertir a cadena en formato UTC
console.log(now.toISOString()); // Convertir a cadena en formato ISO (utilizado comúnmente en APIs)
console.log(now.toLocaleDateString()); // Convertir a una cadena legible según la configuración regional
console.log(now.toLocaleTimeString()); // Convertir la hora a una cadena legible según la configuración regional

// **EJEMPLO PRÁCTICO: SUMAR MESES Y AÑOS**
dia.setMonth(dia.getMonth() + 1); // Añadir un mes
dia.setFullYear(dia.getFullYear() + 1); // Añadir un año
console.log(dia);

// **MÉTODOS ADICIONALES**
// Obtener el tiempo en milisegundos desde 1970 para cálculos
let timeInMillis = now.getTime();
console.log(timeInMillis); // Milisegundos desde 1970

// Comparar fechas
let otraFecha = new Date("2023-11-12");
if (now > otraFecha) {
    console.log("La fecha actual es posterior a 12 de noviembre de 2023");
} else {
    console.log("La fecha actual es anterior o igual a 12 de noviembre de 2023");
}

// =====================
// **RESUMEN FINAL**
// =====================
// El objeto Date en JavaScript permite trabajar con fechas y horas de manera sencilla.
// - `Date.parse()` convierte una fecha en milisegundos desde 1970.
// - Métodos `get` para obtener partes de una fecha (`getFullYear()`, `getMonth()`, `getDate()`, `getHours()`, etc.).
// - Métodos `set` para modificar partes de una fecha (`setFullYear()`, `setMonth()`, `setDate()`, `setHours()`, etc.).
// - `toDateString()`, `toGMTString()`, `toUTCString()`, `toISOString()`, `toLocaleDateString()`, y `toLocaleTimeString()` para convertir fechas a cadenas legibles.
// - Puedes sumar o restar días utilizando `getDate()` y `setDate()`.
// - Uso de objetos para obtener el nombre del día de la semana de manera más legible.
// - Comparar fechas usando operadores de comparación (`>`, `<`, `>=`, `<=`).

