import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-progettista',
  templateUrl: './progettista.component.html',
  styleUrls: ['./progettista.component.sass']
})
export class ProgettistaComponent implements OnInit {

  progettista: any;

  constructor(private router: Router) { }

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
  }

}
