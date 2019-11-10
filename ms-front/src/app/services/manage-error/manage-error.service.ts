import { Injectable } from "@angular/core";
import { HttpErrorResponse } from "@angular/common/http";
import { SnackbarService } from "../snackbar/snackbar.service";

@Injectable({
  providedIn: "root"
})
export class ManageErrorService {
  constructor(private snackbarService: SnackbarService) {}

  public serviceBackErrorDisplaying(err: HttpErrorResponse, errorMessage: string): void {
    this.snackbarService.showError(errorMessage);
  }

  public serviceBackErrorLogging(err: HttpErrorResponse): void {
    console.log("Error:", err.message);
  }
}
