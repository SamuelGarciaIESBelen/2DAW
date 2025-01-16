import {Component} from '@angular/core';
import {FormsModule} from "@angular/forms";

@Component({
  selector: 'app-ex06',
  standalone: true,
  imports: [
    FormsModule
  ],
  templateUrl: './ex06.component.html',
 // styleUrl: './ex06.component.css'
})
export class Ex06Component {
  celsius: number | null = null;
  fahrenheit: number | null = null;

  constructor() {
  }

  ngOnInit(): void {
  }

  clear() {
    this.celsius = null;
    this.fahrenheit = null;
  }

  // /^\d+.?\d*$/ Expresión regular para el input

  convertToCelsius() {
    if (this.fahrenheit != null) {
      this.celsius = (this.fahrenheit - 32) * 5 / 9;
    }
  }

  converToFahrenheit() {
    if (this.celsius != null) {
      this.fahrenheit = this.celsius * 9 / 5 + 32;
    }
  }
}
