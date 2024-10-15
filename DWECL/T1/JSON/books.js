let libros = [
    {
        "titulo": "Percy Jackson and the Lightning Thief",
        "genero": ["Fantasía", "Aventuras"],
        "autor": ["Rick Riordan"],
        "pags": 377,
        "fecha": "2005-07-01",
        "leido": true,
        "web": ""
    },
    {
        "titulo": "The Name of the Wind",
        "genero": ["Fantasía", "Aventura"],
        "autor": ["Patrick Rothfuss"],
        "pags": 662,
        "fecha": "2007-03-27",
        "leido": false,
        "web": "www.patrickrothfuss.com"
    },
    {
        "titulo": "One Piece",
        "genero": ["Manga", "Fantasía"],
        "autor": ["Eiichiro Oda"],
        "pags": 0,
        "fecha": "1997-07-22",
        "leido": true,
        "web": ""
    },
    {
        "titulo": "Fourth Wing",
        "genero": ["Fantasía", "Romance"],
        "autor": ["Rebecca Yarros"],
        "pags": 736,
        "fecha": "2023-08-05",
        "leido": true,
        "web": ""
    },
    {
        "titulo": "Shadow and Bone",
        "genero": ["Fantasía", "Romance"],
        "autor": ["Leigh Bardugo"],
        "pags": 358,
        "fecha": "2012-05-03",
        "leido": true,
        "web": ""
    },
    {
        "titulo": "Dungeons and Dragons",
        "genero": ["Fantasía", "Rol"],
        "autor": ["Patrick Rothfuss", "Wizards of the Coast"],
        "pags": 320,
        "fecha": "2014-08-19",
        "leido": false,
        "web": "dnd.wizards.com/"
    }
];

//1
function p1(libros) {
    let generos = [];
    libros.map(e => e.genero).forEach(e => {
        for (let gen of e) {
            if (!generos.includes(gen))
                generos.push(gen);
        }
    });

    document.querySelector("#uno").innerHTML = `<p>Genres are: ${generos}</p>`
};
//2
let p2 = (libros) => {
    document.querySelector("#dos").innerHTML = "<p>"
    libros.filter(e => e.pags > 300).forEach(e => document.querySelector("#dos").innerHTML += `${e.titulo} (${e.pags} pages) <br><br>`);
    document.querySelector("#dos").innerHTML += "</p>";
}

//3
let p3 = (libros) => {
    libros.filter(e => e.fecha < "2022").forEach(e => document.querySelector("#tres").innerHTML += "<p>" + e.titulo + " - Date: " + e.fecha + "</p>");
}

//4
let p4 = (libros) => {
    let autorNum = {};

    libros.forEach(e => {
        e.autor.forEach(a => {
            if (autorNum[a]) {
                autorNum[a]++;
            } else {
                autorNum[a] = 1;
            }
        });
    });
    for (autor in autorNum) {
        document.querySelector('#cuatro').innerHTML += '<p>' + autor + '</p>';
    }
}

//5
let p5 = (libros) => {
    libros.filter(e => e.leido)
        .sort((a, b) => new Date(a.fecha) - new Date(b.fecha))
        .forEach(e => document.querySelector('#cinco').innerHTML += '<p>' + e.titulo + ' - Read? ' + e.leido + ' - Date: ' + e.fecha + '</p>');
}

document.querySelector('#p1').onclick = () => p1(libros);
document.querySelector('#p2').onclick = () => p2(libros);
document.querySelector('#p3').onclick = () => p3(libros);
document.querySelector('#p4').onclick = () => p4(libros);
document.querySelector('#p5').onclick = () => p5(libros);