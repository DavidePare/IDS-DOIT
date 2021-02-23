import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InvitilistComponent } from './invitilist.component';

describe('InvitilistComponent', () => {
  let component: InvitilistComponent;
  let fixture: ComponentFixture<InvitilistComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InvitilistComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(InvitilistComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
