const months = [
    {name: "January", number: 1, days: 31},
    {name: "February", number: 2, days: 28},
    {name: "March", number: 3, days: 31},
    {name: "April", number: 4, days: 30},
    {name: "May", number: 5, days: 31},
    {name: "June", number: 6, days: 30},
    {name: "July", number: 7, days: 31},
    {name: "August", number: 8, days: 31},
    {name: "September", number: 9, days: 30},
    {name: "October", number: 10, days: 31},
    {name: "November", number: 11, days: 30},
    {name: "December", number: 12, days: 31}
];

// Display the names of the months that have 30 days
const monthsWith30Days = months.filter(m => m.days == 30).map((m) => m.name);
console.log("Months with 30 days: ", monthsWith30Days);

// Display the names of even-numbered months
const evenMonths = months.filter(m => m.number % 2 == 0);
console.log("Months with even numbers are: ", evenMonths.map(m => m.name));

// Display the total number of days of all months
const totalDays = months.reduce((acc, cur) => acc + cur.days, 0);
console.log("There are ", totalDays, " days in a year");