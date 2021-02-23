import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, ParamMap, Router } from '@angular/router';
import { ProgettoService } from 'src/app/service/progetto.service';

@Component({
  selector: 'app-valutareprogetto-valuta',
  templateUrl: './valutareprogetto-valuta.component.html',
  styleUrls: ['./valutareprogetto-valuta.component.sass']
})
export class ValutareprogettoValutaComponent implements OnInit {

  esperto: any;
  public progettoId;
  public errorMsg;
  public response: any;

  constructor(private progettoService: ProgettoService, private route: ActivatedRoute, 
          private router: Router) { }

  ngOnInit(): void {
    this.esperto = JSON.parse(localStorage.getItem("doitauth"));
    if(this.esperto[2] != 2){
      this.router.navigateByUrl('login');
    }
    if(this.esperto != null){
      if(this.esperto[2] != 2){
      this.router.navigateByUrl('login');
      }
    }
    this.route.paramMap.subscribe((params: ParamMap) =>{
        let id = parseInt(params.get('id'));
        this.progettoId = id;
    })
  }

  confirm(){
    this.progettoService.postProgettiDaValutareConfirm(this.progettoId,this.esperto[1],this.esperto[0])
          .subscribe(data => this.response = data,
                      error => this.errorMsg = error
                      );
  }

  decline(){
    this.progettoService.postProgettiDaValutareDecline(this.progettoId,this.esperto[1],this.esperto[0])
          .subscribe(data => this.response = data,
                      error => this.errorMsg = error
                      );
  }

  gotoBack(){ 
    let selectedId = this.progettoId ? this.progettoId : null;
    this.router.navigate(['../', {id: selectedId}], {relativeTo: this.route});
  }

}
