import { Component } from "@angular/core";

@Component({
  selector: "ms-front-footer",
  templateUrl: "./footer.component.html",
  styleUrls: ["./footer.component.scss"]
})
export class FooterComponent {
  readonly stackoverflowUrl: string = "https://stackoverflow.com/users/8718377/veben?tab=profile";
  readonly githubUrl: string = "https://github.com/veben";
  readonly linkedinUrl: string = "https://www.linkedin.com/in/benoitveyriere/";

  constructor() {}
}
