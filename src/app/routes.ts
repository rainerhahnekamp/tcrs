import {CalendarComponent} from './calendar/calendar.component';
import {Routes} from '@angular/router';
import {ClubsResolver} from './services/club-resolver.service';
import LoginComponent from './login/login.component';
import WelcomeComponent from './welcome/welcome.component';
import ClubSelectorComponent from './club-selection/club-selection.component';
import RegistrationComponent from './registration/registration.component';
import ReservationComponent from './reservation/reservation.component';
import RootComponent from './root/root.component';
import {ReservationResolver} from './services/reservation-resolver.service';
import ReservationFinishedComponent from './reservation-finished/reservation-finished.component';

export const routes: Routes = [
  {path: 'club-selection', component: ClubSelectorComponent,
    resolve: {clubs: ClubsResolver}},
  {path: 'login', component: LoginComponent},
  {path: 'registration', component: RegistrationComponent},
  {path: 'welcome', component: WelcomeComponent},
  {path: ':club', component: RootComponent, children: [
    {path: 'calendar', component: CalendarComponent},
    {
      path: 'reservation/:day/:hour',
      component: ReservationComponent,
      resolve: {courtAvailability: ReservationResolver}
    }, {
      path: 'reservation-finished',
      component: ReservationFinishedComponent
    }
  ]},
  {path: '', redirectTo: 'club-selection', pathMatch: 'full'}
];
