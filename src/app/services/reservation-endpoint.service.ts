import {Injectable} from "@angular/core";
import {Endpoint} from "./endpoint.service";
import {ReservationAddRequest} from "endpoints";
@Injectable()
export class ReservationEndpoint {
  constructor(private endpoint: Endpoint) {}

  public addRegistration(reservationAddRequest: ReservationAddRequest) {
    return this.endpoint.post("/reservation/add", reservationAddRequest);
  }
}
