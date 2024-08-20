import {Component, EventEmitter, Output, ViewChild} from '@angular/core';
import {Router} from "@angular/router";
import {AxiosService} from "../services/axios.service";
import {UtilsService} from "../utils.service";
import {FormGroup, NgForm, Validators} from "@angular/forms";

@Component({
  selector: 'app-login-register',
  templateUrl: './login-register.component.html',
  styleUrls: ['./login-register.component.scss']
})
export class LoginRegisterComponent {

  @Output() onSubmitLoginEvent = new EventEmitter();
  @Output() onSubmitRegisterEvent = new EventEmitter();

  active: string = "login";
  firstName: string = "";
  lastName: string = "";
  login: string = "";
  password: string = "";
  phone: string = "";
  location: string = "";

  constructor(private axiosService: AxiosService, private router: Router, private utils: UtilsService) {
  }

  onLoginTab(): void {
    this.active = "login";
  }

  onRegisterTab(): void {
    this.active = "register";
  }

  onSubmitLogin(): void {
    this.axiosService.request("POST", "api/v1/login", {
      email: this.login,
      password: this.password
    }).then(
      response => {
        this.axiosService.setAuthToken(response.data.token);
        this.router.navigate(["/"]);
      }).catch(
      error => {
        this.utils.openSnackBar("Sign in failed :(");
        this.axiosService.setAuthToken(null);
      }
    );
  }

  onSubmitRegister(): void {
    this.axiosService.request("POST", "api/v1/register", {
      firstName: this.firstName,
      lastName: this.lastName,
      email: this.login,
      password: this.password,
      phone: this.phone,
      location: this.location
    }).then(
      response => {
        this.axiosService.setAuthToken(response.data.token);
        this.utils.openSnackBar("Successful registration");
      }).catch(
      error => {
        this.utils.openSnackBar("Sign up failed :(");
        this.axiosService.setAuthToken(null);
      }
    );
  }
}
