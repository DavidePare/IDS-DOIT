import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, ParamMap, Router } from '@angular/router';
import { ProgettoService } from 'src/app/service/progetto.service';

@Component({
  selector: 'app-invitilist-decision',
  templateUrl: './invitilist-decision.component.html',
  styleUrls: ['./invitilist-decision.component.sass']
})
export class InvitilistDecisionComponent implements OnInit {

  progettista: any;
  public progettoId;
  public errorMsg;
  public response: any;

  constructor(private progettoService: ProgettoService, private route: ActivatedRoute,
      private router: Router) { }

  ngOnInit(): void {
    this.progettista = JSON.parse(localStorage.getItem("doitauth"));
    if(this.progettista[2] != 0){
      this.router.navigateByUrl('login');
    }
    if(this.progettista != null){
      if(this.progettista[2] != 0){
        this.router.navigateByUrl('login');
      }
    }
    this.route.paramMap.subscribe((params: ParamMap) =>{
        let id = parseInt(params.get('id'));
        this.progettoId = id;
    })
  }

  acceptInvite(){
    this.progettoService.putAcceptInvite(this.progettoId,this.progettista[1],this.progettista[0])
          .subscribe(data => this.response = data,
                      error => this.errorMsg = error
                      );
  }

  refuseInvite(){
    this.progettoService.putRefuseInvite(this.progettoId,this.progettista[1],this.progettista[0])
          .subscribe(data => this.response = data,
                      error => this.errorMsg = error
                      );
  }

  gotoBack(){ 
    let selectedId = this.progettoId ? this.progettoId : null;
    this.router.navigate(['../', {id: selectedId}], {relativeTo: this.route});
  }

}
