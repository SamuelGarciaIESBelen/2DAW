// =====================
// **DEFAULT PARAMETERS, REST Y SPREAD**
// =====================

// **DEFAULT PARAMETERS**
// Los parámetros por defecto permiten que una función inicialice valores si no se pasan valores o si se pasa 'undefined'.

// Ejemplo de parámetros por defecto
const sumaConParametrosPorDefecto = (a, b = 10) => {
    return a + b;
};
console.log(sumaConParametrosPorDefecto(20)); // 20 + 10 = 30
console.log(sumaConParametrosPorDefecto(20, 50)); // 20 + 50 = 70

// Importante: si un parámetro tiene valor por defecto, siempre debe ir después de los que no lo tienen
let funcionIncorrecta = (a = 10, b) => {
    return a + b;
};
console.log(funcionIncorrecta(20)); // NaN, no funcionará correctamente ya que 'b' no está definido

// **REST PARAMETERS**
// Permiten definir una función con un número variable de parámetros. Todos los parámetros adicionales se almacenan en un array.

// Ejemplo con Rest Parameters
const sumarElementos = (...arr) => {
    console.log(arr); // [10, 20, 40, 60, 90]
    let sum = arr.reduce((accE, curE) => accE + curE);
    console.log(sum);
};
sumarElementos(10, 20, 40, 60, 90); // 220
sumarElementos(10, 20, 90); // 120

// Los parámetros adicionales se almacenan como un array dentro de la función.

// **SPREAD OPERATOR**
// Permite expandir los elementos de un array u objeto donde se esperan múltiples valores (como argumentos en una función o elementos en otro array).

// Copiar y combinar arrays con el operador spread
const arrInicial = ['Mi', 'nombre', 'es'];
const arrFinal = ['Hola.', ...arrInicial, 'Mia'];
console.log(arrFinal); // ['Hola.', 'Mi', 'nombre', 'es', 'Mia']

// El spread operator también funciona con objetos y arrays iterables (como strings)

// **COPIAR ARRAYS CON SPREAD OPERATOR**
// Importante: Los objetos y arrays se asignan por referencia y no por valor.

let arr1 = [1, 2, 3];
let arr2 = [...arr1]; // Copiar usando spread syntax

// Añadir un elemento al array original
arr1.push(4);
console.log(arr1); // [1, 2, 3, 4]
console.log(arr2); // [1, 2, 3] -> La copia no se ve afectada

// **NULLISH COALESCING OPERATOR (??)**
// El operador de fusión nula (??) devuelve el primer valor definido que no sea null o undefined

let altura = 0;
console.log(altura || 300); // 300 (|| devuelve el primer valor "truthy", 0 se considera "falsy")
console.log(altura ?? 300); // 0 (?? devuelve el primer valor definido)

let nombre = "";
console.log(nombre || "Anónimo"); // "Anónimo" (|| considera "" como "falsy")
console.log(nombre ?? "Anónimo"); // "" (?? considera "" como un valor definido)

// =====================
// **DESESTRUCTURACIÓN DE ARRAYS**
// =====================

// La desestructuración de arrays permite extraer elementos de un array y asignarlos a variables de forma más concisa.

const arr = [1, 2, 3, 4, 5, 6];

// Forma moderna de desestructurar arrays
let [a, b, c] = arr;
console.log(a); // 1
console.log(b); // 2
console.log(c); // 3

// También se pueden omitir elementos dejando las posiciones vacías
let [x, y, , d, e] = arr;
console.log(x); // 1
console.log(y); // 2
console.log(d); // 4
console.log(e); // 5

// **CLONAR ARRAYS**
// =====================
// Clonar un array se puede hacer de varias formas. Las copias superficiales se pueden realizar con los siguientes métodos:

// 1. Spread Operator
const frutas = ["Fresa", "Mango"];
const frutasCopia = [...frutas];
console.log(frutasCopia); // ["Fresa", "Mango"]

// tambien vale para objetos!
let susto = {
    x:1,
    y:15
};

let clonSusto3 = {...susto};
console.log(clonSusto3);

// 2. Array.from()
const frutasCopia2 = Array.from(frutas);
console.log(frutasCopia2); // ["Fresa", "Mango"]

// 3. slice()
const frutasCopia3 = frutas.slice();
console.log(frutasCopia3); // ["Fresa", "Mango"]

// **COPIA PROFUNDA**
// Para hacer una copia profunda de un array u objeto, se puede utilizar JSON.parse() junto con JSON.stringify().

const original = [{ nombre: "Juan" }, { nombre: "Ana" }];
const copiaProfunda = JSON.parse(JSON.stringify(original));

// Modificar la copia no afecta al original
copiaProfunda[0].nombre = "Pedro";
console.log(original[0].nombre); // "Juan"
console.log(copiaProfunda[0].nombre); // "Pedro"

// =====================
// **RESUMEN FINAL**
// =====================
// Los parámetros por defecto permiten definir valores por defecto para evitar errores si no se pasa un valor.
// El operador rest permite recibir múltiples parámetros en forma de array.
// El operador spread facilita copiar y expandir elementos de arrays y objetos de manera limpia y concisa.
// El operador ?? es útil para diferenciar entre null/undefined y otros valores "falsy".
