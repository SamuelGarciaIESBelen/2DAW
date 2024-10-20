// Easy way
function fullDateEasy(date) {
    let d = new Date(date);
    return d.toDateString();
}
console.log(fullDateEasy("2001/01/19"));

// Complex way
function fullDate(date) {
    const week = {
        0: "Sunday",
        1: "Monday",
        2: "Tuesday",
        3: "Wednesday",
        4: "Thursday",
        5: "Friday",
        6: "Saturday",
        7: "Sunday"
    }
    const calendar = ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"];
    let d = new Date(date);

    return d.getDate() + " " + week[d.getDay()] + " " + calendar[d.getMonth()] + " " + d.getFullYear();
}
console.log(fullDate("2001/01/19"));