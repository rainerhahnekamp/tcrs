import {Reservation} from '../models/Reservation';
import {UserInfo} from '../services/user-service.service';

export interface AppState {
  currentReservation: Reservation;
  user: UserInfo;
}

export interface State {
  app: AppState;
}

export const initialState: AppState  = {
  currentReservation: null,
  user: {
    isLoggedIn: false,
    name: ''
  }
};
