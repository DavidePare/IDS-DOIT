import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, ParamMap, Router } from '@angular/router';
import { ProgettoService } from 'src/app/service/progetto.service';

@Component({
  selector: 'app-investeprogetto',
  templateUrl: './investeprogetto.component.html',
  styleUrls: ['./investeprogetto.component.sass']
})
export class InvesteprogettoComponent implements OnInit {

  investeForm: FormGroup;
  sponsor: any;
  progettoId: any;
  response: any;
  errorMsg: any = '';
  investimento: number = 0;

  get invReq() {
    return this.investeForm.get('investe');
  }
  
  constructor(private router:Router, private route: ActivatedRoute,
         private progettoService: ProgettoService,private fb: FormBuilder) { }

  ngOnInit(): void {
    this.sponsor = JSON.parse(localStorage.getItem("doitauth"));
    if(this.sponsor == null){
      this.router.navigateByUrl('login');
    }
    if(this.sponsor != null){
      if(this.sponsor[2] != 1){
        this.router.navigateByUrl('login');
      }
    }

    this.route.paramMap.subscribe((params: ParamMap) =>{
      let id = parseInt(params.get('id'));
      this.progettoId = id;
    })

    this.investeForm = this.fb.group({
      investe: ['',[Validators.required]]
    });

    this.progettoService.amountProgetto(this.progettoId,this.sponsor[1],this.sponsor[0])
          .subscribe(data => this.investimento = data,
                    error => this.errorMsg = error);
  }

  incrementa(){
    this.progettoService.incrementAmount(this.progettoId,this.sponsor[1],this.investeForm.controls['investe'].value,this.sponsor[0])
          .subscribe(data => {
                            this.response = data;
                            this.router.navigateByUrl('sponsor');
                            },
                  error => {
                            this.errorMsg = error;
                            this.router.navigateByUrl('sponsor');
                          }
        );
  }

  decrementa(){
    this.progettoService.decrementAmount(this.progettoId,this.sponsor[1],this.investeForm.controls['investe'].value,this.sponsor[0])
          .subscribe(data => {
                            this.response = data;
                            this.router.navigateByUrl('sponsor');
                            },
                  error => {
                            this.errorMsg = error;
                            this.router.navigateByUrl('sponsor');
                          }
        );
  }
}
