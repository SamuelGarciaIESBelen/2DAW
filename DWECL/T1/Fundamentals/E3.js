let grade1 = parseInt(prompt("Insert the student's first grade"));
let grade2 = parseInt(prompt("Insert the student's second grade"));
let grade3 = parseInt(prompt("Insert the student's third grade"));
let grade4 = parseInt(prompt("Insert the student's fourth grade"));
let avg = (grade1 + grade2 + grade3 + grade4) / 4;
let res;

if (avg < 0 || avg > 10) {
    alert("The average isn't correct")
}

if (avg < 5) {
    res = "Failed";
} else if (avg < 6) {
    res = "Sufficient";
} else if (avg < 8) {
    res = "Good";
} else {
    res = "Oustanding";
}

document.getElementById("grades").innerHTML = `The student's grades are ${grade1}, ${grade2}, ${grade3} and ${grade4}`;
document.getElementById("avg").innerHTML = "The average is " + avg;
document.getElementById("res").innerHTML = "The final mark of the student is " + res;