import { Component } from '@angular/core';
import { NgClass } from '@angular/common';
import { NgIf } from '@angular/common';

@Component({
  selector: 'app-ex03',
  standalone: true,
  imports: [NgClass, NgIf],
  templateUrl: './ex03.component.html',
  styleUrl: './ex03.component.css'
})
export class Ex03Component {
  n: number = 0;

  constructor() { }

  ngOnInit(): void {
    this.n = Math.floor(Math.random() * 10 + 1);
  }

  // A veces no funciona bien
  getClassOf(n: number): string {
    let res;
    
    if (n < 5) {
      res = "text-danger";
    } else if (n >=5 && n < 9) {
      res = "text-success";
    } else {
      res = "text-primary";
    }
    return res;
  }
}
