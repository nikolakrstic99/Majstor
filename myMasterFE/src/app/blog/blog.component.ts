import { Component, OnInit } from '@angular/core';
import { Blog } from '../models/blog';
import { Router } from '@angular/router';
import {Observable, of} from "rxjs";
import {blogs} from "./blog-data";


@Component({
  selector: 'app-blog',
  templateUrl: './blog.component.html',
  styleUrls: ['./blog.component.scss'],
})
export class BlogComponent implements OnInit {
  Blogs: Blog[] = [];
  showEdit = false;
  constructor(
    public router: Router,
  ) {
    this.showEdit = false;
    this.Blogs = blogs;
  }

  ngOnInit(): void {
    if (this.Blogs.length === 0)
      this.getBlog().subscribe((d: any) => (this.Blogs = d));
  }

  public getBlog(): Observable<any> {
    return of(blogs);
  }

  loginClick() {
   // this.router.navigate(['/login']);
  }

  newPost() {
    //this.router.navigate(['/post']);
  }

  viewDetail(id: number) {
   // this.service.detailId = id;

    ///if (this.service.loginStatusService) this.service.showEdit = true;

    this.router.navigate(['/blogDetail', id]);
  }
}
