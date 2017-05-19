import {Http, Response, Headers, RequestOptions} from "@angular/http";
import {Observable} from "rxjs/Observable";
import {Injectable} from "@angular/core";

@Injectable()
export class Endpoint {
  constructor(private http: Http) {

  }

  get<T>(url: string): Observable<T> {
    return this.http.get("/api/" + url)
      .map((response: Response) => response.json());
  }

  post(url: string, data) {
    let headers = new Headers({ 'Content-Type': 'application/json'});
    let options = new RequestOptions({ headers: headers});
    return this.http.post("/api/" + url, data, options);
  }
}
