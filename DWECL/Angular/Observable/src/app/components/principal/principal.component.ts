import { Component } from '@angular/core';
import { CambiosService } from '../../services/cambios.service';

@Component({
  selector: 'app-principal',
  standalone: true,
  imports: [],
  templateUrl: './principal.component.html'
})
export class PrincipalComponent {
  veces = 0;
  constructor(private cambiosService: CambiosService){}

  cambiar(){
    this.veces++
    this.cambiosService.emitirElCambio(this.veces); 
  }
}
