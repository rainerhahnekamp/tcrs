import {Action} from '@ngrx/store';
import {UserInfo} from '../services/user-service.service';

export const VIEWRESERVATION = 'VIEWRESERVATION';
export const BOOTSTRAP = 'BOOTSTRAP';
export const LOGIN = 'LOGIN';
export const LOGOUT = 'LOGOUT';

export class ViewReservation implements Action {
  readonly type = VIEWRESERVATION;
}

export class Bootstrap implements Action {
  readonly type = BOOTSTRAP;
}

export class LoginAction implements Action {
  readonly type = LOGIN;

  constructor(public payload: UserInfo) {}
}

export class Logout implements Action {
  readonly type = LOGOUT;
}

export type ALL = ViewReservation | Bootstrap | LoginAction | Logout;

