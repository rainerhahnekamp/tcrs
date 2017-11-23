import {AppState, initialState} from './AppState';
import * as Actions from './actions';
import {LOGIN, LoginAction} from './actions';

type Action = Actions.ALL;

export function appReducer(state: AppState = initialState, action: Action): AppState {
  switch (action.type) {
    case Actions.BOOTSTRAP:
      return state;
    case LOGIN:
      return {currentReservation: state.currentReservation, user: (<LoginAction>action).payload};
    default:
      return state;
  }
}
