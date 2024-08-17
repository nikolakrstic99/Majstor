import {Component, Input, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {AxiosService} from "../services/axios.service";
import {UtilsService} from "../utils.service";

@Component({
  selector: 'app-add-review',
  templateUrl: './add-review.component.html',
  styleUrls: ['./add-review.component.scss']
})
export class AddReviewComponent implements OnInit {
  reviewForm: FormGroup;
  @Input() userId: number;

  constructor(private fb: FormBuilder, private axiosService: AxiosService, private utils: UtilsService) {
    this.reviewForm = this.fb.group({
      grade: ['', Validators.required],
      description: ['', Validators.required]
    });
  }

  onSubmit() {
    if (this.reviewForm.valid) {
      this.axiosService.requestWithToken("POST", "api/v1/review", {
        ratedUserId: this.userId,
        text: this.reviewForm.value.description,
        rating: this.reviewForm.value.grade
      }).then(response => {
        this.utils.openSnackBar('Ocenili ste ovog korisnika!');
      })
      .catch(error => {
        this.utils.openSnackBar(error.response.data.message);
      });
    }
  }

  ngOnInit(): void {
  }
}
