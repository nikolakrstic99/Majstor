import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params } from '@angular/router';
import { Blog } from '../../models/blog';
import { blogs } from '../blog-data';
import {AxiosService} from "../../services/axios.service";

@Component({
  selector: 'app-blog-detail',
  templateUrl: './blog-detail.component.html',
  styleUrls: ['./blog-detail.component.scss']
})
export class BlogDetailComponent implements OnInit {

  id: number | null = null;
  blogDetail: Blog | undefined;
  images: string[] = [
    'assets/images/blog/101.jpg',
    'assets/images/blog/202.jpg',
    'assets/images/blog/303.jpg'
  ];
  activeSlide: boolean[] = [true, false, false];
  activeIndex = 0;
  isAdmin: boolean;

  constructor(private activatedRouter: ActivatedRoute, private axiosService: AxiosService) {
    this.id = +this.activatedRouter.snapshot.paramMap.get('id')!;
  }

  ngOnInit(): void {
    this.blogDetail = blogs[this.id - 1];
    this.activatedRouter.params.subscribe((params: Params) => {
      this.id = +params['id'];
      this.blogDetail = blogs[this.id - 1];
    });
    this.isAdmin = this.axiosService.isAdmin();
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
