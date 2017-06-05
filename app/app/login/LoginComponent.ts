import {Component, OnInit} from "@angular/core";
import {LoginProvider, UserService} from "../services/UserService";
import {Router} from "@angular/router";
import {AngularFireAuth} from "angularfire2/auth";

@Component({
  templateUrl: "login.html",
  styleUrls: ['./LoginComponent.sass']

})
export default class LoginComponent implements OnInit {
  public username: string;
  public isLoggedIn: boolean = false;
  public defaultValue = LoginProvider.DEFAULT;
  public googleValue = LoginProvider.GOOGLE;
  public facebookValue = LoginProvider.FACEBOOK;

  constructor(
    private userService: UserService, private router: Router,
    private angularFireAuth: AngularFireAuth) {
  }

  ngOnInit(): void {
  }

  loginGoogle() {
    this.userService.login(LoginProvider.GOOGLE);
  }

  loginFacebook() {
    this.userService.login(LoginProvider.FACEBOOK)
  }
}
