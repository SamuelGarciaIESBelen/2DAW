// Ejemplo de iteración sobre un objeto usando Object.keys, Object.values y Object.entries

const persona = { nombre: "Juan", edad: 37 };

// Iterar sobre las claves del objeto usando Object.keys
// Object.keys(persona) devuelve ["nombre", "edad"]
for (let clave of Object.keys(persona)) {
  console.log(clave); // "nombre", "edad"
}

// Iterar sobre los valores del objeto usando Object.values
// Object.values(persona) devuelve ["Juan", 37]
for (let valor of Object.values(persona)) {
  console.log(valor); // "Juan", 37
}

// Iterar sobre las entradas del objeto usando Object.entries
// Object.entries(persona) devuelve [["nombre", "Juan"], ["edad", 37]]
for (let [clave, valor] of Object.entries(persona)) {
  console.log(`${clave}: ${valor}`);
  // Salida:
  // nombre: Juan
  // edad: 37
}
