import {BrowserModule} from '@angular/platform-browser';
import {LOCALE_ID, NgModule} from '@angular/core';
import {ReactiveFormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import {
  MatButtonModule, MatCardModule, MatCheckboxModule, MatDatepickerModule, MatIconModule,
  MatInputModule,
  MatMenuModule,
  MatSelectModule, MatToolbarModule
} from '@angular/material';
import {AppComponent} from './app.component';
import {CalendarComponent} from './calendar/calendar.component';
import {FlexLayoutModule} from '@angular/flex-layout';
import {RouterModule} from '@angular/router';
import {ClubsBroker} from './services/club-broker.service';
import {ClubsResolver} from './services/club-resolver.service';
import {Endpoint} from './services/endpoint.service';
import {UserService} from './services/user-service.service';
import {routes} from './routes';
import {AngularFireModule} from 'angularfire2';
import {AngularFireAuthModule} from 'angularfire2/auth';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import RootComponent from './root/root.component';
import ClubSelectorComponent from './club-selection/club-selection.component';
import LoginComponent from './login/login.component';
import RegistrationComponent from './registration/registration.component';
import WelcomeComponent from './welcome/welcome.component';
import ReservationComponent from './reservation/reservation.component';
import {UrlService} from './services/url.service';
import {ReservationResolver} from './services/reservation-resolver.service';
import {ReservationEndpoint} from './services/reservation-endpoint.service';
import ReservationFinishedComponent from './reservation-finished/reservation-finished.component';
import {PfuschStore} from './services/pfusch--store.service';
import {DateParser} from './services/date-parser.service';
import ReservationEditComponent from './reservation-edit/reservation-edit.component';
import {ReservationEditResolver} from './services/reservation-edit-resolver.service';
import {StoreModule} from '@ngrx/store';
import {appReducer} from './store/reducer';
import {MatMomentDateModule} from '@angular/material-moment-adapter';

@NgModule({
  imports: [
    BrowserModule,
    AngularFireModule.initializeApp({
      apiKey: 'AIzaSyDEKMK7Rm1Tp8DELVWOSzGNC7s1o23jS80',
      authDomain: 'tcrs-dev.firebaseapp.com'
    }),
    AngularFireAuthModule,
    BrowserAnimationsModule,
    FlexLayoutModule,
    ReactiveFormsModule,
    HttpClientModule,
    MatButtonModule, MatCardModule, MatCheckboxModule, MatDatepickerModule, MatIconModule, MatInputModule,
    MatMenuModule, MatMomentDateModule, MatSelectModule, MatToolbarModule,
    RouterModule.forRoot(routes),
    StoreModule.forRoot(<any>{app: appReducer})
  ],
  declarations: [
    AppComponent, RootComponent, ClubSelectorComponent, CalendarComponent, LoginComponent,
    ReservationComponent, ReservationEditComponent, ReservationFinishedComponent,
    RegistrationComponent, WelcomeComponent],
  bootstrap: [AppComponent],
  providers: [
    {provide: LOCALE_ID, useValue: window.navigator.language},
    ClubsResolver,
    ClubsBroker,
    DateParser,
    Endpoint,
    PfuschStore,
    ReservationEndpoint,
    ReservationEditResolver,
    ReservationResolver,
    UrlService,
    UserService
  ]
})
export class AppModule { }
