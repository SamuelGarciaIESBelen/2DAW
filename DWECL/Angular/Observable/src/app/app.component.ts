import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { PrincipalComponent } from "./components/principal/principal.component";
import { ObservadorDosComponent } from "./components/observador-dos/observador-dos.component";
import { ObservadorUnoComponent } from "./components/observador-uno/observador-uno.component";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [PrincipalComponent,
    ObservadorDosComponent,
    ObservadorUnoComponent,
    RouterOutlet],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'AngObservable';
}
