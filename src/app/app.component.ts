import {Component, OnInit} from '@angular/core';
import {UserService} from './services/user-service.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.html',
  styleUrls: ['./app.sass']
})
export class AppComponent implements OnInit {
  public isLoggedIn = false;

  constructor(private userService: UserService, private router: Router) {
  }


  ngOnInit(): void {
    this.userService.getObservable().subscribe(
      userInfo => this.isLoggedIn = userInfo.isLoggedIn
    );
  }

  logout() {
    this.userService.logout().then(() => {
      this.router.navigate(['']);
    });
  }
}
