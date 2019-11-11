import { TestBed } from "@angular/core/testing";

import { SnackbarService } from "./snackbar.service";
import { SnackBarType } from "../../components/snackbar/enum/snack-bar-type.enum";
import { MatSnackBarModule } from "@angular/material/snack-bar";

describe("SnackbarService", () => {
  beforeEach(() =>
    TestBed.configureTestingModule({
      imports: [MatSnackBarModule]
    })
  );

  it("should be created", () => {
    const service: SnackbarService = TestBed.get(SnackbarService);
    expect(service).toBeTruthy();
  });

  it("should create an success message", () => {
    const service: SnackbarService = TestBed.get(SnackbarService);
    const spy = spyOn(service, "showSnackBar");
    service.showSuccess("success");
    expect(spy).toHaveBeenCalledWith({ type: SnackBarType.SUCCESS, text: "success" });
  });

  it("should create an error message", () => {
    const service: SnackbarService = TestBed.get(SnackbarService);
    const spy = spyOn(service, "showSnackBar");
    service.showError("error");
    expect(spy).toHaveBeenCalledWith({ type: SnackBarType.ERROR, text: "error" });
  });

  it("should create an info message", () => {
    const service: SnackbarService = TestBed.get(SnackbarService);
    const spy = spyOn(service, "showSnackBar");
    service.showInfo("info");
    expect(spy).toHaveBeenCalledWith({ type: SnackBarType.INFO, text: "info" });
  });

  it("should create an warning message", () => {
    const service: SnackbarService = TestBed.get(SnackbarService);
    const spy = spyOn(service, "showSnackBar");
    service.showWarning("warning");
    expect(spy).toHaveBeenCalledWith({ type: SnackBarType.WARNING, text: "warning" });
  });

  it("should open a snack bar", () => {
    const service: SnackbarService = TestBed.get(SnackbarService);
    const spy = spyOn(service.snackBar, "openFromComponent");
    service.showSnackBar({ type: SnackBarType.WARNING, text: "warning" });
    expect(spy).toHaveBeenCalled();
  });
});
