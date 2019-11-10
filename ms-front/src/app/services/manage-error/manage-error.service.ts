import { Injectable } from "@angular/core";
import { HttpErrorResponse } from "@angular/common/http";
import { SnackbarService } from "../snackbar/snackbar.service";
import { MessageUtils } from "../../utils/message-utils";

@Injectable({
  providedIn: "root"
})
export class ManageErrorService {
  constructor(private snackbarService: SnackbarService) {}

  public serviceBackErrorDisplaying(err: HttpErrorResponse): void {
    const displayedMessage = err.status === 503 ? err.error : MessageUtils.MS_DEVELOPER_DOWN;

    this.snackbarService.showError(displayedMessage);
  }

  public serviceBackErrorLogging(err: HttpErrorResponse): void {
    console.log("Error:", err.message);
  }
}
