import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {MastersComponent} from "./masters/masters.component";
import {BlogComponent} from "./blog/blog.component";
import {BlogDetailComponent} from "./blog/blog-detail/blog-detail.component";
import {AddBlogComponent} from "./blog/add-blog/add-blog.component";
import {LoginComponent} from "./login/login.component";
import {RegisterComponent} from "./register/register.component";
import {LoginRegisterComponent} from "./login-register/login-register.component";

const routes: Routes = [
  {path: "blog", component: BlogComponent},
  {path: "masters", component: MastersComponent},
  {path: "blogDetail/:id", component: BlogDetailComponent},
  {path: "addBlog", component: AddBlogComponent},
  {path: "login", component: LoginComponent},
  {path: "register", component: RegisterComponent},
  {path: "loginRegister", component: LoginRegisterComponent}
]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
