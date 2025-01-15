import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { AppNavbar } from './navbar/navbar.component';
import { Ex01Component } from "./ex01/ex01.component";

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, AppNavbar, Ex01Component],
  templateUrl: './app.component.html',
})
export class AppComponent {
  title = 'basicExercises';
}
