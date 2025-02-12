import { Component } from '@angular/core';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {JsonPipe} from "@angular/common";

@Component({
  selector: 'app-td-form2',
  standalone: true,
  imports: [
    FormsModule,
    ReactiveFormsModule,
    JsonPipe
  ],
  templateUrl: './form2-td.component.html',
  styleUrl: './form2-td.component.css'
})
export class Form2TDComponent {
  user =  {
    firstName: 'user name here',
    password:  'test'
  };
  otro:string ="";

  onSubmitTemplateFormData(formData:Object) {
    console.log(formData);
    alert("estos son los datos que se enviarán:" + JSON.stringify(formData))
  }
}
