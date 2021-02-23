import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CurriculumAddlanguageComponent } from './curriculum-addlanguage.component';

describe('CurriculumAddlanguageComponent', () => {
  let component: CurriculumAddlanguageComponent;
  let fixture: ComponentFixture<CurriculumAddlanguageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CurriculumAddlanguageComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CurriculumAddlanguageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
