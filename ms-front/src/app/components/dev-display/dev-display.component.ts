import { Component, EventEmitter, Input, Output } from "@angular/core";
import { Developer } from "../../models/developer.model";

@Component({
  selector: "ms-front-dev-display",
  templateUrl: "./dev-display.component.html",
  styleUrls: ["./dev-display.component.scss"]
})
export class DevDisplayComponent {
  @Input() public developers: Developer[] = [];
  @Output() public devIdEmitter: EventEmitter<string> = new EventEmitter<string>();

  constructor() {}

  onDevClick(id: string): void {
    this.devIdEmitter.emit(id);
  }
}
