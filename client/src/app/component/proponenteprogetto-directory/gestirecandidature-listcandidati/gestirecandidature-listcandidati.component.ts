import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, ParamMap, Router } from '@angular/router';
import { ProgettistaService } from 'src/app/service/progettista.service';

@Component({
  selector: 'app-gestirecandidature-listcandidati',
  templateUrl: './gestirecandidature-listcandidati.component.html',
  styleUrls: ['./gestirecandidature-listcandidati.component.sass']
})
export class GestirecandidatureListcandidatiComponent implements OnInit {

  pp: any;
  data: any;
  public selectedId;
  public progettisti = [];
  public errorMsg;

  constructor(private progettistaService: ProgettistaService, private router: Router,
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
    this.route.paramMap.subscribe((params: ParamMap) =>{
      let id = parseInt(params.get('id'));
      this.selectedId = id;
    })

    this.progettistaService.getCandidatiProgettoPP(this.selectedId,this.pp[1],this.pp[0])
    .subscribe(data => this.progettisti = data,
                error => this.errorMsg = error);
  }

  onSelect(progettista){
    this.router.navigate([progettista.id],{relativeTo: this.route});
  }

  isSelected(progettista){ 
    return progettista.id === this.selectedId;
  }
}
