import { TestBed } from '@angular/core/testing';

import { ProgettistaService } from './progettista.service';

describe('ProgettistaService', () => {
  let service: ProgettistaService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ProgettistaService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
