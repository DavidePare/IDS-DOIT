import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-sponsor',
  templateUrl: './sponsor.component.html',
  styleUrls: ['./sponsor.component.sass']
})
export class SponsorComponent implements OnInit {

  sponsor: any;
  
  constructor(private router:Router) { }

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
  }

}
