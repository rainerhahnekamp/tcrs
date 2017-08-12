import {ReservationAddRequest, ReservationAddResponse} from 'endpoints';
import {Injectable} from '@angular/core';
import {Endpoint} from './endpoint.service';

@Injectable()
export class ReservationEndpoint {
  constructor(private endpoint: Endpoint) {}

  public addRegistration(reservationAddRequest: ReservationAddRequest): Promise<ReservationAddResponse> {
    return this.endpoint.post('/reservation/add', reservationAddRequest);
  }
}
