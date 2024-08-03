import { Component, OnInit } from '@angular/core';
import {User} from "../models/user";
import {AxiosService} from "../services/axios.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {

  constructor(private axiosService: AxiosService, private router: Router) { }

  login: boolean;

  user: User = null;
  ngOnInit(): void {
  }

  isLoggedIn() {
    return this.axiosService.getAuthToken() !== null;
  }

  logOut() {
    this.axiosService.setAuthToken(null);
    this.router.navigate([('')]);
  }

  check() {
    this.user = JSON.parse(sessionStorage.getItem("user"));
    if (this.user == null) {
      this.login = true;
    }
  }

  logout() {

  }

}
