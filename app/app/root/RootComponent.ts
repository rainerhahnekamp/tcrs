import {Component, OnInit} from "@angular/core";

@Component({
  template: "<router-outlet></router-outlet>"
})
export default class RootComponent implements OnInit {

  ngOnInit(): void {
    console.log("root");
  }
}
