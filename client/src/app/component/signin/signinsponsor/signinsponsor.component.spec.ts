import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SigninsponsorComponent } from './signinsponsor.component';

describe('SigninsponsorComponent', () => {
  let component: SigninsponsorComponent;
  let fixture: ComponentFixture<SigninsponsorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SigninsponsorComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SigninsponsorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
