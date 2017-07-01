import {Component, Input, OnInit} from "@angular/core";
import {Moment} from "moment";

@Component({
  selector: 'calendar-navigator',
  templateUrl: './calendar-navigator.component.html',
  styleUrls: ['./calendar-navigator.component.sass']
})
export class CalendarNavigatorComponent implements OnInit {
  @Input() startDay: Moment;
  @Input() endDay: Moment;
  weekName: string;

  constructor() { }

  ngOnInit() {
    this.weekName = "" + this.startDay.week() + "/" + this.startDay.year();
  }

}
