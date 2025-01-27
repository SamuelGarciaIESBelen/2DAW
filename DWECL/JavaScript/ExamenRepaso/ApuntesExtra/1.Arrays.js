// =====================
// **DECLARACIÓN DE ARRAYS**
// =====================
// Puedes declarar un array usando corchetes [] o con el constructor Array

// Forma básica de declarar un array
const numeros = [1, 2, 3, 4, 5];
const frutas = ['manzana', 'pera', 'plátano'];

// Otra forma de declarar un array
const otroArray = new Array(10, 20, 30);

// =====================
// **MÉTODOS DE ARRAYS**
// =====================

// 1. map(): Aplica una función a cada elemento del array y devuelve un nuevo array con los resultados.
// Forma expandida
const listaDoble = numeros.map(e => {
    let numero = e * 2;
    return numero + 8;
});
console.log(listaDoble); // [10, 12, 14, 16, 18]

// Forma concisa
const cuadrados = numeros.map(n => n * n);
console.log(cuadrados); // [1, 4, 9, 16, 25]

// 2. filter(): Filtra elementos del array según una condición y devuelve un nuevo array con los elementos que cumplan la condición.
// Forma expandida
const listaResult = numeros.filter(e => {
    if (e % 2 == 0) {
        return true;
    } else {
        return false;
    }
});
console.log(listaResult); // [2, 4]

// Forma concisa
const pares = numeros.filter(e => e % 2 === 0);
console.log(pares); // [2, 4]

// 3. find(): Devuelve el primer elemento que cumpla con la condición especificada.
// Forma expandida
let found = numeros.find(e => {
    if (e > 2) {
        return true;
    } else {
        return false;
    }
});
console.log(found); // 3

// Forma concisa
found = numeros.find(e => e > 2);
console.log(found); // 3

// 4. findIndex(): Devuelve el índice del primer elemento que cumpla con la condición especificada.
// Forma expandida
let index = numeros.findIndex(e => {
    if (e > 2) {
        return true;
    } else {
        return false;
    }
});
console.log(index); // 2

// Forma concisa
index = numeros.findIndex(e => e > 2);
console.log(index); // 2

// 5. indexOf(): Devuelve el índice de un valor específico en el array. Si no lo encuentra, devuelve -1.
const indice = frutas.indexOf('pera');
console.log(indice); // 1

// 6. forEach(): Ejecuta una función en cada elemento del array, pero no devuelve un nuevo array.
frutas.forEach(fruta => console.log(fruta));
// manzana
// pera
// plátano

// 7. reduce(): Aplica una función acumulativa a los elementos del array, devolviendo un valor único.
// Forma expandida
const suma = numeros.reduce((acumulador, valorActual) => {
    return acumulador + valorActual;
}, 0);
console.log(suma); // 15

// Forma concisa
const sumaConcisa = numeros.reduce((ac, e) => ac + e);
console.log(sumaConcisa); // 15

// 8. push(), pop(), shift(), unshift(): Métodos para añadir o quitar elementos de un array
// push(): Añade uno o más elementos al final del array
numeros.push(6);
console.log(numeros); // [1, 2, 3, 4, 5, 6]

// pop(): Elimina el último elemento del array
numeros.pop();
console.log(numeros); // [1, 2, 3, 4, 5]

// unshift(): Añade uno o más elementos al inicio del array
numeros.unshift(0);
console.log(numeros); // [0, 1, 2, 3, 4, 5]

// shift(): Elimina el primer elemento del array
numeros.shift();
console.log(numeros); // [1, 2, 3, 4, 5]


// =====================
// **LOOPS**
// =====================

// 1. for loop: Ideal para iteraciones en un rango conocido
for (let i = 0; i < numeros.length; i++) {
    console.log(numeros[i]);
} // 1, 2, 3, 4, 5

// 2. while loop: Ideal cuando no se sabe cuántas veces hay que repetir una acción
let i = 0;
while (i < numeros.length) {
    console.log(numeros[i]);
    i++;
} // 1, 2, 3, 4, 5

// 3. do...while loop: Similar al while, pero se ejecuta al menos una vez
let j = 0;
do {
    console.log(numeros[j]);
    j++;
} while (j < numeros.length); // 1, 2, 3, 4, 5

// 4. for...in loop: Itera sobre las propiedades de un objeto o índices de un array
for (let index in frutas) {
    console.log(index); // 0, 1, 2
}

// 5. for...of loop: Ideal para iterar sobre los valores de un array
for (let valor of frutas) {
    console.log(valor); // manzana, pera, plátano
}

// 6. switch: Se utiliza para evaluar múltiples condiciones
const fruta = "manzana";
switch (fruta) {
    case "manzana":
        console.log("Es una manzana");
        break;
    case "pera":
        console.log("Es una pera");
        break;
    default:
        console.log("Fruta no conocida");
        break;
}

