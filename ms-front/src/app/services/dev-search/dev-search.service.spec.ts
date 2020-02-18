import { inject, TestBed } from "@angular/core/testing";

import { DevSearchService } from "./dev-search.service";
import { HttpClient, HttpClientModule } from "@angular/common/http";
import { MatSnackBarModule } from "@angular/material/snack-bar";
import { of } from "rxjs";
import { DeveloperSearchDto } from "../../models/developer-search-dto.model";
import { RouterModule } from "@angular/router";
import { APP_BASE_HREF } from "@angular/common";

describe("DevSearchService", () => {
  beforeEach(() =>
    TestBed.configureTestingModule({
      imports: [HttpClientModule, MatSnackBarModule, RouterModule.forRoot([])],
      providers: [{ provide: APP_BASE_HREF, useValue: "/" }]
    })
  );

  it("should be created", () => {
    const service: DevSearchService = TestBed.inject(DevSearchService);
    expect(service).toBeTruthy();
  });

  it("should recover developer specialities", inject(
    [HttpClient, DevSearchService],
    (http: HttpClient, devSearchService: DevSearchService) => {
      // Given
      const spy = spyOn(http, "get").and.returnValue(of([]));

      // When
      devSearchService.getDeveloperSpecialities();

      // Then
      expect(spy).toHaveBeenCalled();
    }
  ));

  it("should recover developers", inject([HttpClient, DevSearchService], (http: HttpClient, devSearchService: DevSearchService) => {
    // Given
    const spy = spyOn(http, "get").and.returnValue(of([]));
    const developerSearchDto: DeveloperSearchDto = {
      nickname: "",
      location: "",
      speciality: ""
    };

    // When
    devSearchService.getDevelopers(developerSearchDto);

    // Then
    expect(spy).toHaveBeenCalled();
  }));
});
