import {BrowserModule} from "@angular/platform-browser";
import {LOCALE_ID, NgModule} from "@angular/core";
import {FormsModule} from "@angular/forms";
import {HttpModule} from "@angular/http";
import {MaterialModule} from "@angular/material";
import {AppComponent} from "./app/app";
import {CalendarNavigatorComponent} from "./calendar-navigator/calendar-navigator.component";
import {CalendarComponent} from "./calendar/calendar.component";
import {FlexLayoutModule} from "@angular/flex-layout";
import {RouterModule} from "@angular/router";
import RootComponent from "./root/RootComponent";
import ClubSelectorComponent from "./clubSelection/ClubSelectionComponent";
import {ClubsBroker} from "./services/ClubsBroker";
import {ClubsResolver} from "./services/ClubsResolver";
import {Endpoint} from "./services/Endpoint";
import LoginComponent from "./login/LoginComponent";
import {UserService} from "./services/UserService";
import {routes} from "./routes";
import {AngularFireModule} from "angularfire2";
import {AngularFireAuthModule} from "angularfire2/auth";

@NgModule({
  imports: [
    BrowserModule,
    AngularFireModule.initializeApp({
      apiKey: "AIzaSyDEKMK7Rm1Tp8DELVWOSzGNC7s1o23jS80",
      authDomain: "tcrs-dev.firebaseapp.com"
    }),
    AngularFireAuthModule,
    FlexLayoutModule,
    FormsModule,
    HttpModule,
    MaterialModule.forRoot(),
    RouterModule.forRoot(routes)
  ],
  declarations: [
    AppComponent, RootComponent, ClubSelectorComponent, CalendarNavigatorComponent,
    CalendarComponent, LoginComponent],
  bootstrap: [AppComponent],
  providers: [
    {provide: LOCALE_ID, useValue: window.navigator.language},
    ClubsResolver,
    ClubsBroker,
    Endpoint,
    UserService
  ]
})
export class AppModule { }
