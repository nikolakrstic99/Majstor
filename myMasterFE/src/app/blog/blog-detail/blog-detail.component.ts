import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Params, Router} from '@angular/router';
import { Blog } from '../../models/blog';
import {blogs} from "../blog-data";

@Component({
  selector: 'app-blog-detail',
  templateUrl: './blog-detail.component.html',
  styleUrls: ['./blog-detail.component.scss']
})
export class BlogDetailComponent implements OnInit {

  id: any;
  blogDetail: Blog | undefined;
  constructor(private activatedRouter: ActivatedRoute) {
    this.id = activatedRouter.snapshot.paramMap.get('id');
  }

  ngOnInit(): void {
    this.blogDetail = blogs[this.id - 1];
    this.activatedRouter.params.subscribe((params: Params) => this.id = params['id']);
  }

  loginClick() {
    //this.router.navigate([('/login')]);
  }

  newPost() {
    //this.service.showEdit=false;
   // this.router.navigate([('/post')]);

  }

  delete() {
  }



  // editPost(){
  //   this.router.navigate([('/editPost'), this.service?.detailId]);

  // }

}
