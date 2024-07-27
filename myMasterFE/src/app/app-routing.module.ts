import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {MastersComponent} from "./masters/masters.component";
import {BlogComponent} from "./blog/blog.component";
import {BlogDetailComponent} from "./blog/blog-detail/blog-detail.component";

const routes: Routes = [
  {path: "blog", component: BlogComponent},
  {path: "masters", component: MastersComponent},
  {path: "blogDetail/:id", component: BlogDetailComponent},
]
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
