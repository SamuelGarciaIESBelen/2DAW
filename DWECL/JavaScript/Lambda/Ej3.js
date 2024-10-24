let numbers = [-1, 2, -3, 4, -5];

// Traditional way
let positiveT = function(numbers) {
    let positives = [];
    let counter = 0;

    for (let i of numbers) {
        positives[counter++] = Math.abs(i);
    }
    return positives;
}
let positivesT = positiveT(numbers);

console.log("Traditional way:");
console.log(positivesT);

// Lambda expression
let positiveL = (a) => a = a.map(e => Math.abs(e));
let positivesL = positiveL(numbers);

console.log("Lambda expression:");
console.log(positivesL);