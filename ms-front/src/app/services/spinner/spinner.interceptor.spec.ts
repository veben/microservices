import { async, TestBed, inject } from "@angular/core/testing";
import { HttpClientTestingModule, HttpTestingController } from "@angular/common/http/testing";

import { SpinnerInterceptor } from "./spinner.interceptor";
import { HTTP_INTERCEPTORS, HttpClient, HttpInterceptor } from "@angular/common/http";

function getInterceptorInstance<T extends HttpInterceptor>(interceptors: HttpInterceptor[], type: any): HttpInterceptor {
  let searchedInterceptor: HttpInterceptor = null;
  interceptors.forEach((interceptor: HttpInterceptor) => {
    if (interceptor instanceof type) {
      searchedInterceptor = interceptor;
    }
  });
  return searchedInterceptor;
}

describe("SpinnerInterceptor", () => {
  let interceptorInstance: HttpInterceptor;
  beforeEach(async(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [
        {
          provide: HTTP_INTERCEPTORS,
          useClass: SpinnerInterceptor,
          multi: true
        }
      ]
    }).compileComponents();
    interceptorInstance = getInterceptorInstance<SpinnerInterceptor>(TestBed.get(HTTP_INTERCEPTORS), SpinnerInterceptor);
  }));

  afterEach(inject([HttpTestingController], (mock: HttpTestingController) => {
    mock.verify();
  }));

  it("should test if interceptor instance defined", () => {
    expect(interceptorInstance).toBeDefined();
  });

  it("should test interceptor", inject([HttpClient, HttpTestingController], (http: HttpClient, mock: HttpTestingController) => {
    http.get("/api").subscribe(response => expect(response).toBeTruthy());
    const request = mock.expectOne("/api");

    request.flush({ data: "test" });
    mock.verify();
    http.get("/api").subscribe(response => expect(response).toBeTruthy());
    const request2 = mock.expectOne("/api");

    request2.flush({ data: "test" });
    mock.verify();
  }));
});
