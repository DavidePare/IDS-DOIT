import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserprogettistiComponent } from './userprogettisti.component';

describe('UserprogettistiComponent', () => {
  let component: UserprogettistiComponent;
  let fixture: ComponentFixture<UserprogettistiComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UserprogettistiComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UserprogettistiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
