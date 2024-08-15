import {Component, OnInit} from '@angular/core';
import {AxiosService} from "../services/axios.service";
import {UtilsService} from "../utils.service";

@Component({
  selector: 'app-contact',
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.scss']
})
export class ContactComponent implements OnInit {

  constructor(private axiosService: AxiosService, private utils: UtilsService) {
  }

  firstLastName: string = "";
  email: string = "";
  message: string = "";

  ngOnInit(): void {
  }

  onSubmit(): void {
    this.axiosService.request("POST", "/sendMail",
      {
        firstLastName: this.firstLastName,
        email: this.email,
        message: this.message
      }).then(
      response => {
        this.utils.openSnackBar("Poruka poslata!");
      }).catch(
      error => {
        this.utils.openSnackBar("Poruka nije poslata :(");
      }
    );
  }

}
