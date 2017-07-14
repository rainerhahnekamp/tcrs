import {Injectable} from "@angular/core";
import {ActivatedRouteSnapshot, Resolve, RouterStateSnapshot} from "@angular/router";
import {Observable} from "rxjs/Observable";

@Injectable()
export class ReservationResolver implements Resolve<CourtAvailability> {
  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    return new Observable<CourtAvailability>(observable => {
      observable.next({"court1": 5, "court2": 3, "court3": 1});
      observable.complete();
    });
  }
}

export interface CourtAvailability {
  [court: string]: number
}
