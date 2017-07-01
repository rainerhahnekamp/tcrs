/**
 * retrieves information about the existing clubs in the system for the enduser.
 */

import {Injectable} from "@angular/core";
import {ActivatedRouteSnapshot, Resolve, RouterStateSnapshot} from "@angular/router";
import {Observable} from "rxjs/Observable";
import {ClubsBroker} from "./ClubsBroker";
import {ClubsListResponse} from "endpoints";

@Injectable()
export class ClubsResolver implements Resolve<Array<ClubsListResponse>> {
  constructor(private clubsBroker: ClubsBroker) {

  }

  resolve(route: ActivatedRouteSnapshot,
          state: RouterStateSnapshot): Observable<Array<ClubsListResponse>> {
    return this.clubsBroker.findAll();
  }
}
