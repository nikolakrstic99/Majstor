import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
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
  }

  isLogged: boolean;
  ngOnInit(): void {
    this.isLogged = this.axiosService.isLoggedIn();
    this.axiosService.request('GET', 'api/v1/blog', null).then(response => {
      this.Blogs = response.data;
    })
    .catch(error => {
      this.utils.openSnackBar('Greška prilikom dohvatanja blogova :(');
    });
  }

  viewDetail(id: number) {

    this.router.navigate(['/blogDetail', id]);
  }
}
