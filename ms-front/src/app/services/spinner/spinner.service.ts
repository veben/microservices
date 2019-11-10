import { Injectable } from "@angular/core";
import { Subject } from "rxjs";

@Injectable({
  providedIn: "root"
})
export class SpinnerService {
  public loadingStatus = new Subject<boolean>();
  private loadiiing = false;

  get loading(): boolean {
    return this.loadiiing;
  }

  set loading(value: boolean) {
    this.loadiiing = value;
    this.loadingStatus.next(value);
  }

  public startLoading(): void {
    this.loading = true;
  }

  public stopLoading(): void {
    this.loading = false;
  }
}
