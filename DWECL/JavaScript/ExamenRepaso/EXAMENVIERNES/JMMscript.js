const aloes = document.querySelector(".aloes");
const carrito = document.querySelector(".items");
pintaCarrito = (p, cantidad) => {
 const tr = document.createElement("tr");
    carrito.appendChild(tr);
    tr.innerHTML=`
                        <td class="d-flex gap-1">
                                <button class="sumar">+</button>
                                <p class="cantidad1">${cantidad}</p>
                                <button class="restar">-</button>
                        </td>
                        <td>${p.nombre}</td>
                        <td>${p.precio} €</td>
                        <td class="cantidad2">${p.precio*cantidad} €</td>
                        <td><button class="btn btn-primary eliminar">Eliminar</button>
                        </td>
    `;
    //listeners
    tr.querySelector(".sumar").addEventListener("click", () => {
        if (cantidad<p.stock){
        cantidad++;
        tr.querySelector(".cantidad1").textContent=cantidad;
        tr.querySelector(".cantidad2").textContent=cantidad*p.precio;
        }
    });
    tr.querySelector(".restar").addEventListener("click", (e) => {
        if (cantidad>0){
            cantidad--;
            tr.querySelector(".cantidad1").textContent=cantidad;
            tr.querySelector(".cantidad2").textContent=cantidad*p.precio;
        }
        if (cantidad==0){
            if(confirm("Quieres eliminar por completo?")){
                e.target.parentElement.parentElement.remove();
            } else {
                cantidad++;
                tr.querySelector(".cantidad1").textContent=cantidad;
                tr.querySelector(".cantidad2").textContent=cantidad*p.precio;  
            };
        }
    });
    tr.querySelector(".eliminar").addEventListener("click", (e)=> {
        e.target.parentElement.parentElement.remove();
         
    }) 
}

pintaTarjetas = (products) => {    
    products.forEach(p => {
         const tarjeta = document.createElement("div");
        tarjeta.innerHTML=`
         <div class="card" style="width: 18rem;">
                <img src="${p.imagen}" class="card-img-top" alt="${p.nombre}">
                <div class="card-body">
                    <h5 class="card-title">${p.nombre}</h5>
                    <p class="card-text">Precio: ${p.precio} € <span class="stock"></span></p>
                    <input class="cantidad" type="number" min="0" max="${p.stock}" step="1">
                    <div class="badge bg-warning aviso"></div>
                        <button class="btn btn-primary compra">Comprar</button>
                </div>
            </div>
        `;
        //listeners
        tarjeta.querySelector(".cantidad").addEventListener("input", (e)=> {
            console.log(e.target.value);
            
            if(((e.target.value%1)!=0) && (e.target.value<=p.stock)){
                //por maximo no puede ser porque ya lo controlo desde el propio input, pero aun asi dejo la logica correspondiente
                tarjeta.querySelector(".aviso").textContent="El numero debe ser un numero Entero e inferior al Stock"
                
            } else {
                tarjeta.querySelector(".aviso").textContent=""
            }
        })

        tarjeta.querySelector(".compra").addEventListener("click", () => {
            let cantidad = tarjeta.querySelector(".cantidad").value;
            pintaCarrito(p, cantidad)
            p.stock -=cantidad;
        })

        //control del span del stock
        if (p.stock<=4) {
            tarjeta.querySelector(".stock").innerHTML=`<b>- Quedan ${p.stock}</b>`;
        }
        if (!p.stock) {
            tarjeta.querySelector(".stock").innerHTML=`- <b>Sin stock</b>`;
        }
        
        aloes.appendChild(tarjeta);
     })

}

const checkCarrito = (p,cantidad) => {

}




window.onload = () => {

    pintaTarjetas(products);

}