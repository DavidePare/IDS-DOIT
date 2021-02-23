import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, ParamMap, Router } from '@angular/router';
import { ProgettistaService } from 'src/app/service/progettista.service';

@Component({
  selector: 'app-invitaprogettista-invita',
  templateUrl: './invitaprogettista-invita.component.html',
  styleUrls: ['./invitaprogettista-invita.component.sass']
})
export class InvitaprogettistaInvitaComponent implements OnInit {

  pp: any;
  public progettistaId;
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
        let idp = parseInt(params.get('idp'));
        this.progettoId = id;
        this.progettistaId = idp;
    })
  }

  invite(){
    this.progettistaService.addInvite(this.progettoId,this.progettistaId,this.pp[1],this.pp[0])
          .subscribe(data => this.response = data,
                      error => this.errorMsg = error
                      );
  }

  gotoBack(){ 
    let selectedId = this.progettistaId ? this.progettistaId : null;
    this.router.navigate(['../', {id: selectedId}], {relativeTo: this.route});
  }

}
