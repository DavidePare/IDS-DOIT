import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProgettidavalutarelistComponent } from './progettidavalutarelist.component';

describe('ProgettidavalutarelistComponent', () => {
  let component: ProgettidavalutarelistComponent;
  let fixture: ComponentFixture<ProgettidavalutarelistComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProgettidavalutarelistComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ProgettidavalutarelistComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
