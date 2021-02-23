import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { ActivatedRoute, ParamMap, Router } from '@angular/router';
import { Curriculum } from 'src/app/interface/curriculum';
import { Progettista } from 'src/app/interface/progettista';
import { ProgettistaService } from 'src/app/service/progettista.service';

@Component({
  selector: 'app-progettistacurriculum',
  templateUrl: './progettistacurriculum.component.html',
  styleUrls: ['./progettistacurriculum.component.sass']
})
export class ProgettistacurriculumComponent implements OnInit {

  public progettista: Progettista;
  public errorMsg;
  progettistaId: any;

  constructor(private progettistaService: ProgettistaService, private route: ActivatedRoute,private cdRef:ChangeDetectorRef, private router: Router) { }

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

  back(){
    this.router.navigateByUrl('user/getProgettisti/'+this.progettistaId);
  }

}
