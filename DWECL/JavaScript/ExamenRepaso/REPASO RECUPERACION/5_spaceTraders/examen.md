# Space Trader’s Market

## Historia
Eres un comerciante intergaláctico que viaja por distintos planetas vendiendo y comprando mercancías exóticas. Tienes un archivo JSON con una lista de planetas y sus mercados (producto, precio, stock…).

---

## Instrucciones
1. **Al cargar la página**:
   - Realiza un `fetch` al archivo `planets.json` para obtener la lista de planetas con sus productos.
   - Se mostrará en una tabla (o tarjetas) el nombre de cada planeta y los artículos disponibles.
2. **Interacción con los planetas**:
   - Al hacer clic en un planeta:
     - Expande su información usando `classList` o creando un `div` extra.
     - Muestra los productos del planeta, su precio y su stock actual.
3. **Filtros de productos**:
   - Implementa un formulario para buscar productos por nombre (ej. "Crystal" o "Fuel").
   - Al buscar, se mostrarán sólo los planetas que tienen productos que coincidan con el criterio de búsqueda.
4. **Comprar productos**:
   - Implementa un formulario que permita:
     - Seleccionar un planeta.
     - Elegir un producto disponible en dicho planeta.
     - Indicar la cantidad a comprar.
   - Al realizar una compra:
     - Se decrementa el stock del producto en el array.
     - Se repinta el DOM con la información actualizada.
5. **Simulación de fluctuaciones**:
   - Usa `setInterval` para simular la fluctuación de precios cada X segundos (suben o bajan un % aleatorio en cada planeta).
6. **Alertas de stock**:
   - Si el stock de algún producto baja de un nivel mínimo, muestra un mensaje de alerta usando `setTimeout`.
7. **Configuración persistente**:
   - Guarda en una cookie el último planeta visitado.
   - Al recargar la página, restaura la información del último planeta visitado.
8. **Uso de spread/rest**:
   - Implementa una función que calcule el precio total de varios productos seleccionados, usando `rest`.
   - Combina arrays de productos con el operador `spread`.

---

## Estructura de Archivos

### index.html
```html
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8" />
  <title>Space Trader's Market</title>
</head>
<body>
  <h1>Comerciante Intergaláctico</h1>

  <!-- Formulario de búsqueda de productos -->
  <section>
    <h2>Buscar Productos</h2>
    <input type="text" id="searchProduct" placeholder="Producto..." />
    <button id="btnSearch">Buscar</button>
  </section>

  <!-- Formulario de compra -->
  <section>
    <h2>Comprar</h2>
    <label for="planetSelect">Planeta:</label>
    <select id="planetSelect"></select>

    <label for="productSelect">Producto:</label>
    <select id="productSelect"></select>

    <label for="qty">Cantidad:</label>
    <input type="number" id="qty" min="1" />

    <button id="btnBuy">Comprar</button>
  </section>

  <!-- Contenedor de resultados -->
  <div id="marketsContainer"></div>

  <script src="main.js"></script>
</body>
</html>
```

### planets.json
```json
[
  {
    "nombre": "Zargon Prime",
    "productos": [
      { "nombre": "Crystal", "precio": 100, "stock": 50 },
      { "nombre": "Fuel", "precio": 200, "stock": 20 },
      { "nombre": "Food Packs", "precio": 20, "stock": 100 }
    ]
  },
  {
    "nombre": "Nova Terra",
    "productos": [
      { "nombre": "Fuel", "precio": 180, "stock": 10 },
      { "nombre": "Medicine", "precio": 300, "stock": 5 }
    ]
  },
  {
    "nombre": "Kepler X",
    "productos": [
      { "nombre": "Water", "precio": 10, "stock": 100 },
      { "nombre": "Crystal", "precio": 150, "stock": 15 }
    ]
  }
]
```

### main.js
```javascript
document.addEventListener("DOMContentLoaded", () => {
  // 1. Fetch al planets.json
  fetch('planets.json')
    .then(response => response.json())
    .then(planets => {
      console.log(planets);
      // TODO: Pintar datos en #marketsContainer
    });

  // 2. Pintar datos en #marketsContainer

  // 3. Cookies: guardar/recuperar planeta seleccionado

  // 4. setInterval para fluctuar precios

  // 5. setTimeout para alerta de stock bajo

  // 6. spread/rest, etc...
});
```

---

**Entrega del Ejercicio Práctico**:
- Los nombres de los archivos que crees deben incluir tu nombre.
- En el título del archivo HTML debe aparecer tu nombre.
- En la parte superior del archivo HTML debe aparecer un encabezado con tu nombre y apellidos.

Sube un `.zip` con todos los archivos creados y enlazados correctamente a Moodle Centros.
