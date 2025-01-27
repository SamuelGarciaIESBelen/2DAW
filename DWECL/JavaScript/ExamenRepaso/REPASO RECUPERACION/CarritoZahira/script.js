// Lista de productos
const products = [
    { id: 1, nombre: "Producto A", precio: 10, stock: 3, imagen: "img/productoA.jpg" },
    { id: 2, nombre: "Producto B", precio: 20, stock: 0, imagen: "img/productoB.jpg" },
    { id: 3, nombre: "Producto C", precio: 15, stock: 10, imagen: "img/productoC.jpg" },
];

// Mostrar productos en la tienda
function mostrarProductos() {
    const container = document.querySelector(".container");
    container.innerHTML = ""; // Limpiar contenedor

    products.forEach(product => {
        const divProducto = document.createElement("div");
        divProducto.classList.add("producto");

        const imgProducto = document.createElement("img");
        imgProducto.src = product.imagen;
        imgProducto.alt = product.nombre;

        const pNombre = document.createElement("p");
        pNombre.textContent = product.nombre;

        const pPrecio = document.createElement("p");
        pPrecio.textContent = `€ ${product.precio.toFixed(2)}`;

        const pStock = document.createElement("p");
        const inputCantidad = document.createElement("input");
        const btnComprar = document.createElement("button");

        if (product.stock === 0) {
            pStock.textContent = "Sin stock";
            btnComprar.disabled = true;
        } else if (product.stock <= 4) {
            pStock.textContent = `¡Últimas unidades! (${product.stock})`;
        } else {
            pStock.textContent = `Stock: ${product.stock}`;
        }

        inputCantidad.type = "number";
        inputCantidad.min = 1;
        inputCantidad.max = product.stock;
        inputCantidad.value = 1;

        btnComprar.textContent = "Comprar";
        btnComprar.classList.add("btnComprar");

        divProducto.append(imgProducto, pNombre, pPrecio, pStock, inputCantidad, btnComprar);
        container.appendChild(divProducto);
    });
}

// Crear fila en la tabla del carrito
function agregarAlCarrito(event) {
    const productoDiv = event.target.closest(".producto");
    const nombre = productoDiv.querySelector("p:first-of-type").textContent;
    const precio = parseFloat(productoDiv.querySelector("p:nth-of-type(2)").textContent.slice(1));
    const cantidad = parseInt(productoDiv.querySelector("input").value);

    const tbody = document.querySelector("tbody");
    const tr = document.createElement("tr");

    tr.innerHTML = `
        <td>${nombre}</td>
        <td>
            <button class="btnMenos">-</button>
            ${cantidad}
            <button class="btnMas">+</button>
        </td>
        <td>€ ${precio.toFixed(2)}</td>
        <td>€ ${(precio * cantidad).toFixed(2)}</td>
        <td><button class="btnEliminar">Eliminar</button></td>
    `;

    tbody.appendChild(tr);

    actualizarTotal();
}

// Actualizar el total del carrito
function actualizarTotal() {
    const filas = document.querySelectorAll("tbody tr");
    let total = 0;

    filas.forEach(fila => {
        const totalProductoTexto = fila.querySelector("td:nth-of-type(4)").textContent.slice(1);
        const totalProducto = parseFloat(totalProductoTexto) || 0;
        total += totalProducto;
    });

    document.querySelector("#total").textContent = `Total: € ${total.toFixed(2)}`;
}


// Eliminar un producto del carrito
function eliminarProducto(event) {
    if (event.target.classList.contains("btnEliminar")) {
        const fila = event.target.closest("tr");
        fila.remove();
        actualizarTotal();
    }
}

function ajustarCantidad(event) {
    const fila = event.target.closest("tr"); // Obtén la fila actual
    const cantidadTd = fila.querySelector("td:nth-of-type(2)");
    const totalTd = fila.querySelector("td:nth-of-type(4)");
    const productoNombre = fila.querySelector("td:nth-of-type(1)").textContent.trim(); // Nombre del producto
    const precio = parseFloat(fila.querySelector("td:nth-of-type(3)").textContent.slice(1));

    // Encuentra el producto correspondiente basado en su nombre
    const producto = products.find(p => p.nombre === productoNombre);

    // Obtener la cantidad actual
    let cantidadTexto = cantidadTd.textContent.trim().match(/\d+/);
    let cantidad = cantidadTexto ? parseInt(cantidadTexto[0]) : 1;

    // Ajustar la cantidad según los botones
    if (event.target.classList.contains("btnMas") && cantidad < producto.stock) {
        cantidad++;
    } else if (event.target.classList.contains("btnMenos") && cantidad > 1) {
        cantidad--;
    }

    // Actualizar la fila en la tabla
    cantidadTd.innerHTML = `
        <button class="btnMenos">-</button>
        ${cantidad}
        <button class="btnMas">+</button>
    `;
    totalTd.textContent = `€ ${(precio * cantidad).toFixed(2)}`;

    // Actualizar el total general
    actualizarTotal();
}



// Inicializar la aplicación
window.onload = () => {
    mostrarProductos();

    document.querySelector(".container").addEventListener("click", event => {
        if (event.target.classList.contains("btnComprar")) {
            agregarAlCarrito(event);
        }
    });

    document.querySelector("tbody").addEventListener("click", event => {
        if (event.target.classList.contains("btnEliminar")) {
            eliminarProducto(event);
        } else if (event.target.classList.contains("btnMas") || event.target.classList.contains("btnMenos")) {
            ajustarCantidad(event);
        }
    });
};
