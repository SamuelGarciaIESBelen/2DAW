# Anime Streaming Dashboard

## Historia
Tienes un panel de control de series de anime. Cada serie tiene las siguientes propiedades: 
- `titulo`
- `temporadas`
- `capitulos`
- `genero`
- `imagen`
- `sinopsis`

---

## Instrucciones

### DOM + Filtros Avanzados
1. **Carga inicial**:
   - Realiza un `fetch` al archivo `animeData.json` para obtener la lista de animes.
   - Renderiza tarjetas para cada anime en el contenedor `#animeContainer`.
2. **Filtros**:
   - Implementa filtros avanzados que incluyan:
     - Un **input** para buscar por título (usando `toLowerCase`, `includes`, etc.).
     - Un **select** para filtrar por género (opciones como "shounen", "shojo", etc.).
     - Un **input de número** para buscar por mínimo de temporadas.
   - Al pulsar "Filtrar", actualiza el DOM mostrando solo los animes que cumplan los criterios.

---

### Formularios y Eventos
3. **Formulario para añadir un nuevo anime**:
   - Crea un formulario que permita al usuario agregar un nuevo anime con los siguientes campos:
     - Título
     - Género
     - Nº de Temporadas
     - Nº de Capítulos
     - URL de la Imagen
     - Sinopsis
   - Al enviar el formulario:
     - Actualiza el array local con el nuevo anime.
     - Repinta el DOM para incluir el nuevo anime en las tarjetas.
4. **Mostrar sinopsis**:
   - Incluye un botón "Ver Sinopsis" en cada tarjeta de anime que expanda/colapse la descripción usando `classList.toggle`.

---

### Timers
5. **Carrusel de imágenes**:
   - Implementa un `setInterval` para rotar automáticamente las imágenes destacadas de los animes en un carrusel.
6. **Aviso de novedades**:
   - Usa un `setTimeout` para mostrar un mensaje de "Novedades en streaming" tras 10 segundos de cargar la página.

---

### Cookies & Spread
7. **Último filtro**:
   - Guarda en una cookie el último género filtrado.
   - Al recargar la página, restaura y aplica ese filtro.
8. **Fusionar datos**:
   - Usa el operador `spread` para fusionar los animes del JSON con un array local de animes extra (si es necesario).

---

## Estructura de Archivos

### index.html
```html
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <title>Anime Streaming Dashboard</title>
</head>
<body>
  <h1>Panel de Anime</h1>

  <!-- Filtros -->
  <section>
    <label>Buscar Título: </label>
    <input type="text" id="searchTitle" />
    <br/>
    <label>Género: </label>
    <select id="genreFilter">
      <option value="">Todos</option>
      <option value="shounen">Shounen</option>
      <option value="seinen">Seinen</option>
      <option value="shojo">Shojo</option>
      <option value="isekai">Isekai</option>
    </select>
    <br/>
    <label>Temporadas mínimas: </label>
    <input type="number" id="minSeasons" min="1" />
    <button id="btnFilter">Filtrar</button>
  </section>

  <!-- Form añadir anime -->
  <section>
    <h2>Añadir Nuevo Anime</h2>
    <input id="newTitle" type="text" placeholder="Título" />
    <input id="newGenre" type="text" placeholder="Género" />
    <input id="newSeasons" type="number" placeholder="Nº Temporadas" />
    <input id="newChapters" type="number" placeholder="Nº Capítulos" />
    <input id="newImage" type="text" placeholder="URL Imagen" />
    <textarea id="newSynopsis" placeholder="Sinopsis"></textarea>
    <button id="btnAddAnime">Añadir</button>
  </section>

  <!-- Carrusel imágenes -->
  <div id="carousel"></div>

  <!-- Contenedor animes -->
  <div id="animeContainer"></div>

  <script src="anime.js"></script>
</body>
</html>
```

### animeData.json
```json
[
  {
    "titulo": "Fullmetal Alchemist: Brotherhood",
    "temporadas": 1,
    "capitulos": 64,
    "genero": "shounen",
    "imagen": "images/fma.jpg",
    "sinopsis": "Dos hermanos que... (bla bla)"
  },
  {
    "titulo": "Attack on Titan",
    "temporadas": 4,
    "capitulos": 87,
    "genero": "shounen",
    "imagen": "images/aot.jpg",
    "sinopsis": "La humanidad vive encerrada... (bla bla)"
  },
  {
    "titulo": "Violet Evergarden",
    "temporadas": 1,
    "capitulos": 13,
    "genero": "shojo",
    "imagen": "images/violet.jpg",
    "sinopsis": "Una chica autómata que... (bla bla)"
  }
]
```

### anime.js
```javascript
document.addEventListener("DOMContentLoaded", () => {
  // 1. fetch animeData.json
  fetch('animeData.json')
    .then(response => response.json())
    .then(animeList => {
      console.log(animeList);
      // TODO: Renderizar tarjetas
    });

  // 2. Pintar tarjetas anime

  // 3. Filtrado con includes, toLowerCase, etc.

  // 4. Añadir anime con form => actualizas array + DOM

  // 5. setInterval => carrusel

  // 6. setTimeout => anuncio

  // 7. Cookies => recordar último filtro de género

  // 8. spread => fusionar con otro array local, etc.
});
```

---

**Entrega del Ejercicio Práctico**:
- Los nombres de los archivos que crees deben incluir tu nombre.
- En el título del archivo HTML debe aparecer tu nombre.
- En la parte superior del archivo HTML debe aparecer un encabezado con tu nombre y apellidos.

Sube un `.zip` con todos los archivos creados y enlazados correctamente a Moodle Centros.
