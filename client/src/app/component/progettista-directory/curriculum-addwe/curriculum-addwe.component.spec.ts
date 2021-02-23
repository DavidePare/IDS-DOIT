import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CurriculumAddweComponent } from './curriculum-addwe.component';

describe('CurriculumAddweComponent', () => {
  let component: CurriculumAddweComponent;
  let fixture: ComponentFixture<CurriculumAddweComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CurriculumAddweComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CurriculumAddweComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
