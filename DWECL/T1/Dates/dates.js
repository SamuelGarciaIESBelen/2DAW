let d = new Date();
console.log(d.toString());

d.setDate(d.getDate() + 1);
console.log(d.toString());

d.setDate(d.getMonth() + 1);
console.log(d.toString());