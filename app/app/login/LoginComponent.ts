import {Component, OnInit} from "@angular/core";
import {UserService} from "../services/UserService";
import {Router} from "@angular/router";
import {AngularFireAuth} from "angularfire2/auth";

@Component({
  templateUrl: "login.html",
  selector: "login",
  styleUrls: ['./LoginComponent.sass']

})
export default class LoginComponent implements OnInit {
  public username: string;
  public isLoggedIn: boolean = false;

  constructor(
    private userService: UserService, private router: Router,
    private angularFireAuth: AngularFireAuth) {}

  ngOnInit(): void {
    this.userService.getObservable().subscribe(
      userInfo => {
        if (userInfo) {
          this.username = userInfo.displayName;
          this.isLoggedIn = true;
        }
        else {
          this.username = "";
          if (this.isLoggedIn) {
            this.router.navigate(["/"]);
          }
          this.isLoggedIn = false;
        }
      }
    );
  }

  login() {
    this.userService.login();
  }

  logout() {
    this.userService.logout();
  }
}
