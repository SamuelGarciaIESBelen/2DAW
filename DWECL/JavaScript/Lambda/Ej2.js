let numbers = [1, 2, 3, 4, 5];

// Traditional way
let squareT = function(numbers) {
    let squared = [];
    let counter = 0;

    for (let i of numbers) {
        squared[counter++] = i * i;
    }
    return squared;
}
let squaredT = squareT(numbers);

console.log("Traditional way:");
console.log(squaredT);

// Lambda expression
let squareL = (a) => a = a.map(e => e * e);
let squaredL = squareL(numbers);

console.log("Lambda expression:");
console.log(squaredL);