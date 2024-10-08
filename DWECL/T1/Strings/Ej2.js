function enviarEmail (nombre, edad, mensaje, email) {
    if (!nombre || !edad || !mensaje || !email) {
        return null;
    }

    const status = parseInt(edad) >= 18
        ? `A user has posted a comment from the website:
    Name: ${nombre}
    Age: ${edad}
    Status: ${nombre} is a valid user (${email})
    Comments: ${mensaje}`
        : `${nombre} is not a valid user (${email})`;
    return status;
}

console.log(enviarEmail("Samuel", 19, "Prueba de contenido", "samuelgz@gmail.com"));