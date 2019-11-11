import { async, ComponentFixture, TestBed } from "@angular/core/testing";

import { DevInfoDisplayComponent } from "./dev-info-display.component";

describe("DevInfoDisplayComponent", () => {
  let component: DevInfoDisplayComponent;
  let fixture: ComponentFixture<DevInfoDisplayComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [DevInfoDisplayComponent]
    }).compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DevInfoDisplayComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it("should create", () => {
    expect(component).toBeTruthy();
  });
});
