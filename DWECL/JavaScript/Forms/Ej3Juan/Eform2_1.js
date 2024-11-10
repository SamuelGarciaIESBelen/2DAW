const validate = () => {
    const pattern = /^\d{8}[A-Z]$/;
    if (!nombre.value){
        nombre.classList.add("is-invalid");
        return false;
    }
    if (!apellido1.value){
        apellido1.classList.add("is-invalid");
        return false;
    }
    if (!pattern.test(dni.value)){
        dni.classList.add("is-invalid");
        return false;
    }
    nombre.classList.remove("is-invalid");
    apellido1.classList.remove("is-invalid");
    dni.classList.remove("is-invalid");
    return true;
}


const addPerson = (event) =>{
    dni = document.querySelector("#dni");
    autorithed = document.querySelector(".autorithed");
    contador = document.querySelector(".contador");
    if(validate() && contador.textContent<=5){
        let person = document.createElement("div");
        person.classList.add("fw-bold", "col-6");
        person.innerHTML=`
        <p>${nombre.value} ${apellido1.value} 
        ${(apellido2.value)?apellido2.value:""} 
        ${dni.value} ${telefono.value?" Tlf:"+telefono.value:""}</p>
        `
        let borrar = document.createElement("button");
        borrar.classList.add("btn", "btn-danger");
        borrar.textContent="borrar";
        person.appendChild(borrar);
        autorithed.appendChild(person);
       
        contador.textContent=+contador.textContent+1;
        borrar.addEventListener("click", (event) => {
            event.preventDefault();
            person.remove();
            
        });
    }
}


document.querySelector(".btn-success").addEventListener("click", addPerson);
// document.querySelector(".btn-danger").addEventListener("click", removePerson);