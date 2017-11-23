import {Endpoint} from './endpoint.service';
import {Injectable} from '@angular/core';
import * as firebase from 'firebase/app';
import 'firebase/auth';
import {AngularFireAuth} from 'angularfire2/auth';
import {Router} from '@angular/router';
import {AppState, State} from '../store/AppState';
import {Store} from '@ngrx/store';
import {LoginAction, Logout} from '../store/actions';
import AuthProvider = firebase.auth.AuthProvider;

/**
 * Main service method for fetching data about the current logged in user.
 *
 * If the user is anonymous in the first run, and in a proceeding one he has a value, we conclude
 * that he has logged in manually and are therefore directly redirecting to the welcome screen.
 */

export enum LoginProvider {
  DEFAULT, GOOGLE, FACEBOOK
}

export interface UserInfo {
  name: string;
  isLoggedIn: boolean;
}

@Injectable()
export class UserService {

  constructor(private endpoint: Endpoint, private angularFireAuth: AngularFireAuth,
              private router: Router, private store: Store<State>) {
    this.angularFireAuth.authState.subscribe(user => {
      if (user) {
        this.store.dispatch(new LoginAction({name: user.displayName, isLoggedIn: true}));
      } else {
        this.store.dispatch(new Logout());
      }
    });

    this.store.select(state => state.app.user)
      .subscribe(userInfo => {
        if (userInfo.isLoggedIn) {
          this.router.navigate(['/welcome']);
        } else {
          this.router.navigate(['']);
        }
      });
  }

  loginThirdParty(loginProvider: LoginProvider) {
    const provider = this.getLoginProvider(loginProvider);
    this.angularFireAuth.auth.signInWithPopup(provider);
  }

  login(email: string, password: string) {
    this.angularFireAuth.auth.signInWithEmailAndPassword(email, password);
  }

  logout() {
    return this.angularFireAuth.auth.signOut();
  }

  private getLoginProvider(loginProvider: LoginProvider): AuthProvider {
    let returner = null;
    switch (loginProvider) {
      case LoginProvider.DEFAULT:
        returner = new firebase.auth.EmailAuthProvider();
        return returner;
      case LoginProvider.GOOGLE:
        returner = new firebase.auth.GoogleAuthProvider();
        returner.addScope('https://www.googleapis.com/auth/contacts.readonly');
        return returner;
      case LoginProvider.FACEBOOK:
        returner = new firebase.auth.FacebookAuthProvider();
        returner.addScope('public_profile');
        return returner;
      default:
        throw new Error('invalid login provider: ' + loginProvider);
    }
  }
}
