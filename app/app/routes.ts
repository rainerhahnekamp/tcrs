import {CalendarComponent} from "./calendar/calendar.component";
import {Routes} from "@angular/router";
import RootComponent from "./root/RootComponent";
import {ClubsResolver} from "./services/ClubsResolver";
import ClubSelectorComponent from "./clubSelection/ClubSelectionComponent";

export const routes: Routes = [
  {path: "club-selection", component: ClubSelectorComponent,
    resolve: {clubs: ClubsResolver}},
  {path: ":club", component: RootComponent, children: [
    {path: "calendar", component: CalendarComponent}
  ]},
  {path: "", redirectTo: "club-selection", pathMatch: "full"}
];


