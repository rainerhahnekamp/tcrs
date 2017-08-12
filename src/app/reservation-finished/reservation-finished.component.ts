import {Component, OnInit} from '@angular/core';
import {PfuschStore} from '../services/pfusch--store.service';
import {ReservationAddResponse} from 'endpoints';
import * as moment from 'moment';

@Component({
  templateUrl: 'reservation-finished.html'
})
export default class ReservationFinishedComponent implements OnInit {
  reservationAddResponse: ReservationAddResponse;

  constructor(private store: PfuschStore) {

  }

  ngOnInit(): void {
    this.reservationAddResponse = this.store.get('reservation') as ReservationAddResponse;
  }

}
