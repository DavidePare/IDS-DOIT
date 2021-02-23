import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InvitaprogettistaListprogettiComponent } from './invitaprogettista-listprogetti.component';

describe('InvitaprogettistaListprogettiComponent', () => {
  let component: InvitaprogettistaListprogettiComponent;
  let fixture: ComponentFixture<InvitaprogettistaListprogettiComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InvitaprogettistaListprogettiComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(InvitaprogettistaListprogettiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
