import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, ParamMap, Router } from '@angular/router';
import { ProgettistaService } from 'src/app/service/progettista.service';

@Component({
  selector: 'app-gestirecandidature-acceptdecline',
  templateUrl: './gestirecandidature-acceptdecline.component.html',
  styleUrls: ['./gestirecandidature-acceptdecline.component.sass']
})
export class GestirecandidatureAcceptdeclineComponent implements OnInit {

  pp: any;
  public candidatoId;
  public progettoId;
  public errorMsg;
  public response: any;

  constructor(private progettistaService: ProgettistaService, private route: ActivatedRoute, 
          private router: Router) { }

  ngOnInit(): void {
    this.pp = JSON.parse(localStorage.getItem("doitauth"));
    if(this.pp[2] != 3){
      this.router.navigateByUrl('login');
    }
    if(this.pp != null){
      if(this.pp[2] != 3){
        this.router.navigateByUrl('login');
      }
    }
    this.route.paramMap.subscribe((params: ParamMap) =>{
        let id = parseInt(params.get('id'));
        let idc = parseInt(params.get('idc'));
        this.progettoId = id;
        this.candidatoId = idc;
    })
  }

  accept(){
    this.progettistaService.acceptCandidato(this.progettoId,this.pp[1],this.candidatoId,this.pp[0])
          .subscribe(data => this.response = data,
                      error => this.errorMsg = error
                      );
  }

  decline(){
    this.progettistaService.declineCandidato(this.progettoId,this.pp[1],this.candidatoId,this.pp[0])
          .subscribe(data => this.response = data,
                      error => this.errorMsg = error
                      );
  }

  gotoBack(){ 
    let selectedId = this.candidatoId ? this.candidatoId : null;
    this.router.navigate(['../', {id: selectedId}], {relativeTo: this.route});
  }

}
