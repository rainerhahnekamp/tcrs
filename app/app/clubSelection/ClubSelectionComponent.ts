import {Component, OnInit} from "@angular/core";
import {ActivatedRoute} from "@angular/router";
import {ClubInfo} from "../services/ClubsBroker";

@Component({
  templateUrl: "clubSelection.html"
})
export default class ClubSelectorComponent implements OnInit {
  private clubs: Array<ClubInfo>;

  constructor(private route: ActivatedRoute) {}

  ngOnInit(): void {
    this.route.data.subscribe((data: {clubs: Array<ClubInfo>}) => {
      this.clubs = data.clubs;
    })
  }
}
