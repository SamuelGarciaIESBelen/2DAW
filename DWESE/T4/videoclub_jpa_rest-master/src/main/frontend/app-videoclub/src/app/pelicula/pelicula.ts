import { Categoria } from "../categoria/categoria";
import {Idioma} from "../idioma/idioma";

export interface Pelicula {
  id: number;
  titulo: string;
  descripcion: string;
  anyoLanzamiento: string;
  idioma: Idioma;
  duracion: number;
  categorias: Categoria[];
}
