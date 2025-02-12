import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Form2TDComponent } from './form2-td.component';

describe('Form2TDComponent', () => {
  let component: Form2TDComponent;
  let fixture: ComponentFixture<Form2TDComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Form2TDComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(Form2TDComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
