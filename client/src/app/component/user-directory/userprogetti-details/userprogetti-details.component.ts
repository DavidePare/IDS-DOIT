import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router, ParamMap } from '@angular/router';
import { Progetto } from 'src/app/interface/progetto';
import { ProgettoService } from 'src/app/service/progetto.service';

@Component({
  selector: 'app-userprogetti-details',
  templateUrl: './userprogetti-details.component.html',
  styleUrls: ['./userprogetti-details.component.sass']
})
export class UserprogettiDetailsComponent implements OnInit {

  public progettoId;
  public progetto: Progetto;
  public errorMsg;

  constructor(private progettoService: ProgettoService, private route: ActivatedRoute,private cdRef:ChangeDetectorRef, private router: Router) { }

  ngAfterViewChecked(){
    this.cdRef.detectChanges();
  }

  ngOnInit(): void {

    this.route.paramMap.subscribe((params: ParamMap) =>{
        let id = parseInt(params.get('id'));
        this.progettoId = id;
        
    })

    this.progettoService.getProgettoById(this.progettoId)
          .subscribe(data => {this.progetto = data;console.log(this.progetto)},
                      error => this.errorMsg = error);

  }

  gotoUserProgetti(){
    let selectedId = this.progettoId ? this.progettoId : null;
    this.router.navigate(['../', {id: selectedId}], {relativeTo: this.route});
  }

}
