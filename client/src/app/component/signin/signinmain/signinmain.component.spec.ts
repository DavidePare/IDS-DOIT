import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SigninmainComponent } from './signinmain.component';

describe('SigninmainComponent', () => {
  let component: SigninmainComponent;
  let fixture: ComponentFixture<SigninmainComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SigninmainComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SigninmainComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
