import { Component, OnInit } from '@angular/core';
import { Blog } from '../models/blog';
import { Router } from '@angular/router';
import {Observable, of} from "rxjs";
import {blogs} from "./blog-data";
import {AxiosService} from "../services/axios.service";
import {UtilsService} from "../utils.service";


@Component({
  selector: 'app-blog',
  templateUrl: './blog.component.html',
  styleUrls: ['./blog.component.scss'],
})
export class BlogComponent implements OnInit {
  Blogs = [];
  showEdit = false;
  constructor(
    public router: Router,
    private axiosService: AxiosService,
    private utils: UtilsService
  ) {
    this.showEdit = false;
    this.Blogs = blogs;
  }

  ngOnInit(): void {
    this.axiosService.request('GET', 'api/v1/blog', null).then(response => {
      this.Blogs = response.data;
      console.log(this.Blogs[0]);
    })
    .catch(error => {
      this.utils.openSnackBar('Greška prilikom dohvatanja blogova :(');
    });
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
