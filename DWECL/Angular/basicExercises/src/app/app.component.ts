import { Component } from '@angular/core';
import { RouterModule } from '@angular/router';
import { AppNavbar } from './navbar/navbar.component';
import { Ex01Component } from './ex01/ex01.component';
import { Ex02Component } from './ex02/ex02.component';
import { Ex03Component } from './ex03/ex03.component';
import { Ex04Component } from './ex04/ex04.component';
import { Ex05Component } from './ex05/ex05.component';
import { Ex06Component } from './ex06/ex06.component';
import { Ex07Component } from './ex07/ex07.component';
import { Ex08Component } from './ex08/ex08.component';
import { Ex10Component } from './ex10/ex10.component';

@Component({
  selector: 'app-root',
  imports: [RouterModule, AppNavbar, Ex01Component, Ex02Component, Ex03Component, Ex04Component, Ex05Component, Ex06Component, Ex07Component, Ex08Component, Ex10Component],
  templateUrl: './app.component.html',
})
export class AppComponent {
  title = 'basicExercises';
}
