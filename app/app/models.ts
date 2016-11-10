export interface Week {
  id: number;
  name: string;
  days: Day[];
}

export interface Day {
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
  start: number;
  end: number;
  length: number;

  constructor (start : number, end : number) {
    this.start = start;
    this.end = end;
  }
}
