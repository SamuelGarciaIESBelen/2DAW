import { Component } from '@angular/core';
import {FormControl, FormGroup, ReactiveFormsModule, Validators} from "@angular/forms";

@Component({
  selector: 'app-r-form1',
  standalone: true,
  imports: [
    ReactiveFormsModule
  ],
  templateUrl: './form1-r.component.html',
  styleUrl: './form1-r.component.css'
})
export class Form1RComponent {
  myForm1 = new FormGroup({
    "firstName": new FormControl("", Validators.required), // en HTML --> formControlName
    "password": new FormControl("", Validators.required), // en HTML --> formControlName
    "otro": new FormControl("thisss"), // sin control en HTML
  });

  onSubmitModelBased() {
    console.log("reactive form submitted");
    console.log(this.myForm1);
    console.log("DATOS-->",this.myForm1.value);
  }
}
