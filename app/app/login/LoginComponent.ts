import {Component, OnInit} from "@angular/core";
import {UserService} from "../services/UserService";

@Component({
  templateUrl: "login.html",
  selector: "login"
})
export default class LoginComponent implements OnInit {
  user: any;
  constructor(private userService: UserService) {}

  ngOnInit(): void {
    this.userService.getUser().subscribe((data) => {
      this.user = data;
    });
  }
}
