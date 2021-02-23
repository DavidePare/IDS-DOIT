import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-proponenteprogetto',
  templateUrl: './proponenteprogetto.component.html',
  styleUrls: ['./proponenteprogetto.component.sass']
})
export class ProponenteprogettoComponent implements OnInit {

  pp: any;
  
  constructor(private router:Router) { }

  ngOnInit(): void {
    this.pp = JSON.parse(localStorage.getItem("doitauth"));
    if(this.pp == null){
      this.router.navigateByUrl('login');
    }
    if(this.pp != null){
      if(this.pp[2] != 3){
        this.router.navigateByUrl('login');
      }
    }
  }

}
