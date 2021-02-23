import { TestBed } from '@angular/core/testing';

import { AuthProponenteprogettoService } from './auth-proponenteprogetto.service';

describe('AuthProponenteprogettoService', () => {
  let service: AuthProponenteprogettoService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AuthProponenteprogettoService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
