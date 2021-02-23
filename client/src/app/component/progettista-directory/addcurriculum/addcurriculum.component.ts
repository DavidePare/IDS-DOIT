import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ProgettistaService } from 'src/app/service/progettista.service';

@Component({
  selector: 'app-addcurriculum',
  templateUrl: './addcurriculum.component.html',
  styleUrls: ['./addcurriculum.component.sass']
})
export class AddcurriculumComponent implements OnInit {

  progettista: any;
  response:any;
  errorMsg:any;

  curriculumForm: FormGroup;

  get istrReq() {
    return this.curriculumForm.get('istruzione');
  }

  get formReq() {
    return this.curriculumForm.get('formazione');
  }

  get lanReq() {
    return this.curriculumForm.get('language');
  }

  get phoneReq() {
    return this.curriculumForm.get('phone');
  }

  get emailReq() {
    return this.curriculumForm.get('email');
  }

  constructor(private fb: FormBuilder, private router: Router, private progettistaService: ProgettistaService) { }

  ngOnInit(): void {
    this.progettista = JSON.parse(localStorage.getItem("doitauth"));
    if(this.progettista == null){
      this.router.navigateByUrl('login');
    }
    if(this.progettista != null){
      if(this.progettista[2] != 0){
        this.router.navigateByUrl('login');
      }
    }
    this.curriculumForm = this.fb.group({
      istruzione: ['', [Validators.required]],
      formazione: ['', [Validators.required]],
      phone: ['', [Validators.required]],
      email: ['',[Validators.required, Validators.pattern("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$")]]
    });
  }

  onSubmit(){
    //console.log(this.curriculumForm.value);
    this.progettistaService.addCurriculum(this.progettista[1],this.progettista[0],
      this.curriculumForm.controls['phone'].value,this.curriculumForm.controls['istruzione'].value,
      this.curriculumForm.controls['formazione'].value,this.curriculumForm.controls['email'].value)
          .subscribe(data =>{ this.response = data;
                          this.router.navigateByUrl('progettista')},
                      error =>{
                        this.errorMsg = error
                        console.log(error);
                        this.router.navigateByUrl('progettista')
                      } 
                      );
  }

}
