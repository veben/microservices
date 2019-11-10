import { async, ComponentFixture, fakeAsync, TestBed, tick } from "@angular/core/testing";

import { SpinnerComponent } from "./spinner.component";
import { DebugElement } from "@angular/core";
import { SpinnerService } from "../../services/spinner/spinner.service";

describe("SpinnerComponent", () => {
  let component: SpinnerComponent;
  let fixture: ComponentFixture<SpinnerComponent>;
  let debugElement: DebugElement;
  let spinnerService: SpinnerService;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [SpinnerComponent]
    }).compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SpinnerComponent);
    component = fixture.componentInstance;
    debugElement = fixture.debugElement;
    spinnerService = debugElement.injector.get(SpinnerService);
    fixture.detectChanges();
  });

  it("should create", () => {
    expect(component).toBeTruthy();
  });

  it("should get loading status", fakeAsync(() => {
    spinnerService.loadingStatus.next(true);
    component.getLoadingStatus();
    tick(300);
    expect(component.loading).toBeTruthy();
  }));
});
