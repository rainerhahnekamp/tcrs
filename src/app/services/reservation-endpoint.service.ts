import {
  ReservationAddRequest, ReservationAddResponse, ReservationDetailResponse,
  ReservationGetRequest
} from 'endpoints';
import {Injectable} from '@angular/core';
import {Endpoint} from './endpoint.service';

@Injectable()
export class ReservationEndpoint {
  constructor(private endpoint: Endpoint) {}

  public addReservation(reservationAddRequest: ReservationAddRequest): Promise<ReservationAddResponse> {
    return this.endpoint.post('/reservation/add', reservationAddRequest);
  }

  public getReservation(reservationGetRequest: ReservationGetRequest): Promise<ReservationDetailResponse> {
    return this.endpoint.post( '/reservation/get', reservationGetRequest);
  }

  public removeReservation(reservationRemoveRequest: ReservationGetRequest): Promise<Boolean> {
    return this.endpoint.post( '/reservation/remove', reservationRemoveRequest);
  }

}
