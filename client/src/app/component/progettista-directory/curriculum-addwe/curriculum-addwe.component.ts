import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ProgettistaService } from 'src/app/service/progettista.service';

@Component({
  selector: 'app-curriculum-addwe',
  templateUrl: './curriculum-addwe.component.html',
  styleUrls: ['./curriculum-addwe.component.sass']
})
export class CurriculumAddweComponent implements OnInit {

  progettista: any;
  weForm: FormGroup;
  response: any;
  errorMsg: any;

  get langReq() {
    return this.weForm.get('we');
  }
  
  constructor(private router: Router,private fb: FormBuilder, private progettistaService: ProgettistaService) { }

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
    this.weForm = this.fb.group({
      we: ['',[Validators.required]]
    });
  }

  onSubmit(){
    this.progettistaService.addwe(this.progettista[1],this.progettista[0],this.weForm.controls['we'].value)
          .subscribe(data => {
                          this.response = data;
                          this.router.navigateByUrl('progettista/curriculum');
                          },
                      error => {
                        this.errorMsg = error;
                        this.router.navigateByUrl('progettista/curriculum');
                          }
                      );
  }

}
