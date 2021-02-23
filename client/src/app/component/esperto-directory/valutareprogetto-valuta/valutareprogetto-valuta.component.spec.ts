import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ValutareprogettoValutaComponent } from './valutareprogetto-valuta.component';

describe('ValutareprogettoValutaComponent', () => {
  let component: ValutareprogettoValutaComponent;
  let fixture: ComponentFixture<ValutareprogettoValutaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ValutareprogettoValutaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ValutareprogettoValutaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
