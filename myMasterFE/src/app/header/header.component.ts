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
  ngOnInit(): void {
  }

  isLoggedIn() {
    return this.axiosService.getAuthToken() !== null;
  }

  logOut() {
    this.axiosService.setAuthToken(null);
    this.router.navigate([('')]);
  }

  logout() {

  }

}
