import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, ParamMap, Router } from '@angular/router';
import { ProgettoService } from 'src/app/service/progetto.service';

@Component({
  selector: 'app-proponenteprogetto-pgestiti',
  templateUrl: './proponenteprogetto-pgestiti.component.html',
  styleUrls: ['./proponenteprogetto-pgestiti.component.sass']
})
export class ProponenteprogettoPgestitiComponent implements OnInit {

  pp: any;
  data: any;
  public progetti = [];
  public errorMsg;

  constructor(private progettoService: ProgettoService, private router: Router,
              private route: ActivatedRoute) { }

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
    this.progettoService.getProgettiGestitiPP(this.pp[1],this.pp[0])
    .subscribe(data => this.progetti = data,
                error => this.errorMsg = error);
  }

}
