let clase = ["Shanshui", "Samuel", "Daniel", "Jonathan", "Alejandro", "David", "Zahira", "Aroa"];

let saludar = (nombres) => nombres.map(nombre => `Buenos días, ${nombre}`);

let saludos = saludar(clase);

console.log(saludos);