num1 = parseInt(prompt("Introduce el primer número"));
num2 = parseInt(prompt("Introduce el segundo número"));
suma = num1 + num2;

    // Ejercicio 1
    console.log("El primer número es " + num1 + "\n" +
        "El segundo número es " + num2 + "\n" +
        "La suma de ambos es " + suma
    );

    // Ejercicio 2
    alert(`El primer número es ${num1}
        El segundo número es ${num2}
        La suma de ambos es ${suma}`
    );

    // Ejercicio 3
    document.getElementById("primero").innerHTML = "El primer número es " + num1;
    document.getElementById("segundo").innerHTML = "El segundo número es " + num2;
    document.getElementById("suma").innerHTML = "La suma de ambos es " + suma;

    // Ejercicio 4
    document.getElementById("sumaP").innerHTML += `<br><br><b>El primer número es ${num1}
        <br>El segundo número es ${num2}
        <br>La suma de ambos es ${num1 + num2}</b>`;