import { Component, OnInit } from '@angular/core';
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
  userId: number;
  ngOnInit(): void {
    this.login = this.isLoggedIn();
    this.userId = this.getUserId();
  }

  isLoggedIn() {
    return this.axiosService.getAuthToken() !== null;
  }

  getUserId() {
    if(this.isLoggedIn()){
      return this.axiosService.getUserId();
    } else {
      return -1;
    }
  }

  logOut() {
    this.axiosService.setAuthToken(null);
    this.router.navigate([('')]);
  }

  logout() {
    this.axiosService.setAuthToken(null);
    this.router.navigate(['']);
  }

}
