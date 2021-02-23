import { TestBed } from '@angular/core/testing';

import { AuthProgettistaService } from './auth-progettista.service';

describe('AuthProgettistaService', () => {
  let service: AuthProgettistaService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AuthProgettistaService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
