# Riddle Maze Escaperoom

## Historia
Estás atrapado en un laberinto lleno de acertijos. Cada sección del laberinto exige resolver un enigma para avanzar. Tienes un archivo JSON con la lista de acertijos y sus respuestas.

---

## Instrucciones

1. **Al cargar la página**:
   - Realiza un `fetch` al archivo `riddles.json` para obtener la lista de acertijos.
   - Muestra un enigma a la vez en el contenedor `#riddleContainer`.
2. **Resolver enigmas**:
   - El usuario ingresa la respuesta en el campo de texto y pulsa el botón "Enviar".
   - Si la respuesta es correcta:
     - Cambia la sección del DOM para indicar "Enigma resuelto".
     - Suma puntos al contador.
     - Avanza al siguiente enigma.
   - Si la respuesta es incorrecta:
     - Resalta el enunciado del enigma usando `classList`.
     - Da la opción de pedir una pista, que saca un elemento del array `pistas` asociado al enigma.
3. **Cuenta regresiva**:
   - Usa `setInterval` para reducir el tiempo de escape cada X segundos.
     - Si el tiempo llega a 0, muestra "Game Over".
   - Usa `setTimeout` para mostrar un mensaje dramático tras 3 intentos fallidos antes de permitir reintentar.
4. **Persistencia del estado**:
   - Guarda en una cookie o `localStorage`:
     - El enigma actual.
     - La puntuación del usuario.
   - Al recargar la página, permite continuar desde donde se dejó.
5. **Uso de spread/rest**:
   - Usa `spread` o `rest` para combinar arrays de pistas o repartirlas según la dificultad.
   - Usa métodos de strings como `replace` o `includes` para normalizar la respuesta ingresada.

---

## Estructura de Archivos

### index.html
```html
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8" />
  <title>Riddle Maze Escaperoom</title>
</head>
<body>
  <h1>¡Sal del Laberinto Respondiendo a los Enigmas!</h1>
  <div id="riddleContainer"></div>
  <div>
    <input type="text" id="answerInput" placeholder="Tu respuesta aquí" />
    <button id="btnSubmitAnswer">Enviar</button>
    <button id="btnHint">Pedir pista</button>
  </div>
  <div id="timeLeft"></div>
  <div id="score"></div>

  <script src="maze.js"></script>
</body>
</html>
```

### riddles.json
```json
[
  {
    "id": 1,
    "textoEnigma": "Soy pequeño y redondo, a veces dulce, a veces agrio. ¿Qué soy?",
    "respuesta": "una fruta",
    "pistas": ["Es comestible", "Puede ser una uva, una cereza..."],
    "dificultad": "fácil"
  },
  {
    "id": 2,
    "textoEnigma": "¿Qué sube y baja pero siempre está en el mismo sitio?",
    "respuesta": "las escaleras",
    "pistas": ["Casa, escalones...", "Se usa para cambiar de piso"],
    "dificultad": "media"
  },
  {
    "id": 3,
    "textoEnigma": "Camino sin moverme, lloro sin tristeza, echo humo sin fuego. ¿Quién soy?",
    "respuesta": "una nube",
    "pistas": ["Está en el cielo", "Produce lluvia"],
    "dificultad": "difícil"
  }
]
```

### maze.js
```javascript
document.addEventListener("DOMContentLoaded", () => {
  // 1. Fetch riddles.json y guardar en un array
  fetch('riddles.json')
    .then(response => response.json())
    .then(riddles => {
      console.log(riddles);
      // TODO: Mostrar el primer enigma en #riddleContainer
    });

  // 2. Manejar submit de respuesta

  // 3. Pedir pista => rest/spread

  // 4. setInterval para countdown

  // 5. setTimeout si hay X fallos

  // 6. Cookies/localStorage para guardar estado
});
```

---

**Entrega del Ejercicio Práctico**:
- Los nombres de los archivos que crees deben incluir tu nombre.
- En el título del archivo HTML debe aparecer tu nombre.
- En la parte superior del archivo HTML debe aparecer un encabezado con tu nombre y apellidos.

Sube un `.zip` con todos los archivos creados y enlazados correctamente a Moodle Centros.
