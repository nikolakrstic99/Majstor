import {Component, OnInit, ViewChild} from '@angular/core';
import {AxiosService} from "../services/axios.service";
import {NgForm} from "@angular/forms";
import {UtilsService} from "../utils.service";

@Component({
  selector: 'app-add-service',
  templateUrl: './add-service.component.html',
  styleUrls: ['./add-service.component.scss']
})
export class AddServiceComponent implements OnInit {

  constructor(
    private axiosService: AxiosService,
    private utils: UtilsService
  ) {
  }

  @ViewChild('f') form?: NgForm;

  ngOnInit(): void {
    this.axiosService.request('GET', 'api/v1/service/l1Categories', null).then(response => {
      this.l1Options = response.data;
    }).catch(() => {
      this.utils.openSnackBar("Greška prilikom dohvatanja l1 kategorija :(")
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
    this.axiosService.request("GET", `api/v1/service/l2Categories/${this.l1Selected}`, null).then(response => {
      this.l2Options = response.data;
    }).catch(() => {
      this.utils.openSnackBar("Greška prilikom dohvatanja l2 kategorija :(")
    });
  }

  onChangeL2Category(value: any) {
    this.l2Selected = value.target.value;
  }

  onFileSelected(event) {
    if (event.target.files && event.target.files[0]) {
      this.imagesOk = true;
      for (let i = 0; i < event.target.files.length; i++) {
        const reader = new FileReader();

        reader.onload = (event: any) => {
          this.images.push(event.target.result);
        };

        reader.readAsDataURL(event.target.files[i]);
      }
    }
  }

  onSubmit() {
    this.axiosService.requestWithToken("POST", "api/v1/service", {
        l1Category: this.l1Selected,
        l2Category: this.l2Selected,
        description: this.form.value.details,
        files: this.images
      }
    ).then(response => {
      this.utils.openSnackBar('Usluga je dodata');
    }).catch(error => {
      this.images = [];
      this.utils.openSnackBar(error.response.data.message);
    });
  }

}
