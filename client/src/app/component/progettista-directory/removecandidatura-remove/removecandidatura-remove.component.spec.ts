import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RemovecandidaturaRemoveComponent } from './removecandidatura-remove.component';

describe('RemovecandidaturaRemoveComponent', () => {
  let component: RemovecandidaturaRemoveComponent;
  let fixture: ComponentFixture<RemovecandidaturaRemoveComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RemovecandidaturaRemoveComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RemovecandidaturaRemoveComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
