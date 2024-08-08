import {Component, OnInit} from '@angular/core';
import {AxiosService} from "../services/axios.service";
import {
  MatSnackBar,
  MatSnackBarHorizontalPosition,
  MatSnackBarVerticalPosition
} from "@angular/material/snack-bar";

@Component({
  selector: 'app-contact',
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.scss']
})
export class ContactComponent implements OnInit {

  constructor(private axiosService: AxiosService, private _snackBar: MatSnackBar) {
  }

  firstLastName: string = "";
  email: string = "";
  message: string = "";

  ngOnInit(): void {
  }

  horizontalPosition: MatSnackBarHorizontalPosition = 'center';
  verticalPosition: MatSnackBarVerticalPosition = 'top';
  openSnackBar(message: string) {
    this._snackBar.open(message, 'Okay', {
      horizontalPosition: this.horizontalPosition,
      verticalPosition: this.verticalPosition,
    });
  }

  onSubmit(): void {
    this.axiosService.request("POST", "/sendMail",
      {
        firstLastName: this.firstLastName,
        email: this.email,
        message: this.message
      }).then(
      response => {
        this.openSnackBar("Message sent!");
      }).catch(
      error => {
        this.openSnackBar("Message failed to send :(");
      }
    );
  }

}
