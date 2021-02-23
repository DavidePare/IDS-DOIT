import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ProgettoService } from 'src/app/service/progetto.service';

@Component({
  selector: 'app-totalprogetti',
  templateUrl: './totalprogetti.component.html',
  styleUrls: ['./totalprogetti.component.sass']
})
export class TotalprogettiComponent implements OnInit {

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
    this.progettoService.getProgettiApproved()
    .subscribe(data => this.progetti = data,
                error => this.errorMsg = error);
  }

  onSelect(progetto){
    this.router.navigate([progetto.id],{relativeTo: this.route});
  }

  isSelected(progetto){ 
    return progetto.id === this.selectedId;
  }

}
