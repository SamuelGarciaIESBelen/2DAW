import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export class CambiosService {

  constructor() { }

  private objetoCambioSubject = new BehaviorSubject<any>(null);
  objetoCambioObservable$ = this.objetoCambioSubject.asObservable();

  emitirElCambio(value: any) {
    this.objetoCambioSubject.next(value);
  }
}
