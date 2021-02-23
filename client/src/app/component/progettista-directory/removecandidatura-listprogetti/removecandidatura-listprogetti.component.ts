import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, ParamMap, Router } from '@angular/router';
import { ProgettoService } from 'src/app/service/progetto.service';

@Component({
  selector: 'app-removecandidatura-listprogetti',
  templateUrl: './removecandidatura-listprogetti.component.html',
  styleUrls: ['./removecandidatura-listprogetti.component.sass']
})
export class RemovecandidaturaListprogettiComponent implements OnInit {

  progettista: any;
  data: any;
  path: any;
  public selectedId;
  public progetti = [];
  public errorMsg;

  constructor(private progettoService: ProgettoService, private router: Router,
        private route: ActivatedRoute) { }

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
    this.progettoService.getCandidature(this.progettista[1],this.progettista[0])
    .subscribe(data => this.progetti = data,
                error => this.errorMsg = error);
  }

  onSelect(progetto){
    this.path = progetto.id+'/rimuovi';
    this.router.navigate([this.path],{relativeTo: this.route});
  }

  isSelected(progetto){ 
    return progetto.id === this.selectedId;
  }

}
