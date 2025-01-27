# Dungeon Master's Toolkit

## Descripción General
Vas a crear una herramienta para dirigir partidas de rol con las siguientes características:

1. **Un Bestiario**: listado de criaturas.
2. **Base de datos de Hechizos**: lista de hechizos con propiedades detalladas.
3. **Lista de Botín**: ítems de tesoro con propiedades diversas.

Se usarán tres archivos JSON (`bestias.json`, `hechizos.json`, `tesoros.json`) que serán combinados y procesados para mostrar datos cruzados en la aplicación.

---

## Requerimientos Técnicos

### Fetch Múltiple
1. **Carga Inicial**:
   - Usa `DOMContentLoaded` para realizar 3 fetch locales a los archivos `bestias.json`, `hechizos.json`, y `tesoros.json`.
   - Combina los datos en estructuras adecuadas para su uso en la aplicación.

### DOM, Eventos y Formularios
2. **Formularios y Listados**:
   - Un formulario para buscar criaturas por:
     - **Nombre**: usando métodos de strings como `toLowerCase`, `includes`.
     - **Tipo**: humanoide, dragón, etc.
     - **Nivel**: buscando criaturas igual o mayores a un nivel dado.
   - Un formulario para filtrar hechizos por:
     - **Escuela**: Evocación, Curación, etc.
     - **Nivel**: usando un número mínimo o exacto.
     - Muestra los hechizos filtrados en una tabla con columnas claras (nombre, nivel, escuela, coste, descripción).
   - Interfaz para generar botín aleatorio:
     - Selecciona la rareza (común, raro, épico).
     - Genera ítems aleatorios según la rareza seleccionada.

### Cruce de Datos
3. **Relaciones entre datos**:
   - Al mostrar un hechizo, indica qué tipos de criatura podrían verse afectadas usando iconos o badges (basado en `afectaA`).
   - Selecciona una criatura de la lista para ver:
     - Qué hechizos podrían aplicársele.
     - Panel combinado que incluya la criatura seleccionada + botín posible que podría soltar (al menos 1 objeto aleatorio de rareza "raro").

### setInterval y setTimeout
4. **Timers**:
   - Usa `setInterval` para simular un “reloj de turno”:
     - Cada X segundos, muestra en pantalla “¡Fin de turno!” para indicar el cambio de turno.
   - Usa `setTimeout` para mostrar un mensaje dramático tras 2 minutos:
     - Mensaje: “¡Desconexión del portal si no resuelves el encuentro!”.

### Cookies / LocalStorage
5. **Persistencia**:
   - Guarda en cookies o `localStorage`:
     - La última criatura consultada.
     - El último hechizo filtrado.
     - La última rareza de botín generada.
   - Recupera y aplica estos valores al recargar la página.

### Spread / Rest y Métodos de Strings
6. **Manejo de Arrays y Strings**:
   - Usa `spread` para fusionar listas de tesoros básicos y épicos según contexto.
   - Usa `rest` en una función para calcular la suma de `valorMonedas` de varios tesoros seleccionados.
   - Aplica métodos de strings como `replace`, `includes`, `trim`, `toLowerCase` para normalizar datos y realizar búsquedas efectivas.

---

## Estructura de Archivos

### index.html
```html
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <title>Dungeon Master's Toolkit</title>
</head>
<body>
  <h1>Dungeon Master's Toolkit</h1>

  <!-- Formulario para buscar criaturas -->
  <section>
    <h2>Buscar Criaturas</h2>
    <input type="text" id="searchCreature" placeholder="Nombre...">
    <select id="typeFilter">
      <option value="">Todos</option>
      <option value="humanoide">Humanoide</option>
      <option value="dragon">Dragón</option>
    </select>
    <input type="number" id="levelFilter" placeholder="Nivel mínimo">
    <button id="btnSearchCreatures">Buscar</button>
  </section>

  <!-- Formulario para filtrar hechizos -->
  <section>
    <h2>Filtrar Hechizos</h2>
    <select id="schoolFilter">
      <option value="">Todas las escuelas</option>
      <option value="Evocación">Evocación</option>
      <option value="Curación">Curación</option>
    </select>
    <input type="number" id="spellLevelFilter" placeholder="Nivel mínimo">
    <button id="btnFilterSpells">Filtrar</button>
  </section>

  <!-- Generar botín -->
  <section>
    <h2>Generar Botín</h2>
    <select id="lootRarity">
      <option value="común">Común</option>
      <option value="raro">Raro</option>
      <option value="épico">Épico</option>
    </select>
    <button id="btnGenerateLoot">Generar</button>
  </section>

  <!-- Contenedores de resultados -->
  <div id="creaturesContainer"></div>
  <div id="spellsContainer"></div>
  <div id="lootContainer"></div>

  <script src="dungeonMaster.js"></script>
</body>
</html>
```

### dungeonMaster.js
```javascript
document.addEventListener("DOMContentLoaded", () => {
  // 1. Fetch de bestias.json, hechizos.json, y tesoros.json
  Promise.all([
    fetch('bestias.json').then(res => res.json()),
    fetch('hechizos.json').then(res => res.json()),
    fetch('tesoros.json').then(res => res.json())
  ]).then(([creatures, spells, loot]) => {
    console.log(creatures, spells, loot);
    // TODO: Renderizar datos iniciales
  });

  // 2. Buscar criaturas

  // 3. Filtrar hechizos

  // 4. Generar botín

  // 5. Mostrar relaciones entre datos

  // 6. setInterval y setTimeout para mensajes

  // 7. Cookies/localStorage
});
```

---

**Entrega del Ejercicio Práctico**:
- Los nombres de los archivos que crees deben incluir tu nombre.
- En el título del archivo HTML debe aparecer tu nombre.
- En la parte superior del archivo HTML debe aparecer un encabezado con tu nombre y apellidos.

Sube un `.zip` con todos los archivos creados y enlazados correctamente a Moodle Centros.
