function repeatsTillYear(date = "2024/09/15", dayWeek = 1, year = 2070) {
    let day = new Date(date);
    let counter = 0;
    let yearString = "";

    while (day.getFullYear() <= year) {
        if (day.getDay() == dayWeek) {
            counter++;
            yearString += day.getFullYear() + " ";
        }
        day.setFullYear(day.getFullYear() + 1);
    }
    yearString += ("| Total: " + counter + " years");
    
    return yearString;
}
console.log("These years are: " + repeatsTillYear());