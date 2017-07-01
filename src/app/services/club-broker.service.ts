import {Injectable} from "@angular/core";
import {Observable} from "rxjs/Observable";
import {ClubsListResponse} from "endpoints";
import {Endpoint} from "./endpoint.service";


@Injectable()
export class ClubsBroker {
  constructor(private endpoint: Endpoint) {}

  findAll(): Observable<Array<ClubsListResponse>> {
    return this.endpoint.get<Array<ClubsListResponse>>('clubs/list');
  }
}
