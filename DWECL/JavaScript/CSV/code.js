document.querySelector("#container").innerHTML = clase;

function csvarray(csv, separador = ",") {
    let filas = csv.trim().split("\n");
    return filas.map(fila => fila.trim().split(separador));
}

function meterDatos(csv) {
    const datos = csvarray(csv);

    // Encabezado
    const encabezados = datos.shift(); // Extrae la primera fila
    const trHeader = document.createElement("tr");
    encabezados.forEach(celda => {
        const th = document.createElement("th");
        th.textContent = celda;
        trHeader.append(th);
    });
    document.querySelector("#header").append(trHeader);

    // Datos
    datos.forEach(fila => {
        const tr = document.createElement("tr");
        fila.forEach(celda => {
            const td = document.createElement("td");
            td.textContent = celda;
            tr.append(td);
        });
        body.append(tr);
    });
    return body;
}
document.querySelector("#body").append(meterDatos(csv));