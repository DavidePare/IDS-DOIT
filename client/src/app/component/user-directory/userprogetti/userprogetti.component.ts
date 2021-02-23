import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, ParamMap, Router } from '@angular/router';
import { ProgettoService } from 'src/app/service/progetto.service';

@Component({
  selector: 'app-userprogetti',
  templateUrl: './userprogetti.component.html',
  styleUrls: ['./userprogetti.component.sass']
})
export class UserprogettiComponent implements OnInit {

  data: any;
  public selectedId;
  public progetti = [];
  public errorMsg;

  constructor(private progettoService: ProgettoService, private router: Router, private route: ActivatedRoute) { }

  ngOnInit(): void {

    this.progettoService.getProgettiUser()
    .subscribe(data => this.progetti = data,
                error => this.errorMsg = error);

    this.route.paramMap.subscribe((params: ParamMap) =>{
      let id = parseInt(params.get('id'));
      this.selectedId = id;
    })
  }

  onSelect(progetto){
    this.router.navigate([progetto.id],{relativeTo: this.route});
  }

  isSelected(progetto){ 
    return progetto.id === this.selectedId;
  }

}
