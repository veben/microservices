import { Injectable } from "@angular/core";
import { MatSnackBar } from "@angular/material/snack-bar";
import { SnackBarType } from "../../components/snackbar/enum/snack-bar-type.enum";
import { SnackBar } from "../../components/snackbar/model/snack-bar.model";
import { SnackbarComponent } from "../../components/snackbar/snackbar.component";

@Injectable({
  providedIn: "root"
})
export class SnackbarService {
  public duration = 8000;

  constructor(public snackBar: MatSnackBar) {}

  public showSuccess(message: string): void {
    this.showSnackBar({
      type: SnackBarType.SUCCESS,
      text: message
    });
  }

  public showError(message: string): void {
    this.showSnackBar({
      type: SnackBarType.ERROR,
      text: message
    });
  }

  public showWarning(message: string): void {
    this.showSnackBar({
      type: SnackBarType.WARNING,
      text: message
    });
  }

  public showInfo(message: string): void {
    this.showSnackBar({
      type: SnackBarType.INFO,
      text: message
    });
  }

  public showSnackBar(toastData: SnackBar): void {
    this.snackBar.openFromComponent(SnackbarComponent, {
      duration: this.duration,
      panelClass: ["snackbar", toastData.type],
      data: toastData
    });
  }
}
