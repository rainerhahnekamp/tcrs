import {Endpoint} from "./Endpoint";
import {Injectable} from "@angular/core";
import * as firebase from "firebase/app";
import "firebase/auth";
/**
 * main service method for fetching data about the current logged in user.
 */

@Injectable()
export class UserService {
  constructor(private endpoint: Endpoint) {
  }

  getUser() {
    return this.endpoint.get("user");
  }

  login() {
    let provider = new firebase.auth.GoogleAuthProvider();
    provider.addScope("https://www.googleapis.com/auth/contacts.readonly");
    firebase.auth().signInWithPopup(provider).then((result) => {
      let token = result.credentials.accessToken;
      let user = result.user;
    });

    firebase.auth().onAuthStateChanged((user) => {
      console.log(user);
    })
  }

  logout() {
    return this.endpoint.post("logout");
  }
}
