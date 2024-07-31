import {Component, OnInit, ViewChild} from '@angular/core';
import {
  MatSnackBar,
  MatSnackBarHorizontalPosition,
  MatSnackBarVerticalPosition
} from "@angular/material/snack-bar";
import {NgForm} from "@angular/forms";
import {Router} from "@angular/router";
import {UserService} from "../services/user.service";
import {AxiosService} from "../services/axios.service";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  @ViewChild('f') signinForm?: NgForm;
  constructor(private router: Router, private userService: UserService, private _snackBar: MatSnackBar,
              private axiosService: AxiosService) {

  }
  data: string;
  ngOnInit(): void {
    this.axiosService.request("GET", "/test", null).then((response) => {
      this.data = response.data;
    });
    sessionStorage.removeItem("user");
  }

  horizontalPosition: MatSnackBarHorizontalPosition = 'center';
  verticalPosition: MatSnackBarVerticalPosition = 'top';
  openSnackBar() {
    this._snackBar.open('Bad data :(', 'Okay', {
      horizontalPosition: this.horizontalPosition,
      verticalPosition: this.verticalPosition,
    });
  }

  onSubmit() {
    var email = this.signinForm?.value.email;
    var password = this.signinForm?.value.password;
    this.axiosService.request("POST", "/login", {
      email: email,
      password: password
    })
    // this.userService.login(username, password).subscribe((user: User) => {
    //   if (user) {
    //     sessionStorage.setItem("user", JSON.stringify(user));
    //     //HeaderComponent.check();
    //     this.router.navigate(['']);
    //   }
    //   else
    //     this.openSnackBar();
    // });

  }

}
