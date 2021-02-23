import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserprogettistiDetailsComponent } from './userprogettisti-details.component';

describe('UserprogettistiDetailsComponent', () => {
  let component: UserprogettistiDetailsComponent;
  let fixture: ComponentFixture<UserprogettistiDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UserprogettistiDetailsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UserprogettistiDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
