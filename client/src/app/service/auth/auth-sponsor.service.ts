import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthSponsorService {

  authState: number = -1;
  authToken: number = -1;

  constructor() { }
}
