import {BrowserModule} from "@angular/platform-browser";
import {LOCALE_ID, NgModule} from "@angular/core";
import {FormsModule} from "@angular/forms";
import {HttpModule} from "@angular/http";
import {DateAdapter, MaterialModule, MD_DATE_FORMATS} from "@angular/material";
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
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {MOMENT_DATE_FORMATS, MomentDateAdapter} from "./services/MomentDateAdapter";
import WelcomeComponent from "./welcome/WelcomeComponent";

@NgModule({
  imports: [
    BrowserModule,
    AngularFireModule.initializeApp({
      apiKey: "AIzaSyDEKMK7Rm1Tp8DELVWOSzGNC7s1o23jS80",
      authDomain: "tcrs-dev.firebaseapp.com"
    }),
    AngularFireAuthModule,
    BrowserAnimationsModule,
    FlexLayoutModule,
    FormsModule,
    HttpModule,
    MaterialModule,
    RouterModule.forRoot(routes)
  ],
  declarations: [
    AppComponent, RootComponent, ClubSelectorComponent, CalendarNavigatorComponent,
    CalendarComponent, LoginComponent, WelcomeComponent],
  bootstrap: [AppComponent],
  providers: [
    {provide: LOCALE_ID, useValue: window.navigator.language},
    ClubsResolver,
    ClubsBroker,
    Endpoint,
    UserService,
    {provide: DateAdapter, useClass: MomentDateAdapter},
    {provide: MD_DATE_FORMATS, useValue: MOMENT_DATE_FORMATS}
  ]
})
export class AppModule { }
