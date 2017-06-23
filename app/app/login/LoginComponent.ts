import {Component, OnInit} from "@angular/core";
import {LoginProvider, UserService} from "../services/UserService";
import {Router} from "@angular/router";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";

interface LoginData {
  username: string,
  password: string
}

@Component({
  templateUrl: "login.html",
  styleUrls: ['./LoginComponent.sass']
})
export default class LoginComponent implements OnInit {
  public username: string;
  formGroup: FormGroup;
  public isLoggedIn: boolean = false;
  public defaultValue = LoginProvider.DEFAULT;
  public googleValue = LoginProvider.GOOGLE;
  public facebookValue = LoginProvider.FACEBOOK;

  constructor(
    private userService: UserService, private router: Router,
    private formBuilder: FormBuilder) {
  }

  ngOnInit(): void {
    this.formGroup = this.formBuilder.group({
      email: ["", Validators.email],
      password: ["", Validators.required]
    });
  }

  loginGoogle() {
    this.userService.loginThirdParty(LoginProvider.GOOGLE);
  }

  loginFacebook() {
    this.userService.loginThirdParty(LoginProvider.FACEBOOK)
  }

  onSubmit() {
    if (this.formGroup.valid) {
      const formData = this.formGroup.value;
      this.userService.login(formData.email, formData.password);
    }
  }
}
