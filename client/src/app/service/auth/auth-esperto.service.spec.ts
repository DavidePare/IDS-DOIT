import { TestBed } from '@angular/core/testing';

import { AuthEspertoService } from './auth-esperto.service';

describe('AuthEspertoService', () => {
  let service: AuthEspertoService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AuthEspertoService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
