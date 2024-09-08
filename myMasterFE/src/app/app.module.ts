import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BlogComponent } from './blog/blog.component';
import {BlogDetailComponent} from "./blog/blog-detail/blog-detail.component";
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { AddBlogComponent } from './blog/add-blog/add-blog.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import { FooterComponent } from './footer/footer.component';
import { HeaderComponent } from './header/header.component';
import { LoginRegisterComponent } from './login-register/login-register.component';
import { ContactComponent } from './contact/contact.component';
import { AddServiceComponent } from './add-service/add-service.component';
import { HomeComponent } from './home/home.component';
import { L1CategoryComponent } from './l1-category/l1-category.component';
import {MatCardModule} from "@angular/material/card";
import {MatSliderModule} from "@angular/material/slider";
import {MatSnackBarModule} from "@angular/material/snack-bar";
import { MyProfileComponent } from './my-profile/my-profile.component';
import {TranslateModule} from '@ngx-translate/core';
import { AddReviewComponent } from './add-review/add-review.component';

@NgModule({
  declarations: [
    AppComponent,
    BlogComponent,
    BlogDetailComponent,
    AddBlogComponent,
    FooterComponent,
    HeaderComponent,
    LoginRegisterComponent,
    ContactComponent,
    AddServiceComponent,
    HomeComponent,
    L1CategoryComponent,
    MyProfileComponent,
    AddReviewComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FontAwesomeModule,
    BrowserAnimationsModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    MatSnackBarModule,
    MatCardModule,
    MatSliderModule,
    TranslateModule.forRoot()
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
