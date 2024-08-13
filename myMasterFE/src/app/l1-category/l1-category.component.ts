import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {AxiosService} from "../services/axios.service";
import {
  MatSnackBar,
  MatSnackBarHorizontalPosition,
  MatSnackBarVerticalPosition
} from "@angular/material/snack-bar";

@Component({
  selector: 'app-l1-category',
  templateUrl: './l1-category.component.html',
  styleUrls: ['./l1-category.component.scss']
})
export class L1CategoryComponent implements OnInit {
  l1Category: string;

  constructor(private route: ActivatedRoute, private axiosService: AxiosService, private _snackBar: MatSnackBar) {
  }

  horizontalPosition: MatSnackBarHorizontalPosition = 'center';
  verticalPosition: MatSnackBarVerticalPosition = 'top';

  openSnackBar(message: string) {
    this._snackBar.open(message, 'Okay', {
      horizontalPosition: this.horizontalPosition,
      verticalPosition: this.verticalPosition,
    });
  }

  l2Categories = [];

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.l1Category = params['l1category'];
    });
    this.axiosService.request('GET', `api/v1/service/l2Categories/${this.l1Category}`, null).then(
      response => {
        this.l2Categories = response.data;
      }).catch(
      error => {
        this.openSnackBar("Error while fetching l2 categories :(");
      }
    );
  }

}
