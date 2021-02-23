import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProgettistaComponent } from './progettista.component';

describe('ProgettistaComponent', () => {
  let component: ProgettistaComponent;
  let fixture: ComponentFixture<ProgettistaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProgettistaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ProgettistaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
