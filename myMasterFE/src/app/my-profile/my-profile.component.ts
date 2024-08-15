import { Component, OnInit } from '@angular/core';
import {AxiosService} from "../services/axios.service";
import {UtilsService} from "../utils.service";

@Component({
  selector: 'app-my-profile',
  templateUrl: './my-profile.component.html',
  styleUrls: ['./my-profile.component.scss']
})
export class MyProfileComponent implements OnInit{

  constructor(private axiosService: AxiosService, private utils: UtilsService) {
  }

  ngOnInit(): void {
    this.axiosService.requestWithToken('GET', 'api/v1/user', null)
    .then(response => {
      this.user = response.data
      this.axiosService.requestWithToken('GET', `api/v1/service/user/${this.user.id}`, null).then(response => {
        this.services = response.data;
        this.services.forEach(service => {
          this.axiosService.request('GET', `api/v1/service/images/${service.id}`, null).then(response => {
            const images: string[] = [];
            const activeSlide: boolean[] = [];
            response.data.forEach((image: any) => {
              images.push(image['imageData']);
              activeSlide.push(false);
            });
            activeSlide[0] = true;
            this.serviceActiveSlideMap.set(service["id"], activeSlide);
            this.serviceImageMap.set(service["id"], images);

            this.axiosService.requestWithToken('GET', `api/v1/review/ratedUser/${this.user['id']}`, null).then(response => {
              this.comments = response.data;
              this.calculateAverageRating()
            }).catch(error => {});
          }).catch(
            () => {
              this.utils.openSnackBar("Greška prilikom dohvatanja slika :(");
            }
          );
        });
      }).catch(error => {});

    }).catch((error) => {});



  }
  user = null;
  firstName = 'John';
  lastName = 'Doe';
  mobilePhone = '123-456-7890';
  averageReview  = 0.00;
  stars = [1, 2, 3, 4, 5];
  comments = [];
  services = [];
  serviceImageMap = new Map<string, string[]> ();
  serviceActiveSlideMap = new Map<string, boolean[]>();

  // Initialize currentImageIndex array
  currentImageIndex: number[] = this.services.map(() => 0);

  readMore = false;
  readMoreComments(flag: boolean) {
    this.readMore = flag;
  }

  calculateAverageRating() {
    let sum = 0.0;
    this.comments.forEach(comment => {
      sum += comment.rating;
    });
    this.averageReview = sum / this.comments.length;
    console.log(this.averageReview)
  }

  imageClick(serviceId: string, step: number): void {
    let activeSlide = this.serviceActiveSlideMap.get(serviceId);
    let activeIndex = activeSlide.findIndex(value => value);
    let nextIndex = activeIndex + step;
    if(nextIndex < 0)
      nextIndex = activeSlide.length - 1;
    else if(nextIndex >= activeSlide.length)
      nextIndex = 0;
    activeSlide[activeIndex] = false;
    activeSlide[nextIndex] = true;
    this.serviceActiveSlideMap.set(serviceId, activeSlide);
  }

  prevImage(serviceIndex: number) {
    if (this.currentImageIndex[serviceIndex] > 0) {
      this.currentImageIndex[serviceIndex]--;
    } else {
      this.currentImageIndex[serviceIndex] = this.services[serviceIndex].images.length - 1;
    }
  }

  nextImage(serviceIndex: number) {
    if (this.currentImageIndex[serviceIndex] < this.services[serviceIndex].images.length - 1) {
      this.currentImageIndex[serviceIndex]++;
    } else {
      this.currentImageIndex[serviceIndex] = 0;
    }
  }
}
