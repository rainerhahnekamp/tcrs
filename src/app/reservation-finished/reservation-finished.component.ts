import {Component, OnInit} from '@angular/core';
import {PfuschStore} from '../services/pfusch--store.service';
import {ReservationAddResponse} from 'endpoints';
import {DateParser} from '../services/date-parser.service';

@Component({
  templateUrl: 'reservation-finished.html'
})
export default class ReservationFinishedComponent implements OnInit {
  reservationAddResponse: ReservationAddResponse;

  constructor(private store: PfuschStore, private dateParser: DateParser) {

  }

  ngOnInit(): void {
    this.reservationAddResponse = this.store.get('reservation') as ReservationAddResponse;
    this.reservationAddResponse = <ReservationAddResponse> this.dateParser.parse(this.reservationAddResponse);
  }

}
