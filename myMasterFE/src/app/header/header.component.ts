import { Component, OnInit } from '@angular/core';
import {User} from "../models/user";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {

  constructor() { }

  login: boolean;

  user: User = null;
  ngOnInit(): void {
  }

  getLogIn() {
    return this.login;
  }

  check() {
    this.user = JSON.parse(sessionStorage.getItem("user"));
    if (this.user == null) {
      this.login = true;
    }
  }
  isMaster() {
    this.user = JSON.parse(sessionStorage.getItem("user"));
    if (this.user) {
      return this.user.type == 2;
    } else return false;
  }

  logout() {

  }

}
