let grades = [];
let grade = Number(prompt("Enter a grade:"));


function pedirNota() {
    while (!isNaN(grade)) {
        grades.push(grade);
        grade = Number(prompt("Enter a grade:"));
    }
}

function media() {
    let total = 0;
    for (let i = 0; i < grades.length; i++) {
        total += grades[i];
    }
    return total / grades.length;
}

pedirNota();
function puntuacionNota() {
    if (media() < 5) {
        return "Fail";
    } else if (media() >= 5 && media() < 7) {
        return "Suficient";
    } else if (media() >= 7 && media() < 9) {
        return "Good";
    } else if (media() >= 9 && media() < 10) {
        return "Excellent";
    } else {
        return "Outstanding";
    }
}
alert("The average is: " + media() + "\n" + "The grade is: " + puntuacionNota());