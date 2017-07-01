import {Endpoint} from './endpoint.service';
import {Injectable} from '@angular/core';
import * as firebase from 'firebase/app';
import 'firebase/auth';
import {Observable} from 'rxjs/Observable';
import {AngularFireAuth} from 'angularfire2/auth';
import {Router} from '@angular/router';
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
  private observable: Observable<UserInfo>;
  private isUserInfoAvailable = false;
  private user: UserInfo;

  constructor(private endpoint: Endpoint, private angularFireAuth: AngularFireAuth,
              private router: Router) {
    this.observable = new Observable<UserInfo>(observable => {
      this.angularFireAuth.authState.subscribe(user => {
        if (user) {
          this.user = {name: user.displayName, isLoggedIn: true};
        } else {
          this.user = {name: '', isLoggedIn: false};
        }
        observable.next(this.user);

        if (this.isUserInfoAvailable && this.user.isLoggedIn) {
          this.router.navigate(['/welcome']);
        }
        this.isUserInfoAvailable = true;
      });
    });
  }

  getUser(): UserInfo {
    return this.user;
  }

  getObservable() {
    return this.observable;
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
