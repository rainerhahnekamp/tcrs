import {Component} from "@angular/core";
import {UserService} from "../services/UserService";
import {Router} from "@angular/router";

@Component({
  selector: 'app',
  templateUrl: './app.html',
  styleUrls: ['./app.sass']
})
export class AppComponent {
  public isLoggedIn: boolean = false;

  constructor(private userService: UserService, private router: Router) {
    this.userService.getObservable().subscribe(
      userInfo => this.isLoggedIn = userInfo.isLoggedIn
    );
  }

  logout() {
    this.userService.logout().then(() => this.router.navigate([""]));
  }
}
