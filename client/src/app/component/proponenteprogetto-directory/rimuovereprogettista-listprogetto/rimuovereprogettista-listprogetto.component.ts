import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ProgettoService } from 'src/app/service/progetto.service';

@Component({
  selector: 'app-rimuovereprogettista-listprogetto',
  templateUrl: './rimuovereprogettista-listprogetto.component.html',
  styleUrls: ['./rimuovereprogettista-listprogetto.component.sass']
})
export class RimuovereprogettistaListprogettoComponent implements OnInit {

  pp: any;
  data: any;
  path: string;
  public selectedId;
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

  onSelect(progetto){
    this.path = progetto.id+'/getTeam';
    this.router.navigate([this.path],{relativeTo: this.route});
  }

  isSelected(progetto){ 
    return progetto.id === this.selectedId;
  }

}
