// =====================
// **MÉTODOS DE STRINGS**
// =====================

// split(): Divide un string en partes según un separador y devuelve un array
const texto = "Hola, cómo, estás";
const partes = texto.split(", ");
console.log(partes); // ["Hola", "cómo", "estás"]

// Ejemplo práctico: Guardar en diferentes variables
const [saludo, pregunta, estado] = texto.split(", ");
console.log(saludo); // "Hola"
console.log(pregunta); // "cómo"
console.log(estado); // "estás"


// 1. slice(): Extrae una parte del string y devuelve un nuevo string
const ejemplo = "JavaScript es genial";
console.log(ejemplo.slice(0, 10)); // "JavaScript"

// 2. substring(): Extrae caracteres entre dos índices
console.log(ejemplo.substring(0, 10)); // "JavaScript"

// 3. includes(): Comprueba si un string contiene una subcadena específica
console.log(ejemplo.includes("genial")); // true

// 4. search(): Busca una subcadena y devuelve el índice de la primera coincidencia
console.log(ejemplo.search("genial")); // 15

// 5. indexOf(): Devuelve el índice de la primera aparición de una subcadena
console.log(ejemplo.indexOf("es")); // 11

// 6. replace(): Reemplaza la primera coincidencia de un patrón con otro valor
console.log(ejemplo.replace("genial", "increíble")); // "JavaScript es increíble"

// 7. replaceAll(): Reemplaza todas las coincidencias de un patrón con otro valor
console.log(ejemplo.replaceAll("a", "@")); // "J@v@Script es geni@l"

// 8. toUpperCase(): Convierte el string a mayúsculas
console.log(ejemplo.toUpperCase()); // "JAVASCRIPT ES GENIAL"

// 9. toLowerCase(): Convierte el string a minúsculas
console.log(ejemplo.toLowerCase()); // "javascript es genial"

// 10. trim(): Elimina los espacios en blanco de ambos extremos del string
const textoConEspacios = "   Hola mundo   ";
console.log(textoConEspacios.trim()); // "Hola mundo"

// 12. startsWith(): Comprueba si el string comienza con una subcadena específica
console.log(ejemplo.startsWith("Java")); // true

// 13. endsWith(): Comprueba si el string termina con una subcadena específica
console.log(ejemplo.endsWith("genial")); // true

// 14. repeat(): Repite el string el número de veces especificado
console.log(ejemplo.repeat(2)); // "JavaScript es genialJavaScript es genial"

// 15. charAt(): Devuelve el carácter en un índice específico
console.log(ejemplo.charAt(0)); // "J"

// 16. charCodeAt(): Devuelve el código Unicode del carácter en un índice específico
console.log(ejemplo.charCodeAt(0)); // 74

// 17. concat(): Concatena dos o más strings y devuelve el resultado
const saludoCompleto = saludo.concat(" ", "mundo");
console.log(saludoCompleto); // "Hola mundo"

// 18. lastIndexOf(): Devuelve el índice de la última aparición de una subcadena
console.log(ejemplo.lastIndexOf("a")); // 3

// 19. toLocaleLowerCase(): Convierte el string a minúsculas según la configuración regional
console.log(ejemplo.toLocaleLowerCase()); // "javascript es genial"

// 20. toLocaleUpperCase(): Convierte el string a mayúsculas según la configuración regional
console.log(ejemplo.toLocaleUpperCase()); // "JAVASCRIPT ES GENIAL"

// 21. trimStart(): Elimina los espacios en blanco del principio del string
console.log(textoConEspacios.trimStart()); // "Hola mundo   "

// 22. trimEnd(): Elimina los espacios en blanco del final del string
console.log(textoConEspacios.trimEnd()); // "   Hola mundo"

// 23. valueOf(): Devuelve el valor primitivo del string
console.log(ejemplo.valueOf()); // "JavaScript es genial"
