This project is going to be a sort of encyclopedia of superheroes and the different teams they belong to.<br>
There will be data of the most famous ones but it's also a creative way to invent new ones and make them "interact" with your favourites.<br>
Have fun and hope you learn something about them!<br>

<br>This is the project structure:<br>
proyecto-team-heroes/<br>
── src/<br>
│ ├── team/<br>
│ │ ├── Team.js # Clase Group<br>
│ │ ├── teamController.js # Controlador para gestionar CRUD de teams<br>
│ │ ├── teamsList.html # Página HTML para listar teams<br>
│ │ ├── createTeam.html # Página HTML para crear un nuevo team<br>
│ │ ├── editTeam.html # Página HTML para editar un team<br>
│ │ └── team.css # CSS específico para las páginas de team<br>
│ │<br>
│ ├── hero/<br>
│ │ ├── Hero.js # Clase Hero<br>
│ │ ├── heroController.js # Controlador para gestionar CRUD de heroes<br>
│ │ ├── heroesList.html # Página HTML para listar heroes<br>
│ │ ├── createHero.html # Página HTML para crear un nuevo hero<br>
│ │ ├── editHero.html # Página HTML para editar un hero<br>
│ │ └── hero.css # CSS específico para las páginas de hero<br>
│<br>
├── index.html # Página de inicio con enlaces a los CRUDs<br>
├── main.js # JavaScript principal para la lógica de la interfaz<br>
├── css/<br>
│ └── main.css # CSS global para todo el proyecto<br>
├── assets/<br>
│ ├── teams.json # Archivo JSON para almacenar datos de teams<br>
│ └── heroes.json # Archivo JSON para almacenar datos de heroes<br>
│<br>
├── package.json # Información y dependencias del proyecto<br>
└── README.md # Documentación del proyecto<br>