import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProponenteprogettoPgestitiComponent } from './proponenteprogetto-pgestiti.component';

describe('ProponenteprogettoPgestitiComponent', () => {
  let component: ProponenteprogettoPgestitiComponent;
  let fixture: ComponentFixture<ProponenteprogettoPgestitiComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProponenteprogettoPgestitiComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ProponenteprogettoPgestitiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
