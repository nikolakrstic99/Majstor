import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BlogComponent } from './blog/blog.component';
import { MastersComponent } from './masters/masters.component';
import {ServiceblogService} from "./blog/blog-service.service";

@NgModule({
  declarations: [
    AppComponent,
    BlogComponent,
    MastersComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [ServiceblogService],
  bootstrap: [AppComponent]
})
export class AppModule { }
