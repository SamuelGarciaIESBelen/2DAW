let today = new Date();
let start = new Date("2024/09/15");
console.log((today - start) / 1000 / 60 / 60 / 24 + " days has been passed since " + start.toDateString());

let mondays = 0;
let mondayString = "";
while (today >= start) {
    if (today.getDay() == 1) {
        mondays++;
        mondayString = today.toDateString() + "\n" + mondayString;
    }
    today.setDate(today.getDate() - 1);
}
console.log("There has been " + mondays + " mondays since " + start.toDateString());
console.log("These mondays are:\n" + mondayString);