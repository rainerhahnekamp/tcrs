import { Component, OnInit } from '@angular/core';
import * as moment from "moment";
import {Moment} from "moment";
import * as _ from "lodash";
import {Endpoint} from '../services/Endpoint';

@Component({
  selector: 'calendar',
  templateUrl: './calendar.component.html',
  styleUrls: ['./calendar.component.sass']
})

export class CalendarComponent implements OnInit {
  fromHour: number = 8;
  toHour: number = 20;
  startDay: Moment;
  endDay: Moment;

  constructor(private endpoint: Endpoint) {};

  days = [
    {name: "Mo"}, {name: "Di"}, {name: "Mi"}, {name: "Do"},
    {name: "Fr"}, {name: "Sa"}, {name: "So"}
  ];
  places: Array<number> = [1, 2, 3];
  hours: Array<number> = [];
  reservations: Array<Reservation> = [];

  ngOnInit() {
    this.startDay = moment().startOf("isoWeek");
    this.endDay = moment(this.startDay).add(1, "week");
    this.hours = _.times(this.toHour - this.fromHour)
      .map((hour) => hour + this.fromHour);
  }

  setReservation(place, hour) {
    r: Reservation = new Reservation("2", 1400000000, 1);
    this.endpoint.post('registration/add', r);
  }

  getReservation() {
    let queryStr = '?from=2016-04-29&to=2016-05-01';
    return this.endpoint.get<Reservation[]>('/reservation/find' + queryStr).subscribe(
      reservations => {
        this.reservations = reservations;
      }
    );
  }
}

export class Reservation {
  id: string;
  startDatetime: number;
  hours: number;

  constructor(id: string, startDatetime: number, hours: number) {
    this.id = id;
    this.startDatetime = startDatetime;
    this.hours = hours;
  };
}
