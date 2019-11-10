import { Injectable } from "@angular/core";
import { HttpEvent, HttpHandler, HttpInterceptor, HttpRequest } from "@angular/common/http";
import { Observable, throwError } from "rxjs";
import { SpinnerService } from "./spinner.service";
import { catchError, finalize } from "rxjs/operators";

@Injectable()
export class SpinnerInterceptor implements HttpInterceptor {
  public activeRequests = 0;

  constructor(private spinnerService: SpinnerService) {}

  public intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    if (this.activeRequests === 0 && request.responseType !== "text") {
      this.spinnerService.startLoading();
    }

    this.activeRequests++;
    return next.handle(request).pipe(
      finalize(() => {
        this.activeRequests--;
        if (this.activeRequests === 0) {
          this.spinnerService.stopLoading();
        }
      }),
      catchError(err => {
        this.spinnerService.stopLoading();
        return throwError(err);
      })
    );
  }
}
