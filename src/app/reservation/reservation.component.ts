import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';
import * as moment from 'moment';
import {Moment} from 'moment';
import * as _ from 'lodash';
import {CourtAvailability} from '../services/reservation-resolver.service';
import {ReservationEndpoint} from '../services/reservation-endpoint.service';
import {UrlService} from '../services/url.service';
import {PfuschStore} from '../services/pfusch--store.service';

@Component({
  templateUrl: 'reservation.component.html'
})
export default class ReservationComponent implements OnInit {
  form: FormGroup;
  startDateTime: Moment;
  startDateTimePretty: string;
  hours: FormControl;
  confirmation: FormControl;
  court: FormControl;
  courtAvailability: CourtAvailability;
  courts: Array<string>;
  hourElements = [1, 2, 3, 4];
  showConfirmationError = false;

  constructor(private formBuilder: FormBuilder,
              private urlService: UrlService,
              private reservationEndpoint: ReservationEndpoint,
              private activatedRoute: ActivatedRoute,
              private router: Router,
              private store: PfuschStore) {

  }

  ngOnInit() {
    this.activatedRoute.data.subscribe((data: {courtAvailability: CourtAvailability}) => {
      this.courtAvailability = data.courtAvailability;
      this.courts = _.keys(this.courtAvailability);

      this.startDateTime = moment(this.activatedRoute.snapshot.params['day'])
        .add(this.activatedRoute.snapshot.params['hour'], 'hour');

      this.startDateTimePretty = this.startDateTime.format('LLLL');
      this.hours = this.formBuilder.control(this.hourElements[0]);
      this.court = this.formBuilder.control(this.courts[2]);
      this.confirmation = this.formBuilder.control(false, Validators.requiredTrue);
      this.form = this.formBuilder.group({
        hours: this.hours,
        confirmation: this.confirmation
      });
    });
  }

  onSubmit() {
    this.showConfirmationError = true;
    if (this.form.valid) {
      this.reservationEndpoint.addReservation({
        startDatetime: this.startDateTime.toDate(),
        hours: this.hours.value,
        courtId: this.court.value,
        clubUrl: this.urlService.getCurrentClub()
      }).then((reservationAddResponse) => {
        this.store.put('reservation', reservationAddResponse);
        this.router.navigate(['/', this.urlService.getCurrentClub(), 'reservation-finished']);
      });
    }
  }
}
