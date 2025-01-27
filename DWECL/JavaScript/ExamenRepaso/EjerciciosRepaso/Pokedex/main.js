const buscar = document.querySelector('.buscar');
const respuesta = document.querySelector('.respuesta');

const busca = () => {
    const nombre = document.querySelector('.nombre').value;
    const ataque = document.querySelector('.ataque').value;
    const tipos = document.querySelectorAll('.tipo');
    const resultados = [];
    const nombreRes =  nombreFilter(nombre);
    const ataqueRes = ataqueFilter(ataque);

    const marcados = [...tipos].filter(t => t.checked).map(t => t.value);
    if (marcados.length>0) {
        for (tipo of marcados) {
            const result = tipoFilter(tipo);
            for ( pokemon of result) {
                if (!resultados.includes(pokemon)) {
                    resultados.push(pokemon);
                }
            }
        }  
    }
    if (nombreRes) {
        if (!resultados.includes(nombreRes)) {
            resultados.push(nombreRes);
        }
    }
    if (ataqueRes) {
        for ( pokemon of ataqueRes) {
            if (!resultados.includes(pokemon)) {
                resultados.push(pokemon);
            }
        }
    }
    console.log(marcados);
    
    console.log(ataqueRes);
    console.log(nombreRes);  
    console.log(resultados);
    
    // console.log(nombreFilter(nombre));
    // console.log(ataqueFilter(ataque));
    
    
    respuesta.textContent=nombre;
}

const nombreFilter = (nombre) => {
    return [...poke].filter(p => p.name.english.toLowerCase()==nombre.toLowerCase());
}
const ataqueFilter = (ataque) => {
    const resultado = [];
    [...poke].filter(p => {
        for (ability of p.profile.ability) {
            if (ability[0].toLowerCase()==ataque.toLowerCase()){
                resultado.push(p);
            }
        }
    });
    return resultado;
}

const tipoFilter = (tipo) => {
    const resultado = [];
    [...poke].filter(p => {
        for (t of p.type) {
            if (t.toLowerCase()==tipo.toLowerCase()){
                resultado.push(p)
            }
        }
    })

    
    return resultado;
}


buscar.addEventListener( 'click', busca );