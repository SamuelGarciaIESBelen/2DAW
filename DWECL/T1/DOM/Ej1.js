const elem = document.body;

// 1. Number of links on the page
const links = elem.getElementsByTagName("a");
console.log("Number of links: " + links.length);

// 2. Address to which the penultimate link links to
let penultimate = links[links.length - 2];
console.log("The penultimate link goes to: " + penultimate.href);
console.log("The penultimate link goes to: " + penultimate.getAttribute("href"));

// 3. Number of links linking to the institute's website
let iesbelen = (links) => {
    links.filter(l => l.href("https://iesbelen.org/")); // He intentado poner el .length aquí pero no he podido
}
console.log("Links to the institute's website: " + iesbelen.length);

// 4. Number of links in the third paragraph
const thirdP = elem.getElementsByTagName("p")[2];
let links3P = thirdP.getElementsByTagName("a").length;
console.log("There are " + links3P + " links in the third paragraph");