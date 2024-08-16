import { Component, OnInit } from '@angular/core';
import {AxiosService} from "../services/axios.service";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  constructor(public axiosService: AxiosService) { }

  ngOnInit(): void {
  }

}
