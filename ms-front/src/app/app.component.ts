import { Component, OnInit } from "@angular/core";
import { DeveloperSearchDto } from "./models/developer-search-dto.model";
import { HttpErrorResponse } from "@angular/common/http";
import { DevSearchService } from "./services/dev-search/dev-search.service";
import { Developer } from "./models/developer.model";
import { ManageErrorService } from "./services/manage-error/manage-error.service";
import { DeveloperInformation } from "./models/developer-information.model";

@Component({
  selector: "ms-front-root",
  templateUrl: "./app.component.html",
  styleUrls: ["./app.component.scss"]
})
export class AppComponent implements OnInit {
  developerSpecialities: string[];
  developers: Developer[];
  developerInformations: DeveloperInformation;

  constructor(private developerService: DevSearchService, private manageErrorService: ManageErrorService) {}

  ngOnInit(): void {
    this.developerService
      .loadDeveloperSpecialities()
      .subscribe(
        data => (this.developerSpecialities = data),
        (err: HttpErrorResponse) => this.manageErrorService.serviceBackErrorDisplaying(err)
      );
  }

  public onSearchDev(developerSearchDto: DeveloperSearchDto): void {
    this.developerService.loadDevelopers(developerSearchDto).subscribe(
      data => {
        this.developers = data;
        this.developerInformations = null;
      },
      (err: HttpErrorResponse) => this.manageErrorService.serviceBackErrorDisplaying(err)
    );
  }

  public onSearchDevInfo(developerId: string): void {
    this.developerService.loadDeveloperInformations(developerId).subscribe(
      data => {
        this.developerInformations = data;
      },
      (err: HttpErrorResponse) => this.manageErrorService.serviceBackErrorDisplaying(err)
    );
  }
}
