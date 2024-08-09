import {Component, OnInit, ViewChild} from '@angular/core';
import {
  MatSnackBar,
  MatSnackBarHorizontalPosition,
  MatSnackBarVerticalPosition
} from "@angular/material/snack-bar";
import {NgForm} from "@angular/forms";
import {AxiosService} from "../../services/axios.service";

@Component({
  selector: 'app-add-blog',
  providers: [],
  templateUrl: './add-blog.component.html',
  styleUrls: ['./add-blog.component.scss']
})
export class AddBlogComponent implements OnInit {

  constructor(
    private axiosService: AxiosService,
    private _snackBar: MatSnackBar
  ) { }
  @ViewChild('f') form?: NgForm;
  ngOnInit(): void {}

  horizontalPosition: MatSnackBarHorizontalPosition = 'center';
  verticalPosition: MatSnackBarVerticalPosition = 'top';
  openSnackBar(str:string) {
    this._snackBar.open(str, 'Okay', {
      horizontalPosition: this.horizontalPosition,
      verticalPosition: this.verticalPosition,
    });
  }
  images: string[] = [];
  imagesOk: boolean = false;
  userFile: File;
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
    this.axiosService.request("POST", "api/v1/blog", {
        heading: this.form.value.heading,
        subHeading: this.form.value.subHeading,
        details: this.form.value.details,
        files: this.images
      }
    ).then(response => {
      this.openSnackBar('Blog added');
    }).catch(error => {
      this.openSnackBar('Blog not added');
    });
  }

}
