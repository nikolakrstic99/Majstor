import { Component, OnInit } from '@angular/core';
import {AxiosService} from "../services/axios.service";

@Component({
  selector: 'app-my-profile',
  templateUrl: './my-profile.component.html',
  styleUrls: ['./my-profile.component.scss']
})
export class MyProfileComponent implements OnInit{

  constructor(private axiosService: AxiosService) {
  }

  ngOnInit(): void {
    this.axiosService.requestWithToken('GET', 'api/v1/user', null)
    .then(response => {this.user = response.data
    console.log(this.user)}).catch((error) => {});
  }
  user = null;
  firstName = 'John';
  lastName = 'Doe';
  mobilePhone = '123-456-7890';
  averageReview = 4.5;
  stars = [1, 2, 3, 4, 5];
  comments = [
    { text: 'Great service!' },
    { text: 'Very professional.' },
    { text: 'Highly recommended.' },
    { text: 'Will use again.' },
    { text: 'Satisfied with the service.' }
  ];
  services = [
    {
      title: 'Web Development',
      images: ['assets/webdev1.jpg', 'assets/webdev2.jpg', 'assets/webdev3.jpg'],
      description: 'High-quality web development services with a focus on responsive design and user experience.'
    },
    {
      title: 'Graphic Design',
      images: ['assets/design1.jpg', 'assets/design2.jpg', 'assets/design3.jpg'],
      description: 'Creative and modern graphic design services, including logos, branding, and print materials.'
    }
  ];

  // Initialize currentImageIndex array
  currentImageIndex: number[] = this.services.map(() => 0);

  readMoreComments() {
    // Implement functionality to show more comments
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
