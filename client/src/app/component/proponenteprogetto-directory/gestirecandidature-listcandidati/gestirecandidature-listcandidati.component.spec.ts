import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GestirecandidatureListcandidatiComponent } from './gestirecandidature-listcandidati.component';

describe('GestirecandidatureListcandidatiComponent', () => {
  let component: GestirecandidatureListcandidatiComponent;
  let fixture: ComponentFixture<GestirecandidatureListcandidatiComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GestirecandidatureListcandidatiComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(GestirecandidatureListcandidatiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
