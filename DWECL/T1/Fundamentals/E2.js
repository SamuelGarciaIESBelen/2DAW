let num1 = parseInt(prompt("Insert the first number"));
let num2 = parseInt(prompt("Insert the second number"));
let option = parseInt(prompt(`Choose the operation:
    1. Addition
    2. Subtraction
    3. Multiplication`
    ));
let sign;
let res;
let comp;

switch (option) {
    case 1:
        res = num1 + num2;
        sign = '+';
        break;
    case 2:
        res = num1 - num2;
        sign = '-';
        break;
    case 3:
        res = num1 * num2;
        sign = '*';
        break;
    default:
        alert("Choose a correct option")
        break;
}

if (num1 > num2) {
    comp = "mayor";
} else if (num1 < num2) {
    comp = "menor";
} else {
    comp = "igual";
}

document.getElementById("res").innerHTML = `${num1} ${sign} ${num2} = ${res}`;
document.getElementById("comp").innerHTML = `${num1} es ${comp} que ${num2}`;
