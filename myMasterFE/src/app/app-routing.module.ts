import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {BlogComponent} from "./blog/blog.component";
import {BlogDetailComponent} from "./blog/blog-detail/blog-detail.component";
import {AddBlogComponent} from "./blog/add-blog/add-blog.component";
import {LoginRegisterComponent} from "./login-register/login-register.component";
import {ContactComponent} from "./contact/contact.component";
import {AddServiceComponent} from "./add-service/add-service.component";
import {HomeComponent} from "./home/home.component";
import {L1CategoryComponent} from "./l1-category/l1-category.component";

const routes: Routes = [
  {path: "blogs", component: BlogComponent},
  {path: "blogDetail/:id", component: BlogDetailComponent},
  {path: "addBlog", component: AddBlogComponent},
  {path: "loginRegister", component: LoginRegisterComponent},
  {path: "contact", component: ContactComponent},
  {path: "addService", component: AddServiceComponent},
  {path: "", component: HomeComponent},
  {path: "l1Category/:l1category", component: L1CategoryComponent}
]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
