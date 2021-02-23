import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InvesteprogettoComponent } from './investeprogetto.component';

describe('InvesteprogettoComponent', () => {
  let component: InvesteprogettoComponent;
  let fixture: ComponentFixture<InvesteprogettoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InvesteprogettoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(InvesteprogettoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
