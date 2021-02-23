import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserprogettiComponent } from './userprogetti.component';

describe('UserprogettiComponent', () => {
  let component: UserprogettiComponent;
  let fixture: ComponentFixture<UserprogettiComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UserprogettiComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UserprogettiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
