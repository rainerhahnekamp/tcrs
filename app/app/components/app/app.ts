import { Component } from '@angular/core';
import { MdButton } from "@angular/material";
import * as _ from "lodash";
import * as moment from "moment";
import {Moment} from "moment";


@Component({
  selector: 'app-root',
  templateUrl: './app.html',
  styleUrls: ['./app.sass']
})
export class AppComponent {
  fromHour: number = 8;
  toHour: number = 20;
  startDay: Moment;
  endDay: Moment;
  weekName: string;

  days = [
    {name: "Mo"}, {name: "Di"}, {name: "Mi"}, {name: "Do"},
    {name: "Fr"}, {name: "Sa"}, {name: "So"}
    ];
  cells = [];

  constructor() {
    this.startDay = moment().startOf("isoWeek");
    this.endDay = moment(this.startDay).add(1, "week");
    this.cells = _.times((this.toHour - this.fromHour) * this.days.length);
  }

}
