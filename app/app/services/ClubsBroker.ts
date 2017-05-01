import {Injectable} from "@angular/core";
import {Http, Response} from "@angular/http";
import {Observable} from "rxjs/Observable";
import {Endpoint} from "./Endpoint";

export interface ClubInfo {
  name: String;
  url: String;
}

@Injectable()
export class ClubsBroker {
  constructor(private endpoint: Endpoint) {}

  findAll(): Observable<Array<ClubInfo>> {
    return this.endpoint.get<Array<ClubInfo>>("clubs/list");
  }
}
