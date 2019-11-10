import { Component, Inject, OnInit, ViewEncapsulation } from "@angular/core";
import { SnackBarType } from "./enum/snack-bar-type.enum";
import { MAT_SNACK_BAR_DATA } from "@angular/material/snack-bar";
import { SnackBar } from "./model/snack-bar.model";

@Component({
  selector: "ms-front-snackbar",
  templateUrl: "./snackbar.component.html",
  styleUrls: ["./snackbar.component.scss"],
  encapsulation: ViewEncapsulation.None
})
export class SnackbarComponent implements OnInit {
  public iconType: string;
  public textClass: string;
  public iconClass: string;
  public text: string;
  public type: string;
  public textMaxLength = 90;

  constructor(@Inject(MAT_SNACK_BAR_DATA) public snackBarData: SnackBar) {}

  public ngOnInit(): void {
    this.recoverToastAttributes();
    this.defineAttributesClassesAndIcons();
  }

  public recoverToastAttributes(): void {
    const dataText = this.snackBarData.text || "";
    this.text = dataText.length <= this.textMaxLength ? dataText : dataText.substring(0, this.textMaxLength) + "...";
    this.type = this.snackBarData.type;
  }

  public defineAttributesClassesAndIcons(): void {
    this.iconClass = "toast-icon";
    this.iconType = this.type;

    switch (this.type) {
      case SnackBarType.SUCCESS:
        this.textClass = "snackbar-text snackbar-text-success";
        break;
      case SnackBarType.ERROR:
        this.textClass = "snackbar-text snackbar-text-error";
        break;
      case SnackBarType.WARNING:
        this.textClass = "snackbar-text snackbar-text-warning";
        break;
      default:
        this.textClass = "snackbar-text snackbar-text-info";
        break;
    }
  }
}
