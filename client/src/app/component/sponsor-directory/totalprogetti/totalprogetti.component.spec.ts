import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TotalprogettiComponent } from './totalprogetti.component';

describe('TotalprogettiComponent', () => {
  let component: TotalprogettiComponent;
  let fixture: ComponentFixture<TotalprogettiComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TotalprogettiComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TotalprogettiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
