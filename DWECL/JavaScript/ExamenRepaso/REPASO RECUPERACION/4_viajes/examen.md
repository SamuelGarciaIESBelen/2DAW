# Examen: Planificador de Viajes con Recordatorio Automático

## Idea Principal

Crearás una aplicación para gestionar viajes. Cada viaje es un objeto con las siguientes propiedades:  
- `destino`
- `fechas` (objeto con `inicio` y `fin`)
- `notas`
- `imagen`
- `checklist` (un array de strings).

---

## Objetivos Clave

### Estructura y DOM
1. **Carga inicial**:  
   - Al abrir la aplicación (`onload`), se cargan los viajes de un array inicial o mediante un `fetch` a un archivo JSON.  
   - Genera dinámicamente una lista (o formato alternativo) que muestre todos los viajes.  
   - Al hacer clic en un viaje, muestra los detalles del viaje seleccionado y un formulario para editarlo.

---

### Formulario y Manejo de Arrays
2. **Gestión de viajes**:  
   - Crea un formulario para:  
     - **Añadir nuevos viajes**: permite introducir datos como destino, fechas, notas e imagen.  
     - **Filtrar viajes**: permite buscar por destino o año (basado en las fechas).  
   - Usa métodos de strings como `search()`, `match()`, `replace()`, `toLowerCase()`, y `trim()` para normalizar y procesar los datos ingresados.  
3. **Checklist**:  
   - Implementa un botón que permita añadir ítems a la checklist del viaje seleccionado.  
   - Usa el operador `rest` para actualizar la checklist y refleja los cambios en el DOM.

---

### setInterval y setTimeout
4. **Recordatorios automáticos**:  
   - Implementa un `setInterval` que cada minuto revise si alguna fecha de inicio de un viaje está cerca.  
     - Si es así, muestra un mensaje de recordatorio (puede ser un `alert` o un elemento en el DOM).  
5. **Tips de viaje**:  
   - Al abrir la aplicación, muestra un banner de “Tips de viaje” en el DOM.  
   - Usa `setTimeout` para ocultar automáticamente el banner tras varios segundos.

---

### Cookies
6. **Configuración de vista**:  
   - Implementa un **modo de vista** (ej. modo lista o modo tarjetas).  
   - Guarda esta configuración en una cookie para que al recargar la página se mantenga la vista seleccionada.  
   - Recupera la cookie al cargar y renderiza en el modo correspondiente.

---

## Puntos de Evaluación

1. Creación y manipulación del formulario para añadir y filtrar viajes.
2. Uso de arrays para gestionar la checklist (con `push` o `spread`).
3. Filtrado de fechas y destinos utilizando métodos de strings.
4. Implementación de `setInterval` y `setTimeout` para recordatorios y mensajes.
5. Uso de cookies para guardar y recuperar preferencias de la vista.

---

## Instrucciones

- Los nombres de los archivos que crees deben incluir tu nombre.
- En el título del archivo HTML debe aparecer tu nombre.
- En la parte superior del archivo HTML debe aparecer un encabezado con tu nombre y apellidos.

## Entrega del Ejercicio Práctico

- Sube un `.zip` con todos los archivos creados y enlazados correctamente.
- Entrega el archivo en la tarea correspondiente de Moodle Centros.
