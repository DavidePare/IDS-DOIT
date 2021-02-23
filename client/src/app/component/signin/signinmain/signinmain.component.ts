import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';
import { AuthSLService } from 'src/app/service/auth/auth-sl.service';
import { PasswordValidator } from '../../login/password.validator';
import { Validators } from '@angular/forms';

@Component({
  selector: 'app-signinmain',
  templateUrl: './signinmain.component.html',
  styleUrls: ['./signinmain.component.sass']
})
export class SigninmainComponent implements OnInit {

  registrationForm: FormGroup;
  message: string = '';

  get nameReq() {
    return this.registrationForm.get('name');
  }

  get surnameReq() {
    return this.registrationForm.get('surname');
  }

  get emailReq() {
    return this.registrationForm.get('email');
  }

  get pwdReq() {
    return this.registrationForm.get('password');
  }

  ngOnInit(){
    this.registrationForm = this.fb.group({
      name: ['', [Validators.required]],
      surname: [''],
      email: ['',[Validators.required, Validators.pattern("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$")]],
      password: ['',[Validators.required]],
      confirmpassword: ['',[Validators.required]],
      type: ['',[Validators.required]],
    }, {validator: PasswordValidator});
  }

  constructor(private fb: FormBuilder, private authSL: AuthSLService){ }

  onSubmit(){
    console.log(this.registrationForm.value);
    this.authSL.register(this.registrationForm.value)
          .subscribe(
            response => {
              if(response[0]==1) this.message = "Azione eseguita con successo";
              else this.message = "Email già registrata";
              },
            error => console.log('Error!', error)
          )
  }
}

