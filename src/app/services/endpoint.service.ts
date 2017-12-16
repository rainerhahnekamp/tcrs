import {Observable} from 'rxjs/Observable';
import {Injectable} from '@angular/core';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/toPromise';
import {HttpClient} from '@angular/common/http';

@Injectable()
export class Endpoint {
  constructor(private http: HttpClient) {

  }

  get<T>(url: string): Observable<T> {
    return this.http.get<T>('/api/' + url);
  }

  post<T>(url: string, body: any = {}): Promise<T> {
    return this.http.post<T>('/api/' + url, body)
      .toPromise();
  }
 }
