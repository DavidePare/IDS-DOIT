import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthEspertoService {

  authState: number = -1;
  authToken: number = -1;

  constructor() {
    this.authState = 1;
   }
}
