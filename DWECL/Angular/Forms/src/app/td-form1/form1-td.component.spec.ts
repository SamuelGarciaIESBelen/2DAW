import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Form1TDComponent } from './form1-td.component';

describe('Form1TDComponent', () => {
  let component: Form1TDComponent;
  let fixture: ComponentFixture<Form1TDComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Form1TDComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(Form1TDComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
