import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {AxiosService} from "../services/axios.service";
import {UtilsService} from "../utils.service";

@Component({
  selector: 'app-l1-category',
  templateUrl: './l1-category.component.html',
  styleUrls: ['./l1-category.component.scss']
})
export class L1CategoryComponent implements OnInit {
  l1Category: string;
  l2CategorySelected = null;
  l2Categories = [];
  services = [];
  serviceImageMap = new Map<string, string[]> ();
  serviceActiveSlideMap = new Map<string, boolean[]>();

  constructor(private route: ActivatedRoute, private axiosService: AxiosService, private utils: UtilsService) {
  }


  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.l1Category = params['l1category'];
    });
    this.axiosService.request('GET', `api/v1/service/l2Categories/${this.l1Category}`, null).then(
      response => {
        this.l2Categories = response.data;
      }).catch(
      error => {
        this.utils.openSnackBar("Greška prilikom dohvatanja l2 kategorija :(");
      }
    );
  }

  selectL2Category(l2Category: string) {
    this.l2CategorySelected = l2Category;
    this.axiosService.request('GET', `api/v1/service/usersProvidingL2Category/${this.l2CategorySelected}`, null).then(response => {
      this.services = response.data;
      this.services.forEach(service => {
        this.axiosService.request('GET', `api/v1/service/images/${service.id}`, null).then(response => {
          const images: string[] = [];
          const activeSlide: boolean[] = [];
          response.data.forEach((image: any) => {
            images.push(image['imageData']);
            activeSlide.push(false);
          });
          activeSlide[0] = true;
          this.serviceActiveSlideMap.set(service["id"], activeSlide);
          this.serviceImageMap.set(service["id"], images);
        }).catch(
          () => {
            this.utils.openSnackBar("Greška prilikom dohvatanja slika :(");
          }
        );
      });
    }).catch(
      () => {
        this.utils.openSnackBar("Greška prilikom dohvatanja usluga :(");
      }
    );

  }

  imageClick(serviceId: string, step: number): void {
    let activeSlide = this.serviceActiveSlideMap.get(serviceId);
    let activeIndex = activeSlide.findIndex(value => value);
    let nextIndex = activeIndex + step;
    if(nextIndex < 0)
      nextIndex = activeSlide.length - 1;
    else if(nextIndex >= activeSlide.length)
      nextIndex = 0;
    activeSlide[activeIndex] = false;
    activeSlide[nextIndex] = true;
    this.serviceActiveSlideMap.set(serviceId, activeSlide);
  }

}
