import {Component, OnInit} from '@angular/core';
import { Pelicula} from "../pelicula";
import {PeliculaService} from "../pelicula.service";

@Component({
  selector: 'app-index',
  templateUrl: './index.component.html',
  styleUrls: ['./index.component.css']
})
export class IndexComponent implements OnInit {

  categorias: Pelicula[] = [];

  constructor(public categoriaService:PeliculaService) { }

  ngOnInit(): void {
    this.categoriaService.getAll().subscribe((data: Pelicula[])=>{
      this.categorias= data;
      console.log(this.categorias);
    })
  }

  deleteCategoria(id: any){
    this.categoriaService.delete(id).subscribe(res => {
      this.categorias = this.categorias.filter(cat => cat.id !== id);
      console.log('Pelicula id =' + id + ' eliminada satisfactoriamente!');
    })
  }


}

