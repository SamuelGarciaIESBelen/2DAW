import { Component, OnInit } from '@angular/core';
import { CambiosService } from '../../services/cambios.service';

@Component({
  selector: 'app-observador-uno',
  imports: [],
  standalone: true,
  templateUrl: './observador-uno.component.html'
})

export class ObservadorUnoComponent implements OnInit{

  vecesinformado=0;
  constructor(private cambiosService: CambiosService){}

  ngOnInit() {
  this.cambiosService.objetoCambioObservable$.subscribe(value => {
   this.vecesinformado= value;
  });
}
}
