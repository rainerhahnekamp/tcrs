import {Http, Response} from "@angular/http";
import {Observable} from "rxjs/Observable";
import {Injectable} from "@angular/core";

@Injectable()
export default class Endpoint {
  constructor(private http: Http) {

  }

  get<T>(url: string): Observable<T> {
    return this.http.get("http://localhost:8080/" + url)
      .map((response: Response) => response.json());
  }
}
