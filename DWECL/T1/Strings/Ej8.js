let capitalize_Words = (cadena) => {
    let nuevaCadena = '';
    let cadenaSeparada = cadena.split(' ');

    cadenaSeparada.forEach(element => {
        nuevaCadena += element.charAt(0).toUpperCase() + element.slice(1) + ' ';
    });
    return nuevaCadena;
};
console.log(capitalize_Words('js string exercises'));
