import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import {AxiosService} from "../../services/axios.service";

@Component({
  selector: 'app-blog-detail',
  templateUrl: './blog-detail.component.html',
  styleUrls: ['./blog-detail.component.scss']
})
export class BlogDetailComponent implements OnInit {

  id: number | null = null;
  blogDetail: null;
  images = [];
  activeSlide: boolean[] = [true, false, false];
  activeIndex = 0;
  isAdmin: boolean;
  author: string;

  constructor(private activatedRouter: ActivatedRoute, private axiosService: AxiosService) {
    this.id = +this.activatedRouter.snapshot.paramMap.get('id')!;

  }

  ngOnInit(): void {
    this.isAdmin = this.axiosService.isAdmin();
    this.axiosService.request('GET', `api/v1/blog/${this.id}`, null).then(response => {
      this.blogDetail = response.data;
      // @ts-ignore
      this.author = this.blogDetail['user']['firstName'] + ' ' + this.blogDetail['user']['lastName']
      this.axiosService.request('GET', `api/v1/blog/images/${this.id}`, null).then(response => {
        this.images = response.data;
      }).catch(error => {});
    }).catch(error => {});
  }

  imageClick(step: number): void {
    this.activeSlide[this.activeIndex] = false;
    this.activeIndex = (this.activeIndex + step + this.activeSlide.length) % this.activeSlide.length;
    this.activeSlide[this.activeIndex] = true;
  }

  delete(): void {
    // Implement delete functionality
  }
}
