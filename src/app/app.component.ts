import {Component, OnInit} from '@angular/core';
import {UserService} from './services/user-service.service';
import {Router} from '@angular/router';
import {Store} from '@ngrx/store';
import {State} from './store/AppState';

@Component({
  selector: 'app-root',
  templateUrl: './app.html',
  styleUrls: ['./app.sass']
})
export class AppComponent implements OnInit {
  public isLoggedIn = false;

  constructor(private userService: UserService, private store: Store<State>) {
  }


  ngOnInit(): void {
    this.store.select(state => state.app.user).subscribe(user => {
      this.isLoggedIn = user.isLoggedIn;
    });
  }

  logout() {
    this.userService.logout();
  }
}
