import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GestirecandidatureListprogettiComponent } from './gestirecandidature-listprogetti.component';

describe('GestirecandidatureListprogettiComponent', () => {
  let component: GestirecandidatureListprogettiComponent;
  let fixture: ComponentFixture<GestirecandidatureListprogettiComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GestirecandidatureListprogettiComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(GestirecandidatureListprogettiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
