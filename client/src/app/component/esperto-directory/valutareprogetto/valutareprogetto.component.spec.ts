import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ValutareprogettoComponent } from './valutareprogetto.component';

describe('ValutareprogettoComponent', () => {
  let component: ValutareprogettoComponent;
  let fixture: ComponentFixture<ValutareprogettoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ValutareprogettoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ValutareprogettoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
