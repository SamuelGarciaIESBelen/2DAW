function currentTime() {
    let d = new Date();
    
    const day = {
        0:"12AM",
        1:"1AM",
        2:"2AM",
        3:"3AM",
        4:"4AM",
        5:"5AM",
        6:"6AM",
        7:"7AM",
        8:"8AM",
        9:"9AM",
        10:"10AM",
        11:"11AM",
        12:"12PM",
        13:"1PM",
        14:"2PM",
        15:"3PM",
        16:"4PM",
        17:"5PM",
        18:"6PM",
        19:"7PM",
        20:"8PM",
        21:"9PM",
        22:"10PM",
        23:"11PM"
    }

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

    return week[d.getDay()] + ". Now: " + day[d.getHours()] + " " + d.getMinutes() + ":" + d.getSeconds();
}
console.log(currentTime());