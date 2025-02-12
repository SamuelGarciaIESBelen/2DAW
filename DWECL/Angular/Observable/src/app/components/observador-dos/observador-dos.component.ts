import { Component, OnInit } from '@angular/core';
import { CambiosService } from '../../services/cambios.service';

@Component({
  selector: 'app-observador-dos',
  standalone: true,
  imports: [],
  templateUrl: './observador-dos.component.html'
})

export class ObservadorDosComponent implements OnInit {
  vecesinformado=0;
  mensaje=""
  constructor(private cambiosService: CambiosService){}

  ngOnInit() {
   this.cambiosService.objetoCambioObservable$.subscribe(value => {
    this.mensaje= "se ha producido un cambio...";
    
    setTimeout(()=>{
      this.vecesinformado= value;
      this.mensaje= "";}
      ,3000
    )
  });
  }
}
