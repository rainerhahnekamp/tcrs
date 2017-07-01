import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {ClubsListResponse} from 'endpoints';

@Component({
  templateUrl: 'club-selection.html'
})
export default class ClubSelectorComponent implements OnInit {
  private clubs: Array<ClubsListResponse>;

  constructor(private route: ActivatedRoute) {}

  ngOnInit(): void {
    this.route.data.subscribe((data: {clubs: Array<ClubsListResponse>}) => {
      this.clubs = data.clubs;
    });
  }
}
