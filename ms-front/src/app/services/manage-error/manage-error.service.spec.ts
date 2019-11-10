import { TestBed } from "@angular/core/testing";

import { ManageErrorService } from "./manage-error.service";
import { HttpClientModule } from "@angular/common/http";
import { MatSnackBarModule } from "@angular/material/snack-bar";

describe("ManageErrorService", () => {
  beforeEach(() =>
    TestBed.configureTestingModule({
      imports: [HttpClientModule, MatSnackBarModule]
    })
  );

  it("should be created", () => {
    const service: ManageErrorService = TestBed.get(ManageErrorService);
    expect(service).toBeTruthy();
  });
});
