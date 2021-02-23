import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProponenteprogettoComponent } from './proponenteprogetto.component';

describe('ProponenteprogettoComponent', () => {
  let component: ProponenteprogettoComponent;
  let fixture: ComponentFixture<ProponenteprogettoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProponenteprogettoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ProponenteprogettoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
