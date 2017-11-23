import {Component, OnInit} from '@angular/core';
import {State} from '../store/AppState';
import {Store} from '@ngrx/store';

@Component({
  template: 'Willkommen {{username}}'
})
export default class WelcomeComponent implements OnInit {
  public username: string;
  constructor(private store: Store<State>) {}

  ngOnInit(): void {
    this.store.select(store => store.app.user).subscribe(user => this.username = user.name);
  }
}
