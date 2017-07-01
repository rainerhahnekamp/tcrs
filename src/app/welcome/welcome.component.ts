import {Component, OnInit} from '@angular/core';
import {UserService} from '../services/user-service.service';

@Component({
  template: 'Willkommen {{username}}'
})
export default class WelcomeComponent implements OnInit {
  public username: string;
  constructor(private userService: UserService) { }

  ngOnInit(): void {
    this.username = this.userService.getUser().name;
  }
}
