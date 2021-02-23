import { TestBed } from '@angular/core/testing';

import { AuthSponsorService } from './auth-sponsor.service';

describe('AuthSponsorService', () => {
  let service: AuthSponsorService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AuthSponsorService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
