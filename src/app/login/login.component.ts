import {Component, OnInit} from "@angular/core";
import {Router} from "@angular/router";
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {LoginProvider, UserService} from "../services/user-service.service";

interface LoginData {
  username: string;
  password: string;
}

@Component({
  templateUrl: 'login.component.html',
  styleUrls: ['./login.component.sass']
})
export default class LoginComponent implements OnInit {
  public username: string;
  public formGroup: FormGroup;
  public email: FormControl;
  public password: FormControl;

  constructor(
    private userService: UserService, private router: Router,
    private formBuilder: FormBuilder) {
  }

  ngOnInit(): void {
    this.email = this.formBuilder.control('', Validators.email);
    this.password = this.formBuilder.control('', Validators.required);
    this.formGroup = this.formBuilder.group({
      email: ['', Validators.email],
      password: ['', Validators.required]
    });
  }

  loginGoogle() {
    this.userService.loginThirdParty(LoginProvider.GOOGLE);
  }

  loginFacebook() {
    this.userService.loginThirdParty(LoginProvider.FACEBOOK);
  }

  onSubmit() {
    if (this.formGroup.valid) {
      const formData = this.formGroup.value;
      this.userService.login(formData.email, formData.password);
    }
  }
}
