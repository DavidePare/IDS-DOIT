import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RemovecandidaturaListprogettiComponent } from './removecandidatura-listprogetti.component';

describe('RemovecandidaturaListprogettiComponent', () => {
  let component: RemovecandidaturaListprogettiComponent;
  let fixture: ComponentFixture<RemovecandidaturaListprogettiComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RemovecandidaturaListprogettiComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RemovecandidaturaListprogettiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
