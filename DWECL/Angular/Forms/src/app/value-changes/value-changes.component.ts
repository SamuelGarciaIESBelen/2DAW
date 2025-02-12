import { Component, OnInit } from '@angular/core';
import {FormGroup, FormControl, ReactiveFormsModule} from '@angular/forms';
import { startWith, pairwise, tap, map, filter, distinctUntilChanged, debounceTime } from 'rxjs/operators';
import { combineLatest } from 'rxjs';

@Component({
  selector: 'app-value-changes',
  standalone: true,
  imports: [
    ReactiveFormsModule
  ],
  templateUrl: './value-changes.component.html',
  styleUrl: './value-changes.component.css'
})

export class ValueChangesComponent implements OnInit {

  name = 'Angular';

  group = new FormGroup({
    val1: new FormControl('val1'),
    val2: new FormControl('val2'),
    val3: new FormControl('val3')
  });

  ngOnInit() {
    this.group.valueChanges.pipe(
      distinctUntilChanged((x, y) =>{
        return x.val1 === y.val1 && x.val2 === y.val2
      }),
      debounceTime(1000),
      tap(data => {
        console.log('1');
      })
    ).subscribe();

    const defaultValue = this.group.value;
    this.group.valueChanges.pipe(
      startWith(defaultValue),
      pairwise(),
      filter(([x, y]) => x.val1 !== y.val1 || x.val2 !== y.val2),
      map(([_, data]) => data),
      tap(data => {
        console.log('2');
      })
    ).subscribe()

    combineLatest(
      this.group.get('val1')!.valueChanges.pipe(startWith('val1')),
      this.group.get('val2')!.valueChanges.pipe(startWith('val2'))
/*      this.group.get('val1').valueChanges.pipe(startWith('val1')),
      this.group.get('val2').valueChanges.pipe(startWith('val2'))*/
    ).pipe(
      tap(data => {
        console.log('3')
      })
    ).subscribe();
  }
}
