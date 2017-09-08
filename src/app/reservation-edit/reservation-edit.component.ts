import {Component, OnInit} from '@angular/core';
import {ReservationDetailResponse} from 'endpoints';
import {ActivatedRoute, Router} from '@angular/router';
import {ReservationEndpoint} from '../services/reservation-endpoint.service';

@Component({
  templateUrl: 'reservation-edit.component.html'
})
export default class ReservationEditComponent implements OnInit {

  public hideRemoveInfo: boolean;
  public hideRemovedInfo: boolean;

  constructor(private reservationEndpoint: ReservationEndpoint,
              private activatedRoute: ActivatedRoute
  ) {

  }

  ngOnInit() {
    this.hideRemoveInfo = true;
    this.hideRemovedInfo = true;
    this.activatedRoute.data.subscribe((data: {reservation: ReservationDetailResponse}) => {
        console.log(data);
      }
    );
  }

  remove() {
    this.hideRemoveInfo = false;
    this.reservationEndpoint.removeReservation(
      {hash: '1234567890', id: '1234567890'}
    ).then(
      (isRemoved: boolean) => {
        console.log(isRemoved);
        this.hideRemovedInfo = !isRemoved;
      }
    );
  }

}
