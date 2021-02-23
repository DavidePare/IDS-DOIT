import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InvitilistDecisionComponent } from './invitilist-decision.component';

describe('InvitilistDecisionComponent', () => {
  let component: InvitilistDecisionComponent;
  let fixture: ComponentFixture<InvitilistDecisionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InvitilistDecisionComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(InvitilistDecisionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
