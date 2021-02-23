import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Notifica } from 'src/app/interface/notifica';
import { ProgettistaService } from 'src/app/service/progettista.service';

@Component({
  selector: 'app-notifiche',
  templateUrl: './notifiche.component.html',
  styleUrls: ['./notifiche.component.sass']
})
export class NotificheComponent implements OnInit {

  progettista: any;
  data: any;
  public selectedId;
  public notifiche = [];
  public errorMsg;

  constructor(private progettoProgettista: ProgettistaService, private router: Router) { }

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
    this.progettoProgettista.getNotifiche(this.progettista[1],this.progettista[0])
    .subscribe(data => this.notifiche = data,
                error => this.errorMsg = error);
  }

}
