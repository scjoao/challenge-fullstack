import { TestBed } from '@angular/core/testing';

import { UploadXmlService } from './upload-xml.service';

describe('UploadXmlService', () => {
  let service: UploadXmlService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(UploadXmlService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
