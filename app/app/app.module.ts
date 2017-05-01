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
import routes from "./routes";
import RootComponent from "./root/RootComponent";
import ClubSelectorComponent from "./clubSelection/ClubSelectionComponent";
import {ClubsBroker} from "./services/ClubsBroker";
import {ClubsResolver} from "./services/ClubsResolver";
import {Endpoint} from "./services/Endpoint";
import LoginComponent from "./login/LoginComponent";
import {UserService} from "./services/UserService";

@NgModule({
  imports: [
    BrowserModule,
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
