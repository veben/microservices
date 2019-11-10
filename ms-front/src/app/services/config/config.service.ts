import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { environment } from "../../../environments/environment";

@Injectable({
  providedIn: "root"
})
export class ConfigService {
  public configFileName = "config.json";

  constructor(private http: HttpClient) {}

  public loadAppConfig(): Promise<void> {
    return (
      this.http
        .get(environment.pathConfig + this.configFileName)
        .toPromise()
        // Tslint:disable-next-line: no-any
        .then((data: any) => {
          environment.APP_SETTINGS.path = data.paths;
        })
        // Tslint:disable-next-line: no-any
        .catch((error: any) => console.error(error.message))
    );
  }
}
