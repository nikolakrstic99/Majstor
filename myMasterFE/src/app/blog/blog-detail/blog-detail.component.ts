import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import {AxiosService} from "../../services/axios.service";
import {UtilsService} from "../../utils.service";

@Component({
  selector: 'app-blog-detail',
  templateUrl: './blog-detail.component.html',
  styleUrls: ['./blog-detail.component.scss']
})
export class BlogDetailComponent implements OnInit {

  id: number | null = null;
  blogDetail: null;
  images = [];
  activeSlide = []
  activeIndex = 0;
  isAdmin: boolean;
  author: string;
  userId: number;
  authorId: number;

  constructor(private activatedRouter: ActivatedRoute, private axiosService: AxiosService, private utils: UtilsService) {
    this.id = +this.activatedRouter.snapshot.paramMap.get('id')!;

  }

  ngOnInit(): void {
    this.userId = this.axiosService.getUserId();
    this.isAdmin = this.axiosService.isAdmin();
    this.axiosService.request('GET', `api/v1/blog/${this.id}`, null).then(response => {
      this.blogDetail = response.data;
      // @ts-ignore
      this.author = this.blogDetail['user']['firstName'] + ' ' + this.blogDetail['user']['lastName']
      // @ts-ignore
      this.authorId = this.blogDetail['user']['id'];
      this.axiosService.request('GET', `api/v1/blog/images/${this.id}`, null).then(response => {
        this.images = response.data;
        this.activeSlide = Array(this.images.length).fill(false);
        this.activeSlide[0] = true;
      }).catch(error => {});
    }).catch(error => {});
  }

  imageClick(step: number): void {
    this.activeSlide[this.activeIndex] = false;
    this.activeIndex = (this.activeIndex + step + this.activeSlide.length) % this.activeSlide.length;
    this.activeSlide[this.activeIndex] = true;
  }

  delete(): void {
    this.axiosService.request('DELETE', `api/v1/blog/${this.id}`, null).then(response => {
      this.utils.openSnackBar('Blog je obrisan');
      window.location.href = '/blogs';
    }).catch(error => {});
  }
}
