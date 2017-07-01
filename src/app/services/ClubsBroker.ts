import {Injectable} from "@angular/core";
import {Observable} from "rxjs/Observable";
import {Endpoint} from "./Endpoint";
import {ClubsListResponse} from "endpoints";


@Injectable()
export class ClubsBroker {
  constructor(private endpoint: Endpoint) {}

  findAll(): Observable<Array<ClubsListResponse>> {
    return this.endpoint.get<Array<ClubsListResponse>>("clubs/list");
  }
}
