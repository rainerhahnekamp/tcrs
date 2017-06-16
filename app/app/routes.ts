import {CalendarComponent} from "./calendar/calendar.component";
import {Routes} from "@angular/router";
import RootComponent from "./root/RootComponent";
import {ClubsResolver} from "./services/ClubsResolver";
import ClubSelectorComponent from "./clubSelection/ClubSelectionComponent";
import LoginComponent from "./login/LoginComponent";
import WelcomeComponent from "./welcome/WelcomeComponent";
import RegistrationComponent from "./registration/RegistrationComponent";

export const routes: Routes = [
  {path: "club-selection", component: ClubSelectorComponent,
    resolve: {clubs: ClubsResolver}},
  {path: "login", component: LoginComponent},
  {path: "registration", component: RegistrationComponent},
  {path: "welcome", component: WelcomeComponent},
  {path: ":club", component: RootComponent, children: [
    {path: "calendar", component: CalendarComponent}
  ]},
  {path: "", redirectTo: "club-selection", pathMatch: "full"}
];

