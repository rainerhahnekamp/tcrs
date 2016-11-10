import { Component } from '@angular/core';
import { MdButton } from "@angular/material";
import {TimeUnit, Day, Week} from "./models";


var TIMEUNITS: TimeUnit[] = [
  { id: 1, content: "Heinz", length: 60, start: 0, end: 0 }
];

var DAYS: Day[] = [
  { id: 1, name: "Monday", start: "8", end: "20", type: "MONDAY" , timeUnits: TIMEUNITS }
];

var WEEKS: Week[] = [
  { id: 1, name: "Woche1" , days: DAYS }
];


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.sass']
})
export class AppComponent {
  start: number = 8;
  end: number = 20;

  weeks = WEEKS;
  testWeek: Day[] = this.generateWeek(new Date(), new Date());

  generateWeek(startDate: Date, endDate: Date) {
    var returner: Day[];

    return returner;
  }

  generateDay(start: number, end: number) {
    var returner: TimeUnit[];

    for (var i: number = start; i < end; i++) {
      returner.push(new TimeUnit(i, i+1));
    }

    return returner;
  }

}
