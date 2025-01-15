import { Component } from '@angular/core';
import { RouterModule } from '@angular/router';
import { AppNavbar } from './navbar/navbar.component';
import { Ex01Component } from "./ex01/ex01.component";

@Component({
  selector: 'app-root',
  imports: [RouterModule, AppNavbar, Ex01Component],
  templateUrl: './app.component.html',
})
export class AppComponent {
  title = 'basicExercises';
}
