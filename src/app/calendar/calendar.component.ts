import {Component, OnInit} from '@angular/core';
import * as moment from 'moment';
import {Moment} from 'moment';
import * as _ from 'lodash';
import {ReservationAddRequest, ReservationResponse} from 'endpoints';
import {Endpoint} from '../services/endpoint.service';

@Component({
  templateUrl: './calendar.component.html',
  styleUrls: ['./calendar.component.sass']
})
export class CalendarComponent implements OnInit {
  fromHour = 8;
  toHour = 20;
  startDay: Moment;
  endDay: Moment;
  days = [
    {name: 'Mo'}, {name: 'Di'}, {name: 'Mi'}, {name: 'Do'},
    {name: 'Fr'}, {name: 'Sa'}, {name: 'So'}
  ];
  places: Array<number> = [1, 2, 3];
  hours: Array<number> = [];
  reservations: Array<ReservationResponse> = [];
  isMobile = false;

  constructor(private endpoint: Endpoint) {};

  ngOnInit() {
    this.generateDays();
    this.hours = _.times(this.toHour - this.fromHour)
      .map((hour) => hour + this.fromHour);
    this.fromHour = 8;
    this.toHour = 20;
  }

  generateDays() {
    if (!this.isMobile) {
    } else {
      this.startDay = moment().startOf('isoWeek');
      this.endDay = moment(this.startDay).add(1, 'week');
    }
  }

  updateView(tmpDate) {
    console.log('--UPDATE VIEW--');
    console.log(tmpDate);
  }

  setReservation(day, hour) {
    console.log(day);
    console.log(hour);
    const r: ReservationAddRequest = {startDatetime: new Date(), hours: 1};
    this.endpoint.post('registration/add', r);
  }

  getReservation() {
    const queryStr = '?from=2016-04-29&to=2016-05-01';
    return this.endpoint.get<ReservationResponse[]>('/reservation/find' + queryStr).subscribe(
      reservations => {
        this.reservations = reservations;
        console.log(this.reservations);
      }
    );
  }
}

export interface Reservation {
  id: string;
  startDatetime: Date;
  hours: number;
}