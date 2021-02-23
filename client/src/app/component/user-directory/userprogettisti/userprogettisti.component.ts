import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, ParamMap, Router } from '@angular/router';
import { ProgettistaService } from 'src/app/service/progettista.service';

@Component({
  selector: 'app-userprogettisti',
  templateUrl: './userprogettisti.component.html',
  styleUrls: ['./userprogettisti.component.sass']
})
export class UserprogettistiComponent implements OnInit {

  data: any;
  public selectedId;
  public progettisti = [];
  public errorMsg;

  constructor(private progettistaService: ProgettistaService, private router: Router, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.progettistaService.getProgettistiUser()
    .subscribe(data => this.progettisti = data,
                error => this.errorMsg = error);

    this.route.paramMap.subscribe((params: ParamMap) =>{
      let id = parseInt(params.get('id'));
      this.selectedId = id;
    })
  }


  onSelect(progettista){
    //this.router.navigate(['/departments',department.id]);
    
    // con la seguente è come se dicessimo che qualunque fosse la route fino li, l'importante è che 
    // venga concatenato il 'department.id'
    this.router.navigate([progettista.id],{relativeTo: this.route});
  }

  // per fare l'effetto del selezionato visto che il metodo è un booleano e valorizza 'class.selected'
  isSelected(progettista){ 
    return progettista.id === this.selectedId;
  }
}
