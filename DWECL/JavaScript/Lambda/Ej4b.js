let personas = [
    {nombre: 'Ale', edad: 30},
    {nombre: 'Andrés', edad: 20},
    {nombre: 'Juan', edad: 15},
    {nombre: 'Miguel', edad: 18},
];

let mayoresEdad = personas.filter((personas) => personas.edad >= 18);

for (let i in mayoresEdad) {
    console.log(mayoresEdad[i].nombre);
}
