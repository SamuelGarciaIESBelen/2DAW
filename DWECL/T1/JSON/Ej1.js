let libros = [
    {
        "titulo": "Hijos de la mente",
        "genero": [
            "Ciencia ficción"
        ],
        "autor": [
            "Orson Scott Card"
        ],
        "pag": 370,
        "fecha": "1996-08-01",
        "leido": true,
        "web": ""
    },
    {
        "titulo": "El nombre del viento",
        "genero": [
            "Fantasía",
            "Aventura"
        ],
        "autor": [
            "Patrick Rothfuss"
        ],
        "pag": 662,
        "fecha": "2007-03-27",
        "leido": true,
        "web": "www.patrickrothfuss.com"
    },
    {
        "titulo": "Tokyo Blues",
        "genero": [
            "Ficción",
            "Romance"
        ],
        "autor": [
            "Haruki Murakami"
        ],
        "pag": 384,
        "fecha": "1987-09-04",
        "leido": false,
        "web": ""
    },
    {
        "titulo": "Alas de sangre",
        "genero": ["Fantasía", "Romance"],
        "autor": ["Rebecca Yarros"],
        "pag": 736,
        "fecha": "2023-11-15",
        "leido": false,
        "web": ""
    },
    {
        "titulo": "Evangelion tomo 1",
        "genero": [
            "Manga",
            "Ciencia ficción"
        ],
        "autor": [
            "Yoshiyuki Sadamoto"
        ],
        "pag": 192,
        "fecha": "1995-12-01",
        "leido": true,
        "web": ""
    },
    {
        "titulo": "Dungeons and Dragons 5e",
        "genero": [
            "Fantasía",
            "Juegos de rol"
        ],
        "autor": [
            "Patrick Rothfuss", "Wizards of the Coast"
        ],
        "pag": 320,
        "fecha": "2014-08-19",
        "leido": true,
        "web": "dnd.wizards.com/"
    }
];

   // 1. Name of each of the genres.
let generos = [];
libros.map(e=>e.genero).forEach(e=>{
    for (let gen of e){
    if (!generos.includes(gen))
        generos.push(gen);
    }});

    console.log(generos);
    console.log("\n");
   // 2. Title of books with more than 300 pages
   libros.filter(e=>e.pag>300).forEach(e=>console.log(e.titulo, e.pag));
   console.log("\n");


   // 3. Title of books published more than 2 years ago
   libros.filter(e=>e.fecha<"2022").forEach(e=>console.log(e.titulo, e.fecha));
   console.log("\n");


   // 4. Name of the authors and number of books they have written.
    let autorNum = {};

    libros.forEach(e => {
        e.autor.forEach(a => {
            if (autorNum[a]){
                autorNum[a]++;
            } else {
                autorNum[a]=1;
            }
        });
    });
    console.log(autorNum);
    console.log("\n");


   // 5. Title of the books read, ordered by date of publishing.
   //Se usa el new Date, porque si no son cadenas de Texto, y no se pueden restar, entonces tenemos que darles un formato que sort pueda operar
    libros.filter(e=> e.leido).sort((a,b)=>new Date(a.fecha) - new Date(b.fecha)).forEach(e=> console.log(e.titulo, e.leido, e.fecha));