import {Component, OnInit, ViewChild} from '@angular/core';
import {NgForm} from "@angular/forms";
import {AxiosService} from "../../services/axios.service";
import {UtilsService} from "../../utils.service";

@Component({
  selector: 'app-add-blog',
  providers: [],
  templateUrl: './add-blog.component.html',
  styleUrls: ['./add-blog.component.scss']
})
export class AddBlogComponent implements OnInit {

  constructor(
    private axiosService: AxiosService,
    private utils: UtilsService
  ) { }
  @ViewChild('f') form?: NgForm;
  ngOnInit(): void {}
  images: string[] = [];
  imagesOk: boolean = false;
  userFile: File;
  onFileSelected(event) {
    if (event.target.files && event.target.files[0]) {
      this.imagesOk = true;
      for (let i = 0; i < event.target.files.length; i++) {
        var reader = new FileReader();
        reader.onload = (event: any) => {
          this.images.push(event.target.result);
        };
        reader.readAsDataURL(event.target.files[i]);
      }
    }
  }

  onSubmit() {
    this.axiosService.requestWithToken("POST", "api/v1/blog", {
        heading: this.form.value.heading,
        subHeading: this.form.value.subHeading,
        details: this.form.value.details,
        files: this.images
      }
    ).then(response => {
      this.utils.openSnackBar('Blog je dodat');
    }).catch(error => {
      this.utils.openSnackBar('Blog nije dodat');
      this.images = [];
    });
  }

}
