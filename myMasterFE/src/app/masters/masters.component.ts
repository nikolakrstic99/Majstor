import { Component, OnInit } from '@angular/core';
import {ServiceblogService} from "../blog/blog-service.service";
import {Router} from "@angular/router";
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-masters',
  templateUrl: './masters.component.html',
  styleUrls: ['./masters.component.scss']
})
export class MastersComponent implements OnInit {

  constructor(
    //public service: ServiceblogService,
    //public router: Router,
    //public http: HttpClient
  ) {
    //this.service.showEdit = false;
  }

  ngOnInit(): void {
  }

}
