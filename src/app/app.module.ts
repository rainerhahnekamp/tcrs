import {BrowserModule} from "@angular/platform-browser";
import {LOCALE_ID, NgModule} from "@angular/core";
import {ReactiveFormsModule} from "@angular/forms";
import {HttpModule} from "@angular/http";
import {
  DateAdapter,
  MD_DATE_FORMATS,
  MdButtonModule,
  MdCheckboxModule,
  MdDatepickerModule,
  MdInputModule,
  MdMenuModule,
  MdSelectModule,
  MdToolbarModule
} from "@angular/material";
import {AppComponent} from "./app.component";
import {CalendarComponent} from "./calendar/calendar.component";
import {FlexLayoutModule} from "@angular/flex-layout";
import {RouterModule} from "@angular/router";
import {ClubsBroker} from "./services/club-broker.service";
import {ClubsResolver} from "./services/club-resolver.service";
import {Endpoint} from "./services/endpoint.service";
import {UserService} from "./services/user-service.service";
import {routes} from "./routes";
import {AngularFireModule} from "angularfire2";
import {AngularFireAuthModule} from "angularfire2/auth";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {MOMENT_DATE_FORMATS, MomentDateAdapter} from "./services/MomentDateAdapter";
import RootComponent from "./root/root.component";
import ClubSelectorComponent from "./club-selection/club-selection.component";
import LoginComponent from "./login/login.component";
import RegistrationComponent from "./registration/registration.component";
import WelcomeComponent from "./welcome/welcome.component";
import ReservationComponent from "./reservation/reservation.component";
import {UrlService} from "./services/url.service";
import {ReservationResolver} from "./services/reservation-resolver.service";

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
    HttpModule,
    MdButtonModule, MdCheckboxModule, MdDatepickerModule, MdInputModule, MdMenuModule, MdSelectModule, MdToolbarModule,
    RouterModule.forRoot(routes)
  ],
  declarations: [
    AppComponent, RootComponent, ClubSelectorComponent, CalendarComponent, LoginComponent,
    ReservationComponent, RegistrationComponent, WelcomeComponent],
  bootstrap: [AppComponent],
  providers: [
    {provide: LOCALE_ID, useValue: window.navigator.language},
    ClubsResolver,
    ClubsBroker,
    Endpoint,
    ReservationResolver,
    UrlService,
    UserService,
    {provide: DateAdapter, useClass: MomentDateAdapter},
    {provide: MD_DATE_FORMATS, useValue: MOMENT_DATE_FORMATS}
  ]
})
export class AppModule { }
