import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RimuovereprogettistaProgettistiteamComponent } from './rimuovereprogettista-progettistiteam.component';

describe('RimuovereprogettistaProgettistiteamComponent', () => {
  let component: RimuovereprogettistaProgettistiteamComponent;
  let fixture: ComponentFixture<RimuovereprogettistaProgettistiteamComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RimuovereprogettistaProgettistiteamComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RimuovereprogettistaProgettistiteamComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
