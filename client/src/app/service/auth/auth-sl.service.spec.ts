import { TestBed } from '@angular/core/testing';

import { AuthSLService } from './auth-sl.service';

describe('AuthSLService', () => {
  let service: AuthSLService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AuthSLService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
