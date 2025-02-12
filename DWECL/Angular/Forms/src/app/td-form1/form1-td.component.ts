import { Component } from '@angular/core';
import {FormsModule} from "@angular/forms";
import {JsonPipe} from "@angular/common";

@Component({
  selector: 'app-td-form1',
  standalone: true,
  imports: [
    FormsModule,
    JsonPipe
  ],
  templateUrl: './form1-td.component.html',
  styleUrl: './form1-td.component.css'
})
export class Form1TDComponent {
  user =  {
    firstName: 'user name here',
    password:  'test'
  };

  onSubmitTemplateProperties() {
    console.log(this.user);
  }
}
