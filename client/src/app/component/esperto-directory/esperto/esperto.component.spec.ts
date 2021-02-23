import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EspertoComponent } from './esperto.component';

describe('EspertoComponent', () => {
  let component: EspertoComponent;
  let fixture: ComponentFixture<EspertoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EspertoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EspertoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
