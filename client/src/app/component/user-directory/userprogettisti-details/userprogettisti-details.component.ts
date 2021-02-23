import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router, ParamMap } from '@angular/router';
import { Progettista } from 'src/app/interface/progettista';
import { ProgettistaService } from 'src/app/service/progettista.service';

@Component({
  selector: 'app-userprogettisti-details',
  templateUrl: './userprogettisti-details.component.html',
  styleUrls: ['./userprogettisti-details.component.sass']
})
export class UserprogettistiDetailsComponent implements OnInit {

  public progettistaId;
  path: string;
  public progettista: Progettista;
  public errorMsg;

  constructor(private progettistaService: ProgettistaService, private route: ActivatedRoute, private cdRef:ChangeDetectorRef, private router: Router) { }

  ngAfterViewChecked(){
    this.cdRef.detectChanges();
  }

  ngOnInit(): void {

    this.route.paramMap.subscribe((params: ParamMap) =>{
        let id = parseInt(params.get('id'));
        this.progettistaId = id;
    })

    this.progettistaService.getProgettistaById(this.progettistaId)
          .subscribe(data => {this.progettista = data;console.log(this.progettista)},
                      error => this.errorMsg = error);

  }

  onSelect(){
    this.path = "curriculum";
    this.router.navigate([this.path],{relativeTo: this.route});
  }

  gotoUserProgettisti(){ 
    let selectedId = this.progettistaId ? this.progettistaId : null;
    this.router.navigate(['../', {id: selectedId}], {relativeTo: this.route});
  }

}
