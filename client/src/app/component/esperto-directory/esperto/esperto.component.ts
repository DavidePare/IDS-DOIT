import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-esperto',
  templateUrl: './esperto.component.html',
  styleUrls: ['./esperto.component.sass']
})
export class EspertoComponent implements OnInit {

  esperto: any;
  
  constructor(private router:Router) { }

  ngOnInit(): void {
    this.esperto = JSON.parse(localStorage.getItem("doitauth"));
    if(this.esperto == null){
      this.router.navigateByUrl('login');
    }
    if(this.esperto != null){
      if(this.esperto[2] != 2){
      this.router.navigateByUrl('login');
      }
    }
    
  }

}
