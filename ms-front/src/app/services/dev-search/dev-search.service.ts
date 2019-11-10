import { Injectable } from "@angular/core";
import { HttpClient, HttpErrorResponse, HttpHeaders } from "@angular/common/http";
import { environment } from "../../../environments/environment";
import { Observable, throwError } from "rxjs";
import { DeveloperSearchDto } from "../../models/developer-search-dto.model";
import { HttpParamsBuilder } from "../../utils/http-params-builder";
import { catchError } from "rxjs/operators";
import { ManageErrorService } from "../manage-error/manage-error.service";
import { Developer } from "../../models/developer.model";

@Injectable({
  providedIn: "root"
})
export class DevSearchService {
  public readonly mdDevUri = "/api/developer/v1";
  public headers = new HttpHeaders();
  public baseUrl: string;

  constructor(private http: HttpClient, private manageErrorService: ManageErrorService) {
    this.headers = this.headers.set("Content-Type", "application/json; charset=utf-8");
    this.baseUrl = environment.APP_SETTINGS.path.msDevPath + this.mdDevUri;
  }

  public getDeveloperSpecialities(): Observable<any> {
    const uri = "/developers/list-specialities";
    const url = this.baseUrl + uri;
    return this.http.get(url, { headers: this.headers });
  }

  public getDevelopers(developerSearchSto: DeveloperSearchDto): Observable<any> {
    const uri = "/developers";
    const url = this.baseUrl + uri;
    const params = new HttpParamsBuilder()
      .add("nickname", developerSearchSto.nickname)
      .add("location", developerSearchSto.location)
      .add("speciality", developerSearchSto.speciality)
      .build();
    return this.http.get(url, { headers: this.headers, params });
  }

  // **********************************************************************************************************

  public loadDeveloperSpecilities(): Observable<string[]> {
    return this.getDeveloperSpecialities().pipe(
      catchError((err: HttpErrorResponse) => {
        this.manageErrorService.serviceBackErrorLogging(err);
        return throwError(err);
      })
    );
  }

  public loadDevelopers(developerSearchSto: DeveloperSearchDto): Observable<Developer[]> {
    return this.getDevelopers(developerSearchSto).pipe(
      catchError((err: HttpErrorResponse) => {
        this.manageErrorService.serviceBackErrorLogging(err);
        return throwError(err);
      })
    );
  }
}
