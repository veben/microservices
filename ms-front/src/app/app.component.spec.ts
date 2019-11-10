import { TestBed, async } from "@angular/core/testing";
import { AppComponent } from "./app.component";
import { CUSTOM_ELEMENTS_SCHEMA } from "@angular/core";
import { BrowserAnimationsModule } from "@angular/platform-browser/animations";

describe("AppComponent", () => {
  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [AppComponent],
      imports: [BrowserAnimationsModule],
      schemas: [CUSTOM_ELEMENTS_SCHEMA]
    }).compileComponents();
  }));

  it("should create the app", () => {
    const fixture = TestBed.createComponent(AppComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app).toBeTruthy();
  });
});
