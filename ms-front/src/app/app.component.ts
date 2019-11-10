import { Component, OnInit } from "@angular/core";
import { DeveloperSearchDto } from "./models/developer-search-dto.model";
import { HttpErrorResponse } from "@angular/common/http";
import { DevSearchService } from "./services/dev-search/dev-search.service";
import { Developer } from "./models/developer.model";
import { ManageErrorService } from "./services/manage-error/manage-error.service";

@Component({
  selector: "ms-front-root",
  templateUrl: "./app.component.html",
  styleUrls: ["./app.component.scss"]
})
export class AppComponent implements OnInit {
  developers: Developer[];
  developerSpecialities: string[];

  constructor(private devService: DevSearchService, private manageErrorService: ManageErrorService) {}

  ngOnInit(): void {
    this.devService
      .loadDeveloperSpecilities()
      .subscribe(
        data => (this.developerSpecialities = data),
        (err: HttpErrorResponse) => this.manageErrorService.serviceBackErrorDisplaying(err)
      );
  }

  public onSearch(developerSearchDto: DeveloperSearchDto): void {
    this.devService
      .loadDevelopers(developerSearchDto)
      .subscribe(data => (this.developers = data), (err: HttpErrorResponse) => this.manageErrorService.serviceBackErrorDisplaying(err));
  }
}
