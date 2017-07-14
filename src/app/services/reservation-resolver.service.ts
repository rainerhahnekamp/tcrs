import {Injectable} from '@angular/core';
import {ActivatedRouteSnapshot, Resolve, RouterStateSnapshot} from '@angular/router';
import {Observable} from 'rxjs/Observable';

@Injectable()
export class ReservationResolver implements Resolve<CourtAvailability> {
  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    return new Observable<CourtAvailability>(observable => {
      observable.next({'Suzanne Lenglen': 5, 'Arthur Ashe Stadium': 3, 'Rod Laver Arena': 1});
      observable.complete();
    });
  }
}

export interface CourtAvailability {
  [court: string]: number;
}
