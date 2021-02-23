import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddcurriculumComponent } from './addcurriculum.component';

describe('AddcurriculumComponent', () => {
  let component: AddcurriculumComponent;
  let fixture: ComponentFixture<AddcurriculumComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddcurriculumComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddcurriculumComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
