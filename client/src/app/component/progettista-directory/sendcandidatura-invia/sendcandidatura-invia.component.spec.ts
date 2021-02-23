import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SendcandidaturaInviaComponent } from './sendcandidatura-invia.component';

describe('SendcandidaturaInviaComponent', () => {
  let component: SendcandidaturaInviaComponent;
  let fixture: ComponentFixture<SendcandidaturaInviaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SendcandidaturaInviaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SendcandidaturaInviaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
