import { Component, EventEmitter, Input, OnInit, Output } from "@angular/core";
import { AbstractControl, FormBuilder, FormGroup } from "@angular/forms";
import { DeveloperSearchDto } from "../../models/developer-search-dto.model";

@Component({
  selector: "ms-front-dev-search",
  templateUrl: "./dev-search.component.html",
  styleUrls: ["./dev-search.component.scss"]
})
export class DevSearchComponent implements OnInit {
  @Input() public developerSpecialities: string[] = [];
  @Output() public search: EventEmitter<DeveloperSearchDto> = new EventEmitter<DeveloperSearchDto>();

  searchForm: FormGroup;

  constructor(private formBuilder: FormBuilder) {}

  ngOnInit(): void {
    this.searchForm = this.formBuilder.group({
      nickname: [""],
      location: [""],
      speciality: [""]
    });
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

    this.search.emit(developerSearchDto);
  }
}
