import { async, getTestBed, TestBed } from "@angular/core/testing";

import { SpinnerService } from "./spinner.service";
import { HttpClientTestingModule, HttpTestingController } from "@angular/common/http/testing";
import { MatDialogModule } from "@angular/material/dialog";

describe("SpinnerService", () => {
  let injector: TestBed;
  let service: SpinnerService;
  let httpMock: HttpTestingController;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule, MatDialogModule],
      providers: [SpinnerService]
    }).compileComponents();
  }));

  beforeEach(() => {
    injector = getTestBed();
    httpMock = injector.get(HttpTestingController);
    service = injector.get(SpinnerService);
  });

  afterEach(() => {
    httpMock.verify();
  });

  it("should be created", () => {
    expect(service).toBeTruthy();
  });

  it("should start loading", () => {
    expect(service.loading).toBeFalsy();
    service.startLoading();
    expect(service.loading).toBeTruthy();
  });

  it("should stop loading", () => {
    service.loading = true;
    service.stopLoading();
    expect(service.loading).toBeFalsy();
  });
});
