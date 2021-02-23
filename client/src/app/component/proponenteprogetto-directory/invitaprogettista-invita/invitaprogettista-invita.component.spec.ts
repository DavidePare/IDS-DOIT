import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InvitaprogettistaInvitaComponent } from './invitaprogettista-invita.component';

describe('InvitaprogettistaInvitaComponent', () => {
  let component: InvitaprogettistaInvitaComponent;
  let fixture: ComponentFixture<InvitaprogettistaInvitaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InvitaprogettistaInvitaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(InvitaprogettistaInvitaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
