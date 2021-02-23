import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SigninprogettistaComponent } from './signinprogettista.component';

describe('SigninprogettistaComponent', () => {
  let component: SigninprogettistaComponent;
  let fixture: ComponentFixture<SigninprogettistaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SigninprogettistaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SigninprogettistaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
