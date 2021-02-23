import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthSLService {

  urlSigIn = 'http://localhost:8080/signin2';
  urlLogIn = 'http://localhost:8080/login2';

  constructor(private http: HttpClient) { }

  register(userData) {
    return this.http.post<any>(this.urlSigIn, userData);
  }

  login(userData) {
    return this.http.post<any>(this.urlLogIn, userData);
  }
}