import { Component, Input } from "@angular/core";
import { DeveloperInformation } from "../../models/developer-information.model";
import { Developer } from "../../models/developer.model";

@Component({
  selector: "ms-front-dev-info-display",
  templateUrl: "./dev-info-display.component.html",
  styleUrls: ["./dev-info-display.component.scss"]
})
export class DevInfoDisplayComponent {
  @Input() public searchedDeveloper: Developer;
  @Input() public developerInformations: DeveloperInformation;

  constructor() {}
}
