import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BlogComponent } from './blog/blog.component';
import { MastersComponent } from './masters/masters.component';
import {ServiceblogService} from "./blog/blog-service.service";
import {BlogDetailComponent} from "./blog/blog-detail/blog-detail.component";
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { AddBlogComponent } from './blog/add-blog/add-blog.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {FormsModule} from "@angular/forms";
import {MatSnackBarModule} from "@angular/material/snack-bar";

@NgModule({
  declarations: [
    AppComponent,
    BlogComponent,
    BlogDetailComponent,
    MastersComponent,
    AddBlogComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FontAwesomeModule,
    BrowserAnimationsModule,
    FormsModule,
    HttpClientModule,
    MatSnackBarModule
  ],
  providers: [ServiceblogService],
  bootstrap: [AppComponent]
})
export class AppModule { }
