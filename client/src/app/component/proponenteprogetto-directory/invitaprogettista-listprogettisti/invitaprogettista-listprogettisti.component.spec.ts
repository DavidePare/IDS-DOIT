import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InvitaprogettistaListprogettistiComponent } from './invitaprogettista-listprogettisti.component';

describe('InvitaprogettistaListprogettistiComponent', () => {
  let component: InvitaprogettistaListprogettistiComponent;
  let fixture: ComponentFixture<InvitaprogettistaListprogettistiComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InvitaprogettistaListprogettistiComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(InvitaprogettistaListprogettistiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
