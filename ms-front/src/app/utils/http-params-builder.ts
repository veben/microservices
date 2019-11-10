import { HttpParams } from "@angular/common/http";

export class HttpParamsBuilder {
  private httpParams: HttpParams;

  constructor() {
    this.httpParams = new HttpParams();
  }

  public add(key: string, value: string): HttpParamsBuilder {
    if (key && value) {
      this.httpParams = this.httpParams.append(key, value);
    }
    return this;
  }

  public build(): HttpParams {
    return this.httpParams;
  }
}
