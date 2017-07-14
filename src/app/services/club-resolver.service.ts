/**
 * retrieves information about the existing clubs in the system for the enduser.
 */

import {Injectable} from "@angular/core";
import {ActivatedRouteSnapshot, Resolve, RouterStateSnapshot} from "@angular/router";
import {ClubsListResponse} from "endpoints";
import {ClubsBroker} from "./club-broker.service";

@Injectable()
export class ClubsResolver implements Resolve<Array<ClubsListResponse>> {
  constructor(private clubsBroker: ClubsBroker) {

  }

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    return this.clubsBroker.findAll();
  }
}
