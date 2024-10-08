let numbers = [1, 2, 3, 4, 5];

let avg = numbers.reduce((accumulator, current) => accumulator + current);
avg /= numbers.length;

console.log("Array completo:");
console.log(numbers);

console.log("Media:");
console.log(avg);