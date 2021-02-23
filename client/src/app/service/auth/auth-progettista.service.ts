import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthProgettistaService {

  authState: number = -1;
  authToken: number = -1;

  constructor() {
  }
}
