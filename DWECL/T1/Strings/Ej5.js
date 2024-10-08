function abreviar(nombreApellido) {
    let nombre = '';
    let apellido = '';
    let partes = nombreApellido.split(" ");
   
    nombre = partes[0];

    for (let i = 1; i < partes.length; i++) {
        apellido += partes[i].charAt(0).toUpperCase() + '. ';
    }
    return (nombre + ' ' + apellido);
}

// Hacer más "sofisticado"
console.log(abreviar("Samuel García Zorrilla"));