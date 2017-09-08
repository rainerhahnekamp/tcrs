import {Injectable} from '@angular/core';
import {ActivatedRouteSnapshot, Resolve, RouterStateSnapshot} from '@angular/router';
import {Observable} from 'rxjs/Observable';
import {ReservationAddResponse} from 'endpoints';

@Injectable()
export class ReservationEditResolver implements Resolve<ReservationAddResponse> {
  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    return new Observable<ReservationAddResponse>(observable => {
      observable.next({
        clubId: 'Test',
        courtId: '1',
        hours: 5,
        startDatetime: new Date(),
        url: 'XXX'
      });
      observable.complete();
    });
  }
}
