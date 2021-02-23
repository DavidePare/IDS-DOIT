import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ProgettoService } from 'src/app/service/progetto.service';

@Component({
  selector: 'app-valutareprogetto',
  templateUrl: './valutareprogetto.component.html',
  styleUrls: ['./valutareprogetto.component.sass']
})
export class ValutareprogettoComponent implements OnInit {

  esperto: any;
  data: any;
  path: string;
  public selectedId;
  public progetti = [];
  public errorMsg;

  constructor(private progettoService: ProgettoService, private router: Router, 
    private route: ActivatedRoute) { }

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
    this.progettoService.getProgettiDaValutare(this.esperto[1],this.esperto[0])
    .subscribe(data => this.progetti = data,
                error => this.errorMsg = error);
  }

  onSelect(progetto){
    this.path = progetto.id;
    this.router.navigate([this.path],{relativeTo: this.route});
  }

  isSelected(progetto){ 
    return progetto.id === this.selectedId;
  }

}
