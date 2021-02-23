import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthEspertoService } from 'src/app/service/auth/auth-esperto.service';
import { AuthProgettistaService } from 'src/app/service/auth/auth-progettista.service';
import { AuthProponenteprogettoService } from 'src/app/service/auth/auth-proponenteprogetto.service';
import { AuthSLService } from 'src/app/service/auth/auth-sl.service';
import { AuthSponsorService } from 'src/app/service/auth/auth-sponsor.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.sass']
})
export class LoginComponent implements OnInit {

  authenticationForm: FormGroup;
  token: number;
  id:number;
  type:number;
  errorString:string = '';

  get emailReq() {
    return this.authenticationForm.get('email');
  }

  ngOnInit(){
    this.authenticationForm = this.fb.group({
      email: ['', [Validators.required, Validators.pattern("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$")]],
      password: ['', [Validators.required]],
      type: ['',[Validators.required]]
    });
  }

  constructor(private fb: FormBuilder, private authSL: AuthSLService, private authP: AuthProgettistaService, private router:Router,
              private authPP: AuthProponenteprogettoService, private authE: AuthEspertoService, private authS: AuthSponsorService){ }

  onSubmit(){
    this.authSL.login(this.authenticationForm.value)
          .subscribe(
            response =>{
              console.log('Success!', response);
              this.token = response[0];
              this.id = response[1];
              this.type = response[2];
              if(response[0] == 0 || response[0] == 1 || response[0] == 2 || response[0] == 3 ){
                  this.errorString = "Log In non andato a buon fine"
              }
              else{  
                localStorage.setItem("doitauth", JSON.stringify(response));
                if(this.type == 0){
                  this.router.navigateByUrl('progettista');
                }
                if(this.type == 1){
                  this.router.navigateByUrl('sponsor');
                }
                if(this.type == 2){
                  this.router.navigateByUrl('esperto');
                }
                if(this.type == 3){
                  this.router.navigateByUrl('proponenteprogetto');
                }
              }
            },
            error => console.log('Error!', error)
          )
    
  }

  logOut(){
    localStorage.removeItem("doitauth");
  }

}
