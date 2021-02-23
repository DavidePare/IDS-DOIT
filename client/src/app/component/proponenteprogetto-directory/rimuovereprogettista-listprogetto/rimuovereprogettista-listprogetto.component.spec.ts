import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RimuovereprogettistaListprogettoComponent } from './rimuovereprogettista-listprogetto.component';

describe('RimuovereprogettistaListprogettoComponent', () => {
  let component: RimuovereprogettistaListprogettoComponent;
  let fixture: ComponentFixture<RimuovereprogettistaListprogettoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RimuovereprogettistaListprogettoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RimuovereprogettistaListprogettoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
