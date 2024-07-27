import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BlogComponent } from './blog/blog.component';
import { MastersComponent } from './masters/masters.component';
import {ServiceblogService} from "./blog/blog-service.service";
import {BlogDetailComponent} from "./blog/blog-detail/blog-detail.component";
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';

@NgModule({
  declarations: [
    AppComponent,
    BlogComponent,
    BlogDetailComponent,
    MastersComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FontAwesomeModule
  ],
  providers: [ServiceblogService],
  bootstrap: [AppComponent]
})
export class AppModule { }
