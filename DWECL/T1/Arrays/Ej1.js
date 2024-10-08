function sortByLastname(array) {
    return array.sort((a, b) => {
        let nameA = a.split(" ");
        let nameB = b.split(" ");
        
        let lastA = nameA.length === 3 ? nameA[1] : nameA[1];
        let lastB = nameB.length === 3 ? nameB[1] : nameB[1];
        
        let res = 0;
        if (lastA < lastB) res = -1;
        if (lastA > lastB) res = 1;
        return res;
    });
}
const students = ["John Doe", "Ana Garcia Lopez", "Emily Brown", "Carlos Ruiz Sanchez", "Samuel García Zorrilla", "Shanshui Wang"];
console.log(sortByLastname(students));