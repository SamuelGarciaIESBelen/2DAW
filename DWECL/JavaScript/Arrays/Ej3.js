function removeDuplicates(arr) {
    return [...new Set(arr)]; // Los puntos suspensivos se llaman "spread operator" y sirve para desestructurar un array/conjunto/lista
}
const numbers = [1, 2, 2, 3, 4, 4, 5, 5, 5];
console.log(removeDuplicates(numbers));