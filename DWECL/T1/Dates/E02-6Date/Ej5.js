function repeatsTillYear(date = "2024/09/15", dayWeek = 1, year = 2070) {
    let day = new Date(date);
    let counter = 0;
    let yearString = "";

    while (day.getFullYear() <= year) {
        if (day.getDay() == dayWeek) {
            counter++;
            yearString += day.getFullYear() + "\n";
        }
        day.setFullYear(day.getFullYear() + 1);
    }
    return counter;
}

console.log("This will happen " + repeatsTillYear() + " times till " + 2070);
// console.log("These years are:\n" + yearString);