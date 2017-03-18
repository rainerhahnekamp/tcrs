import { Component, OnInit } from '@angular/core';
import * as moment from "moment";
import {Moment} from "moment";
import * as _ from "lodash";

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

  days = [
    {name: "Mo"}, {name: "Di"}, {name: "Mi"}, {name: "Do"},
    {name: "Fr"}, {name: "Sa"}, {name: "So"}
  ];
  places: Array<number> = [1, 2, 3];
  hours: Array<number> = [];

  ngOnInit() {
    this.startDay = moment().startOf("isoWeek");
    this.endDay = moment(this.startDay).add(1, "week");
    this.hours = _.times(this.toHour - this.fromHour)
      .map((hour) => hour + this.fromHour);
  }
}
