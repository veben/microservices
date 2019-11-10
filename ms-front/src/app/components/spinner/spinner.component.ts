import { AfterViewChecked, ChangeDetectorRef, Component, OnDestroy, OnInit, ViewEncapsulation } from "@angular/core";
import { SpinnerService } from "../../services/spinner/spinner.service";
import { Subscription } from "rxjs";

@Component({
  selector: "ms-front-spinner",
  templateUrl: "./spinner.component.html",
  styleUrls: ["./spinner.component.scss"],
  encapsulation: ViewEncapsulation.None
})
export class SpinnerComponent implements OnInit, OnDestroy, AfterViewChecked {
  public loading = false;
  public loadingSubscription: Subscription;

  constructor(private spinnerService: SpinnerService, private cdRef: ChangeDetectorRef) {}

  public ngOnInit(): void {
    this.loadingSubscription = this.getLoadingStatus();
  }

  public ngAfterViewChecked(): void {
    this.cdRef.detectChanges();
  }

  public getLoadingStatus(): Subscription {
    return this.spinnerService.loadingStatus.subscribe(value => {
      this.loading = value;
    });
  }

  public ngOnDestroy(): void {
    this.loadingSubscription.unsubscribe();
  }
}
