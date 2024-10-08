/* let number = 6;
console.log(number);
console.log(typeof number);

number = 66;
console.log(number);

number = "Hello everybody";
console.log(number);
console.log(typeof number);

number = true;
console.log(number);

number = [1, 2, 3, "a, b, c", false];
console.log(number);
console.log(typeof number);

let persona = {apellido: "Ruiz"};
console.log(persona);
console.log(typeof persona);

console.log(persona.hasOwnProperty("nombre"));
console.log(persona.hasOwnProperty("apellido")); */

/* let lista = [1, 2, 3, 4, 5, 6, 7, 8, 9];

// Recorre los índices
for (let e in lista) {
    console.log(e);
}

console.log("--------------------------");

// Recorre los elementos
for (let e of lista) {
    console.log(e);
}

console.log("--------------------------");

lista.forEach(e => console.log("Estos son los números: ", e));

console.log("--------------------------");

lista.forEach(e => {
    e *= 2;
    console.log("Doble = ", e);
}) */

let lista = [1, 2, 3, 4, 5];
console.log(lista);

let doubleLista = lista.map(e => e * 2);
console.log(doubleLista);

// let listaImpares = lista.filter(e => e % 2 != 0);
let listaImpares = lista.filter(e => e % 2); // Si el resultado de la condición es 0, se interpreta como falso y no entra
console.log(listaImpares);

// let listaPares = lista.filter(e => e % 2 == 0);
let listaPares = lista.filter(e => !(e % 2));
console.log(listaPares);

/* let encontrado = lista.find(e => e > 2);
console.log(encontrado);
console.log(typeof encontrado); */

let encontrado = lista.findIndex(e => e > 2);
console.log(encontrado);
console.log(typeof encontrado);

let encontrado2 = lista.indexOf(3);
console.log(encontrado2);
console.log(typeof encontrado2);

let suma = lista.reduce((accumulator, current) => accumulator + current);
console.log(suma);