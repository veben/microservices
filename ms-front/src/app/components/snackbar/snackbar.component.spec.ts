import { async, ComponentFixture, TestBed } from "@angular/core/testing";

import { SnackbarComponent } from "./snackbar.component";
import { CUSTOM_ELEMENTS_SCHEMA } from "@angular/core";
import { MAT_SNACK_BAR_DATA } from "@angular/material/snack-bar";
import { SnackBarType } from "./enum/snack-bar-type.enum";
import { BrowserAnimationsModule } from "@angular/platform-browser/animations";

describe("SnackbarComponent", () => {
  let component: SnackbarComponent;
  let fixture: ComponentFixture<SnackbarComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [SnackbarComponent],
      imports: [BrowserAnimationsModule],
      schemas: [CUSTOM_ELEMENTS_SCHEMA],
      providers: [
        {
          provide: MAT_SNACK_BAR_DATA,
          useValue: { text: "SnackBar text test", type: SnackBarType.SUCCESS }
        }
      ]
    }).compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SnackbarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it("should create", () => {
    expect(component).toBeTruthy();
  });

  it("should set text to empty string if no text", () => {
    component.snackBarData.text = null;
    component.recoverToastAttributes();
    expect(component.text).toBe("");
  });

  it("should cut text if too long", () => {
    component.snackBarData.text = "this is a long text";
    component.textMaxLength = 14;
    component.recoverToastAttributes();
    const expectedText = "this is a long...";
    expect(component.text).toBe(expectedText);
  });

  it("should set text on snack bar error", () => {
    component.type = SnackBarType.ERROR;
    component.defineAttributesClassesAndIcons();
    const textClass = "snackbar-text snackbar-text-error";
    const iconClass = "error";
    expect(component.textClass).toBe(textClass);
    expect(component.iconType).toBe(iconClass);
  });

  it("should set text on snack bar warning", () => {
    component.type = SnackBarType.WARNING;
    component.defineAttributesClassesAndIcons();
    const textClass = "snackbar-text snackbar-text-warning";
    const iconClass = "warning";
    expect(component.textClass).toBe(textClass);
    expect(component.iconType).toBe(iconClass);
  });

  it("should set text on snack bar info", () => {
    component.type = SnackBarType.INFO;
    component.defineAttributesClassesAndIcons();
    const textClass = "snackbar-text snackbar-text-info";
    const iconClass = "info";
    expect(component.textClass).toBe(textClass);
    expect(component.iconType).toBe(iconClass);
  });
});
