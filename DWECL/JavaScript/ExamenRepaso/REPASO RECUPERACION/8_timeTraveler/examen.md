# Time Travel Planner

## Historia
Un planificador de viajes en el tiempo: cada viaje tiene un evento histórico, año, ubicación, nivel de riesgo temporal, y notas adicionales.

---

## Instrucciones

### DOM + Mapas
1. **Carga inicial**:
   - Usa un array local o un `fetch` a `destinos.json` para cargar posibles destinos.
   - Renderiza tarjetas para cada destino con:
     - Evento histórico.
     - Año.
     - Ubicación.
     - Botón "Ver Riesgo".
2. **Botón "Ver Riesgo"**:
   - Al pulsar, usa `classList.add` para colorear la tarjeta según el nivel de riesgo:
     - **Verde**: Riesgo bajo.
     - **Amarillo**: Riesgo medio.
     - **Rojo**: Riesgo alto.

---

### Formularios
3. **Filtrar destinos**:
   - Implementa filtros avanzados:
     - Un **input** para filtrar por año (por ejemplo, "<= 1800" o "> 2000").
     - Un **select** para filtrar por nivel de riesgo (bajo, medio, alto).
   - Al pulsar "Filtrar", actualiza el DOM con los destinos que cumplan los criterios.
4. **Añadir notas personales**:
   - Crea un formulario para agregar una "nota personal" a un destino.
     - Esto actualiza el objeto correspondiente en el array o JSON.
     - Repinta la tarjeta con la nueva nota incluida.

---

### Timers
5. **Contador de portal**:
   - Usa `setInterval` para simular el tiempo restante antes de que el portal temporal se abra.
     - Cada 5 segundos, reduce el contador mostrado en `#portalCountdown`.
6. **Advertencia del portal**:
   - Usa `setTimeout` para mostrar un popup dramático tras 30 segundos:
     - Mensaje: "¡El portal se está cerrando!".

---

### Cookies & Strings
7. **Última nota**:
   - Guarda en una cookie la última nota personal escrita para un destino.
   - Al recargar la página, recupera y muestra esa nota en su tarjeta correspondiente.
8. **Manipulación de strings**:
   - Usa métodos como `replace`, `substring`, o `includes` para normalizar ubicaciones o descripciones.
9. **Spread/Rest**:
   - Aplica `spread` para combinar arrays de destinos adicionales (si es necesario).

---

## Estructura de Archivos

### index.html
```html
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <title>Time Travel Planner</title>
</head>
<body>
  <h1>Planificador de Viajes en el Tiempo</h1>

  <!-- Filtros -->
  <section>
    <h2>Filtros</h2>
    <label>Año Máximo:</label>
    <input type="number" id="maxYear" />
    
    <label>Riesgo:</label>
    <select id="riskSelect">
      <option value="">Todos</option>
      <option value="bajo">Bajo</option>
      <option value="medio">Medio</option>
      <option value="alto">Alto</option>
    </select>
    <button id="btnFilter">Filtrar</button>
  </section>

  <!-- Contador portal -->
  <div id="portalCountdown"></div>

  <!-- Contenedor de destinos -->
  <div id="destinationsContainer"></div>

  <script src="timeTravel.js"></script>
</body>
</html>
```

### destinos.json (opcional)
```json
[
  {
    "eventoHistorico": "Construcción de las Pirámides",
    "anio": -2560,
    "ubicacion": "Giza, Egipto",
    "riesgoTemporal": "medio",
    "notas": "Podría asustar a los constructores..."
  },
  {
    "eventoHistorico": "Primera Computadora Personal",
    "anio": 1975,
    "ubicacion": "Albuquerque, Nuevo México",
    "riesgoTemporal": "bajo",
    "notas": ""
  },
  {
    "eventoHistorico": "Nacimiento de la imprenta",
    "anio": 1440,
    "ubicacion": "Mainz, Alemania",
    "riesgoTemporal": "medio",
    "notas": ""
  },
  {
    "eventoHistorico": "Revolución IA masiva",
    "anio": 2050,
    "ubicacion": "Futuro incierto",
    "riesgoTemporal": "alto",
    "notas": "Posibles paradoxas existenciales"
  }
]
```

### timeTravel.js
```javascript
document.addEventListener("DOMContentLoaded", () => {
  // 1. Fetch destinos.json o array local
  fetch('destinos.json')
    .then(response => response.json())
    .then(destinations => {
      console.log(destinations);
      // TODO: Renderizar tarjetas
    });

  // 2. Pintar tarjetas

  // 3. Filtros => year, riesgo

  // 4. setInterval => countdown portal

  // 5. setTimeout => alerta dramática

  // 6. Cookies => guardar notas

  // 7. string methods + spread/rest
});
```

---

**Entrega del Ejercicio Práctico**:
- Los nombres de los archivos que crees deben incluir tu nombre.
- En el título del archivo HTML debe aparecer tu nombre.
- En la parte superior del archivo HTML debe aparecer un encabezado con tu nombre y apellidos.

Sube un `.zip` con todos los archivos creados y enlazados correctamente a Moodle Centros.
