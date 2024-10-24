function arraysAreEqual(arr1, arr2) {
    if (arr1.length !== arr2.length) return false;
    return arr1.every((value, i) => value === arr2[i]);
}

const array1 = [1, 2, 3, 4];
const array2 = [1, 2, 3, 4];
const array3 = [1, 2, 3, 5];

console.log(arraysAreEqual(array1, array2));
console.log(arraysAreEqual(array1, array3));