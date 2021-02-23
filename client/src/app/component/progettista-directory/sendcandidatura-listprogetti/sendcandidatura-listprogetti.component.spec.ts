import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SendcandidaturaListprogettiComponent } from './sendcandidatura-listprogetti.component';

describe('SendcandidaturaListprogettiComponent', () => {
  let component: SendcandidaturaListprogettiComponent;
  let fixture: ComponentFixture<SendcandidaturaListprogettiComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SendcandidaturaListprogettiComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SendcandidaturaListprogettiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
