import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProgettistacurriculumComponent } from './progettistacurriculum.component';

describe('ProgettistacurriculumComponent', () => {
  let component: ProgettistacurriculumComponent;
  let fixture: ComponentFixture<ProgettistacurriculumComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProgettistacurriculumComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ProgettistacurriculumComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
