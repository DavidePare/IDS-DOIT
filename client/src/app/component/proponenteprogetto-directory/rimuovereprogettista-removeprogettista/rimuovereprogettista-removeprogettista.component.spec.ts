import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RimuovereprogettistaRemoveprogettistaComponent } from './rimuovereprogettista-removeprogettista.component';

describe('RimuovereprogettistaRemoveprogettistaComponent', () => {
  let component: RimuovereprogettistaRemoveprogettistaComponent;
  let fixture: ComponentFixture<RimuovereprogettistaRemoveprogettistaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RimuovereprogettistaRemoveprogettistaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RimuovereprogettistaRemoveprogettistaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
