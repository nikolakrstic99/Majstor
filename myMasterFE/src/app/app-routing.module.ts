import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {BlogComponent} from "./blog/blog.component";
import {BlogDetailComponent} from "./blog/blog-detail/blog-detail.component";
import {AddBlogComponent} from "./blog/add-blog/add-blog.component";
import {LoginRegisterComponent} from "./login-register/login-register.component";
import {ContactComponent} from "./contact/contact.component";

const routes: Routes = [
  {path: "blogs", component: BlogComponent},
  {path: "blogDetail/:id", component: BlogDetailComponent},
  {path: "addBlog", component: AddBlogComponent},
  {path: "loginRegister", component: LoginRegisterComponent},
  {path: "contact", component: ContactComponent}
]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
