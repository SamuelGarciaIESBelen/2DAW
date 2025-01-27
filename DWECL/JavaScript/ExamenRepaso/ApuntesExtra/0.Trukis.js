// se pueden usar collecciones HTML, y demas movidas con el spread operator y pasarlas a un array, y asi usar 
//los metodos de array. 
let div = document.createElement("div");
let i;
while ( i<20){
    let div2 = document.createElement("div");
    div.appendChild(div);
    i++;
}
[...div.children].map(e => e.classList.add("patata"));

