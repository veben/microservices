import { Component, Input } from "@angular/core";
import { DeveloperInformation } from "../../models/developer-information.model";

@Component({
  selector: "ms-front-dev-info-display",
  templateUrl: "./dev-info-display.component.html",
  styleUrls: ["./dev-info-display.component.scss"]
})
export class DevInfoDisplayComponent {
  @Input() public developerInformations: DeveloperInformation;

  constructor() {}
}
