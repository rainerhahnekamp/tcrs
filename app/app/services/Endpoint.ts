import {Http, Response} from "@angular/http";
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
}
