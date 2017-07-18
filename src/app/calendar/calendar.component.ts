import {Component, OnInit} from '@angular/core';
import * as moment from 'moment';
import {Moment} from 'moment';
import * as _ from 'lodash';
import {ReservationResponse} from 'endpoints';
import {Endpoint} from '../services/endpoint.service';
import {ActivatedRoute, Router} from '@angular/router';
import {UrlService} from '../services/url.service';

@Component({
  templateUrl: './calendar.component.html',
  styleUrls: ['./calendar.component.sass']
})
export class CalendarComponent implements OnInit {
  fromHour = 8;
  toHour = 20;
  startDay: Moment;
  endDay: Moment;
  days = [];
  places: Array<number> = [1, 2, 3];
  hours: Array<number> = [];
  reservations: Array<ReservationResponse> = [];
  isMobile = false;

  constructor(private endpoint: Endpoint, private router: Router,
              private activatedRoute: ActivatedRoute, private urlService: UrlService) {}

  ngOnInit() {
    this.generateDays();
    this.hours = _.times(this.toHour - this.fromHour)
      .map((hour) => hour + this.fromHour);
    this.fromHour = 8;
    this.toHour = 20;
  }

  generateDays() {
    this.startDay = moment().startOf('isoWeek');
    this.endDay = moment(this.startDay).add(1, 'week');
    const tmp = moment(this.startDay);
    while (tmp.isBefore(this.endDay)) {
      this.days.push({name: tmp.isoWeekday(), date: tmp.format('YYYY-MM-DD')});
      tmp.add(1, 'day');
    }
  }

  updateView(tmpDate) {
    console.log('--UPDATE VIEW--');
    console.log(tmpDate);
  }

  setReservation(day, hour) {
    this.router.navigate(['/', this.urlService.getCurrentClub(), 'reservation', day, hour]);
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


