import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreaprogettoComponent } from './creaprogetto.component';

describe('CreaprogettoComponent', () => {
  let component: CreaprogettoComponent;
  let fixture: ComponentFixture<CreaprogettoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CreaprogettoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CreaprogettoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
