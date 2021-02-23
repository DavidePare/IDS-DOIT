import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProgettilistComponent } from './progettilist.component';

describe('ProgettilistComponent', () => {
  let component: ProgettilistComponent;
  let fixture: ComponentFixture<ProgettilistComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProgettilistComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ProgettilistComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
