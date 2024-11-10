
let comunidad;
let provincia;

const resetSelect = (destino, nombre) => {
    document.querySelector(destino).innerHTML = "";
    let opcion = document.createElement("option");
    opcion.textContent = "Seleccione una " + nombre;
    opcion.setAttribute("value", "")
    document.querySelector(destino).appendChild(opcion);

}
const selectComunidad = (selectMap) => {
    for (comunidad of selectMap) {
        let opcion = document.createElement("option");
        opcion.textContent = comunidad.label;
        opcion.setAttribute("value", comunidad.code)
        document.querySelector("#comunidad").appendChild(opcion);
    }
};

const selectProvincia = (event) => {
    comunidad = selectMap.find(c => c.code == event.target.value);
    resetSelect("#provincia", "provincia");
    resetSelect("#localidad", "localidad");
    if (event.target.value) {
        for (provincia of comunidad.provinces) {
            let opcion = document.createElement("option");
            opcion.textContent = provincia.label;
            opcion.setAttribute("value", provincia.code)
            document.querySelector("#provincia").appendChild(opcion);
        }
    }

}
const selectLocalidad = (event) => {
    provincia = comunidad.provinces.find(p => p.code == event.target.value);
    resetSelect("#localidad", "localidad");
    if (event.target.value) {
        for (localidad of provincia.towns) {
            let opcion = document.createElement("option");
            opcion.textContent = localidad.label;
            opcion.setAttribute("value", localidad.label)
            document.querySelector("#localidad").appendChild(opcion);
        }
    }
}


selectComunidad(selectMap);
document.querySelector("#comunidad").addEventListener("change", selectProvincia);
document.querySelector("#provincia").addEventListener("change", selectLocalidad);



//revisar este es mas o menos la forma sencilla a rellenar para los demas
// const fillOptions = (array, destino)=>{
//     for (items of array ){
//         let opcion = document.createElement("option");
//         opcion.textContent = item.label;
//         opcion.setAttribute("value", item.code)
//         destino.appendChild(opcion);
//     }
// }