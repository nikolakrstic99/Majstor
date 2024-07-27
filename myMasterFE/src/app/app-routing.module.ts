import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {MastersComponent} from "./masters/masters.component";
import {BlogComponent} from "./blog/blog.component";

const routes: Routes = [
  {path: "blog", component: BlogComponent},
  {path: "masters", component: MastersComponent},
]
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
