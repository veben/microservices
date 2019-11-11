import { BrowserModule } from "@angular/platform-browser";
import { APP_INITIALIZER, NgModule } from "@angular/core";

import { AppRoutingModule } from "./app-routing.module";
import { AppComponent } from "./app.component";
import { HeaderComponent } from "./components/header/header.component";
import { DevSearchComponent } from "./components/dev-search/dev-search.component";
import { MatFormFieldModule, MatIconModule } from "@angular/material";
import { MatInputModule } from "@angular/material/input";
import { BrowserAnimationsModule } from "@angular/platform-browser/animations";
import { MatToolbarModule } from "@angular/material/toolbar";
import { MatTooltipModule } from "@angular/material/tooltip";
import { FooterComponent } from "./components/footer/footer.component";
import { MatListModule } from "@angular/material/list";
import { MatSlideToggleModule } from "@angular/material/slide-toggle";
import { MatSelectModule } from "@angular/material/select";
import { ReactiveFormsModule } from "@angular/forms";
import { MatButtonModule } from "@angular/material/button";
import { FlexLayoutModule } from "@angular/flex-layout";
import { ConfigService } from "./services/config/config.service";
import { HTTP_INTERCEPTORS, HttpClientModule } from "@angular/common/http";
import { MatSnackBarModule } from "@angular/material/snack-bar";
import { SnackbarComponent } from "./components/snackbar/snackbar.component";
import { SpinnerComponent } from "./components/spinner/spinner.component";
import { SpinnerInterceptor } from "./services/spinner/spinner.interceptor";
import { DevDisplayComponent } from "./components/dev-display/dev-display.component";
import { DevInfoDisplayComponent } from "./components/dev-info-display/dev-info-display.component";

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    DevSearchComponent,
    FooterComponent,
    SnackbarComponent,
    SpinnerComponent,
    DevDisplayComponent,
    DevInfoDisplayComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    MatFormFieldModule,
    HttpClientModule,
    MatIconModule,
    MatInputModule,
    MatToolbarModule,
    MatTooltipModule,
    MatListModule,
    MatSlideToggleModule,
    MatSelectModule,
    ReactiveFormsModule,
    MatButtonModule,
    MatSnackBarModule,
    FlexLayoutModule
  ],
  providers: [
    {
      provide: APP_INITIALIZER,
      // eslint-disable-next-line @typescript-eslint/explicit-function-return-type
      useFactory: (config: ConfigService) => () => config.loadAppConfig(),
      deps: [ConfigService],
      multi: true
    },
    {
      provide: HTTP_INTERCEPTORS,
      useClass: SpinnerInterceptor,
      multi: true
    }
  ],
  entryComponents: [SnackbarComponent],
  bootstrap: [AppComponent]
})
export class AppModule {}
