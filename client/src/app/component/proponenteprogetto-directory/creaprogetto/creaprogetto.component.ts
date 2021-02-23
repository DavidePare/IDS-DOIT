import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ProgettoService } from 'src/app/service/progetto.service';

@Component({
  selector: 'app-creaprogetto',
  templateUrl: './creaprogetto.component.html',
  styleUrls: ['./creaprogetto.component.sass']
})
export class CreaprogettoComponent implements OnInit {

  pp: any;
  createProgettoForm: FormGroup;
  public errorMsg='';
  public response: any;

  get NameReq() {
    return this.createProgettoForm.get('name');
  }

  get nMaxPReq() {
    return this.createProgettoForm.get('nmaxprogettisti');
  }

  ngOnInit(){
    this.pp = JSON.parse(localStorage.getItem("doitauth"));
    if(this.pp == null){
      this.router.navigateByUrl('login');
    }
    if(this.pp != null){
      if(this.pp[2] != 3){
        this.router.navigateByUrl('login');
      }
    }
    this.createProgettoForm = this.fb.group({
      name: ['', [Validators.required]],
      nmaxprogettisti: ['', [Validators.required]]
    });
  }

  constructor(private fb: FormBuilder, private progettoservice: ProgettoService, private router:Router){ }

  onSubmit(){
    this.progettoservice.createProgetto(this.pp[1],this.createProgettoForm.controls['name'].value,this.createProgettoForm.controls['nmaxprogettisti'].value,this.pp[0])
          .subscribe(data =>{ this.response = data;
                          this.router.navigateByUrl('proponenteprogetto')},
                      error => this.errorMsg = error
                      );
  }
}
