import { Component, OnInit } from "@angular/core";
import { AbstractControl, FormBuilder, FormGroup } from "@angular/forms";
import { DeveloperSearchDto } from "../../models/developer-search-dto.model";
import { DevSearchService } from "../../services/dev-search/dev-search.service";
import { Developer } from "../../models/developer.model";
import { HttpErrorResponse } from "@angular/common/http";
import { MessageUtils } from "../../utils/message-utils";
import { ManageErrorService } from "../../services/manage-error/manage-error.service";

@Component({
  selector: "ms-front-dev-search",
  templateUrl: "./dev-search.component.html",
  styleUrls: ["./dev-search.component.scss"]
})
export class DevSearchComponent implements OnInit {
  searchForm: FormGroup;
  developerSpecialities: string[];
  developers: Developer[];

  constructor(private formBuilder: FormBuilder, private devService: DevSearchService, private manageErrorService: ManageErrorService) {}

  ngOnInit(): void {
    this.searchForm = this.formBuilder.group({
      nickname: [""],
      location: [""],
      speciality: [""]
    });

    this.devService
      .loadDeveloperSpecilities()
      .subscribe(
        data => (this.developerSpecialities = data),
        (err: HttpErrorResponse) => this.manageErrorService.serviceBackErrorDisplaying(err, MessageUtils.MS_DEVELOPER_DOWN)
      );
  }

  get f(): { [p: string]: AbstractControl } {
    return this.searchForm.controls;
  }

  onSubmit(): void {
    const developerSearchDto: DeveloperSearchDto = {
      nickname: this.f.nickname.value,
      location: this.f.location.value,
      speciality: this.f.speciality.value
    };

    this.devService
      .loadDevelopers(developerSearchDto)
      .subscribe(
        data => (this.developers = data),
        (err: HttpErrorResponse) => this.manageErrorService.serviceBackErrorDisplaying(err, MessageUtils.MS_DEVELOPER_DOWN)
      );
  }
}
