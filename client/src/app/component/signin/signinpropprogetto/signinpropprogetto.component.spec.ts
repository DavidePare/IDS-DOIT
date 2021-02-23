import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SigninpropprogettoComponent } from './signinpropprogetto.component';

describe('SigninpropprogettoComponent', () => {
  let component: SigninpropprogettoComponent;
  let fixture: ComponentFixture<SigninpropprogettoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SigninpropprogettoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SigninpropprogettoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
