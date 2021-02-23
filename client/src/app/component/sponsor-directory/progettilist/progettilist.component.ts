import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ProgettoService } from 'src/app/service/progetto.service';

@Component({
  selector: 'app-progettilist',
  templateUrl: './progettilist.component.html',
  styleUrls: ['./progettilist.component.sass']
})
export class ProgettilistComponent implements OnInit {

  sponsor: any;
  public selectedId;
  public progetti = [];
  public errorMsg;

  
  constructor(private progettoService: ProgettoService, private router: Router, private route: ActivatedRoute) { }

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
    this.progettoService.getProgettiSponsor(this.sponsor[1],this.sponsor[0])
    .subscribe(data => this.progetti = data,
                error => this.errorMsg = error);
  }

}
