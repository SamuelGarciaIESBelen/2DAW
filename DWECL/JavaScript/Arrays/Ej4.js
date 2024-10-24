// One-dimensional Array
const original = [1, 2, 3, 4, 5];

const cloned = original.slice();
cloned[0] = 10;
console.log(original);
console.log(cloned);

// Two-dimensional Array
const original2 = [[1, 2, 3],[4, 5, 6]];

// const cloned2 = original2.slice(); // Este método altera el array original
const cloned2 = original2.map(a => a.slice());
cloned2[1][1] = 50;
console.log(original2);
console.log(cloned2);