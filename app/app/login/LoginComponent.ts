import {Component, OnInit} from "@angular/core";
import {UserService} from "../services/UserService";
import {Router} from "@angular/router";

@Component({
  templateUrl: "login.html",
  selector: "login",
  styleUrls: ['./LoginComponent.sass']

})
export default class LoginComponent implements OnInit {
  username: String;
  constructor(private userService: UserService, private router: Router) {}

  ngOnInit(): void {
    this.userService.getUser().subscribe((user: any) => {
      if (user) {
        this.username = user.userAuthentication.details.name;
      }
      else {
        this.username = "";
      }
    });
  }

  logout() {
    this.userService.logout().subscribe(() => {
      this.router.navigate(["/"]);
    })
  }
}
