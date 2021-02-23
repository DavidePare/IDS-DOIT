import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserprogettiDetailsComponent } from './userprogetti-details.component';

describe('UserprogettiDetailsComponent', () => {
  let component: UserprogettiDetailsComponent;
  let fixture: ComponentFixture<UserprogettiDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UserprogettiDetailsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UserprogettiDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
