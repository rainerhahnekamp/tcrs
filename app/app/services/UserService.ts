import {Endpoint} from "./Endpoint";
import {Injectable} from "@angular/core";
import * as firebase from "firebase/app";
import "firebase/auth";
import {Observable} from "rxjs/Observable";
import {UserInfo} from "firebase/app";
import {AngularFireAuth} from "angularfire2/auth";
/**
 * main service method for fetching data about the current logged in user.
 */

@Injectable()
export class UserService {
  private observable: Observable<UserInfo>;

  constructor(private endpoint: Endpoint, private angularFireAuth: AngularFireAuth) {
    this.observable = new Observable<UserInfo>(observable => {
      this.angularFireAuth.authState.subscribe(user => observable.next(user));
    });
  }

  getUser() {
    return this.endpoint.get("user");
  }

  getObservable() {
    return this.observable;
  }

  login() {
    let provider = new firebase.auth.GoogleAuthProvider();
    provider.addScope("https://www.googleapis.com/auth/contacts.readonly");
    this.angularFireAuth.auth.signInWithPopup(provider);
  }

  logout() {
    this.angularFireAuth.auth.signOut();
  }
}
