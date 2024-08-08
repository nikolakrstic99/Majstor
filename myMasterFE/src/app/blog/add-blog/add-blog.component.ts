import {Component, OnInit, ViewChild} from '@angular/core';
import {
  MatSnackBar,
  MatSnackBarHorizontalPosition,
  MatSnackBarVerticalPosition
} from "@angular/material/snack-bar";
import {NgForm} from "@angular/forms";
import {BlogServiceService} from "../../services/blog-service.service";

@Component({
  selector: 'app-add-blog',
  providers: [BlogServiceService],
  templateUrl: './add-blog.component.html',
  styleUrls: ['./add-blog.component.scss']
})
export class AddBlogComponent implements OnInit {

  constructor(
    private _snackBar: MatSnackBar,
    private blogService: BlogServiceService
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
  onFileSelected(event) {
    if (event.target.files && event.target.files[0]) {
      this.imagesOk = true;
      if (event.target.files.length < 3 || event.target.files.length > 6) {
        this.imagesOk = false;
        this.openSnackBar('Please select 3-6 images');
        return;
      }
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
    this.blogService.addBlog(
      this.form.value.heading,
      this.form.value.subHeading,
      this.form.value.details,
      this.images
    )
    .subscribe((resp) => {
      if ((resp['message'] = 'Blog added'))
        this.openSnackBar('Blog added');
      else
        this.openSnackBar('Blog not added');
    });
  }

}
