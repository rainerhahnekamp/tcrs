import {Component} from 'angular2/core';

@Component({
  selector: 'my-app',
  template: `
    <h1>My First Angular 2 App</h1>
    <div class="weeks">
      <div class="week col s1" *ngFor="#w of weeks">
        <div class="header">{{w.name}}</div>
        <div class="days">
          <div class="day row" *ngFor="#d of w.days">
            <div class="header col s12">{{d.name}}</div>
            <div class="timeUnits col s12">
              <div class="timeUnit" *ngFor="#u of d.timeUnits">
                {{ u.content }}
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    `
})

export class AppComponent {
  weeks = WEEKS;
}

export class Week {
  id: number;
  name: string;
  days: Day[];
}

export class Day {
  id: number;
  name: string;
  start: string;
  end: string;
  type: string;
  timeUnits: TimeUnit[];
}

export class TimeUnit {
  id: number;
  content: string;
  length: number;
}

var TIMEUNITS: TimeUnit[] = [
  { id: 1, content: "Heinz", length: 60 }
];

var DAYS: Day[] = [
  { id: 1, name: "Monday", start: "8", end: "20", type: "MONDAY" , timeUnits: TIMEUNITS }
];

var WEEKS: Week[] = [
  { id: 1, name: "Woche1" , days: DAYS }
];


