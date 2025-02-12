import {Component} from '@angular/core';
import {JsonPipe} from "@angular/common";
import {FormBuilder, FormGroup, ReactiveFormsModule, Validators} from "@angular/forms";
import {createPasswordStrengthValidator} from "../passwdstrval";

@Component({
  selector: 'app-r-form2',
  standalone: true,
  imports: [
    JsonPipe,
    ReactiveFormsModule
  ],
  templateUrl: './form2-r.component.html',
  styleUrl: './form2-r.component.css'
})

export class Form2RComponent {
  rForm: FormGroup;

  /*  rForm = this.fb.group({
      mobile: ['555', [Validators.required, Validators.pattern("^[0-9]*$")]],
      num: ['666', [Validators.required, Validators.pattern("^[0-9]*$"), Validators.min(6)]],
      passwd: ['', [Validators.required, Validators.minLength(6), createPasswordStrengthValidator()]],
    })*/

  constructor(private fb: FormBuilder ) {
    this.rForm = this.fb.group({
      mobile: ['555', [Validators.required, Validators.pattern("^[0-9]*$")]],
      num: ['666', [Validators.required, Validators.pattern("^[0-9]*$"), Validators.min(6)]],
      passwd: ['', [Validators.required, Validators.minLength(6), createPasswordStrengthValidator()]],
    });
  }

  ngOnInit() {
  }

  submit() {
    console.log("reactive form submitted");
    console.log(this.rForm);
    console.log(this.rForm.value);
  }
}
