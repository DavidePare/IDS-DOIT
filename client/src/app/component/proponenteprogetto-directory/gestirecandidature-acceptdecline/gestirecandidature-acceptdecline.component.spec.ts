import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GestirecandidatureAcceptdeclineComponent } from './gestirecandidature-acceptdecline.component';

describe('GestirecandidatureAcceptdeclineComponent', () => {
  let component: GestirecandidatureAcceptdeclineComponent;
  let fixture: ComponentFixture<GestirecandidatureAcceptdeclineComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GestirecandidatureAcceptdeclineComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(GestirecandidatureAcceptdeclineComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
