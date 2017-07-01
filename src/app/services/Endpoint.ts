import {Http, Response} from "@angular/http";
import {Observable} from "rxjs/Observable";
import {Injectable} from "@angular/core";

@Injectable()
export class Endpoint {
  constructor(private http: Http) {

  }

  get<T>(url: string): Observable<T> {
    return this.http.get("/api/" + url)
      .map(this.parseResponse);
  }

  post<T>(url: string, body: any = {}): Observable<T> {
    return this.http.post("/api/" + url, body).map(this.parseResponse);
  }

  private parseResponse(response: Response) {
    if (response.text()) {
      return response.json();
    }
    else {
      return null;
    }
  }
 }
