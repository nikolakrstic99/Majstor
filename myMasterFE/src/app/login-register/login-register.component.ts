import {EventEmitter, Component, Output} from '@angular/core';
import {Router} from "@angular/router";
import {
  MatSnackBar,
  MatSnackBarHorizontalPosition,
  MatSnackBarVerticalPosition
} from "@angular/material/snack-bar";
import {AxiosService} from "../services/axios.service";

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

  constructor(private axiosService: AxiosService, private router: Router, private _snackBar: MatSnackBar) {
  }

  onLoginTab(): void {
    this.active = "login";
  }

  onRegisterTab(): void {
    this.active = "register";
  }

  horizontalPosition: MatSnackBarHorizontalPosition = 'center';
  verticalPosition: MatSnackBarVerticalPosition = 'top';
  openSnackBar(message: string) {
    this._snackBar.open(message, 'Okay', {
      horizontalPosition: this.horizontalPosition,
      verticalPosition: this.verticalPosition,
    });
  }

  onSubmitLogin(): void {
    this.axiosService.request("POST", "api/v1/login", {email: this.login, password: this.password}).then(
      response => {
        this.axiosService.setAuthToken(response.data.token);
        this.router.navigate(["/"]);
      }).catch(
      error => {
        this.openSnackBar("Sign in failed :(");
        this.axiosService.setAuthToken(null);
      }
    );
  }

  onSubmitRegister(): void {
    this.axiosService.request("POST", "api/v1/register", {
      firstName: this.firstName,
      lastName: this.lastName,
      email: this.login,
      password: this.password
    }).then(
      response => {
        this.axiosService.setAuthToken(response.data.token);
        this.openSnackBar("Successful registration");
      }).catch(
      error => {
        this.openSnackBar("Sign up failed :(");
        this.axiosService.setAuthToken(null);
      }
    );
  }

}
