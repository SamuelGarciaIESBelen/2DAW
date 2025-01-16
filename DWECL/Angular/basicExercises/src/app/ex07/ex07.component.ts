import { Component } from '@angular/core';
import {NgForOf} from "@angular/common";

@Component({
  selector: 'app-ex07',
  standalone: true,
  imports: [
    NgForOf
  ],
  templateUrl: './ex07.component.html'
})
export class Ex07Component {
  numbers: number[] = [];
  fruits: string[] = [];

  constructor() { }

  ngOnInit(): void {
    this.numbers = [1, 5, 8, 24, 32, 11, 55];
    this.fruits = ["pear", "apple", "mango", "watermelon", "kiwi"];
  }
  
  // Cómo le paso el value del select
  orderList(value: string) {
    if (value === "nasc")
      this.numbers.sort((a, b) => a - b);
    
    if (value === "ndesc")
      this.numbers.sort((a, b) => b - a);
    
    if (value === "fasc")
      this.fruits.sort();
    
    if (value === "fdesc")
      this.fruits.sort().reverse;
  }
}
