let date = new Date("2025-01-01").toUTCString();
let key = "girl";
let value = "Mary Jane";

let key2 = "boy";
let value2 = "Peter Parker";

document.cookie = encodeURIComponent(key) + "=" + encodeURIComponent(value);
document.cookie = encodeURIComponent(key2) + "=" + encodeURIComponent(value2);
console.log(document.cookie);
