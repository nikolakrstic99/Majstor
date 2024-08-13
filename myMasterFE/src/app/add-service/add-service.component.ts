import {Component, OnInit, ViewChild} from '@angular/core';
import {AxiosService} from "../services/axios.service";
import {
  MatSnackBar,
  MatSnackBarHorizontalPosition,
  MatSnackBarVerticalPosition
} from "@angular/material/snack-bar";
import {NgForm} from "@angular/forms";

@Component({
  selector: 'app-add-service',
  templateUrl: './add-service.component.html',
  styleUrls: ['./add-service.component.scss']
})
export class AddServiceComponent implements OnInit {

  constructor(
    private axiosService: AxiosService,
    private _snackBar: MatSnackBar
  ) { }
  @ViewChild('f') form?: NgForm;
  ngOnInit(): void {
  }

  horizontalPosition: MatSnackBarHorizontalPosition = 'center';
  verticalPosition: MatSnackBarVerticalPosition = 'top';
  openSnackBar(str:string) {
    this._snackBar.open(str, 'Okay', {
      horizontalPosition: this.horizontalPosition,
      verticalPosition: this.verticalPosition,
    });
  }
  l1Options = ['Option 1', 'Option 2', 'Option 3'];
  l1Selected = null;
  l2Selected = null;
  l2Options: any[] = ['Option 1', 'Option 2', 'Option 3'];
  images: string[] = [];
  imagesOk: boolean = false;
  userFile: File;
  onChangeL1Category(value: any) {
    this.l1Selected = value.target.value;
  }

  onChangeL2Category(value: any) {
    this.l2Selected = value.target.value;
  }

  onFileSelected(event) {
    //this.userFile = event.target.result;
    if (event.target.files && event.target.files[0]) {
      this.imagesOk = true;
      // if (event.target.files.length < 3 || event.target.files.length > 6) {
      //   this.imagesOk = false;
      //   this.openSnackBar('Please select 3-6 images');
      //   return;
      // }
      for (let i = 0; i < event.target.files.length; i++) {
        var reader = new FileReader();

        reader.onload = (event: any) => {
          console.log(event.target.result);
          this.images.push(event.target.result);
        };

        reader.readAsDataURL(event.target.files[i]);
      }
    }
  }

  onSubmit() {
    console.log(this.images[0]);
    this.axiosService.requestWithToken("POST", "api/v1/service", {
      l1Category: this.l1Selected,
      l2Category: this.l2Selected,
      description: this.form.value.details,
        files: this.images
      }
    ).then(response => {
      this.openSnackBar('Uluga je dodata');
    }).catch(error => {
      this.openSnackBar('Usluga nije dodata');
    });
  }

}
