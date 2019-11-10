import { async, ComponentFixture, TestBed } from "@angular/core/testing";

import { DevSearchComponent } from "./dev-search.component";
import { MatFormFieldModule } from "@angular/material/form-field";
import { MatIconModule } from "@angular/material/icon";
import { MatOptionModule } from "@angular/material/core";
import { MatSelectModule } from "@angular/material/select";
import { ReactiveFormsModule } from "@angular/forms";
import { HttpClientModule } from "@angular/common/http";
import { MatSnackBarModule } from "@angular/material/snack-bar";
import { MatInputModule } from "@angular/material/input";
import { BrowserAnimationsModule } from "@angular/platform-browser/animations";
import { APP_BASE_HREF } from "@angular/common";
import { BrowserDynamicTestingModule } from "@angular/platform-browser-dynamic/testing";
import { SnackbarComponent } from "../snackbar/snackbar.component";

describe("DevSearchComponent", () => {
  let component: DevSearchComponent;
  let fixture: ComponentFixture<DevSearchComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      imports: [
        MatFormFieldModule,
        MatIconModule,
        MatOptionModule,
        MatSelectModule,
        ReactiveFormsModule,
        HttpClientModule,
        MatSnackBarModule,
        MatFormFieldModule,
        MatInputModule,
        BrowserAnimationsModule
      ],
      providers: [{ provide: APP_BASE_HREF, useValue: "/" }],
      declarations: [DevSearchComponent, SnackbarComponent]
    })
      .overrideModule(BrowserDynamicTestingModule, { set: { entryComponents: [SnackbarComponent] } })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DevSearchComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it("should create", () => {
    expect(component).toBeTruthy();
  });
});
