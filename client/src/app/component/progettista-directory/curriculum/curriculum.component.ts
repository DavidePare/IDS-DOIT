import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Curriculum } from 'src/app/interface/curriculum';
import { ProgettistaService } from 'src/app/service/progettista.service';

@Component({
  selector: 'app-curriculum',
  templateUrl: './curriculum.component.html',
  styleUrls: ['./curriculum.component.sass']
})
export class CurriculumComponent implements OnInit {

  progettista: any;
  public curriculum: Curriculum;
  public errorMsg;

  constructor(private progettistaService: ProgettistaService, private route: ActivatedRoute,private cdRef:ChangeDetectorRef, private router: Router) { }

  ngAfterViewChecked(){
    this.cdRef.detectChanges();
  }

  ngOnInit(): void {
    this.progettista = JSON.parse(localStorage.getItem("doitauth"));
    if(this.progettista == null){
      this.router.navigateByUrl('login');
    }
    if(this.progettista != null){
      if(this.progettista[2] != 0){
        this.router.navigateByUrl('login');
      }
    }
    this.progettistaService.getCurriculum(this.progettista[1],this.progettista[0])
          .subscribe(data => this.curriculum = data,
                      error => this.errorMsg = error);

  }
}
