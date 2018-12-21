import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { LoginComponent } from '../login/login.component';
import { RecipeListComponent } from '../recipe-list/recipe-list.component';
import { IndexComponent } from '../index/index.component';
import { RecipeAddComponent } from '../recipe-add/recipe-add.component';
import { DessertComponent } from '../recipe-list/dessert/dessert.component';
import { SoupComponent } from '../recipe-list/soup/soup.component';
import { MainCourseComponent } from '../recipe-list/main-course/main-course.component';
import { DrinkComponent } from '../recipe-list/drink/drink.component';

const routes: Routes = [
  {
    path: '',
    component: IndexComponent,
    /*redirectTo: '/index',
    pathMatch: 'full',*/
  },
  {
    path: 'recipes',
    component: RecipeListComponent,
  },
  {
    path: 'recipes/add',
    component: RecipeAddComponent,
  },
  {
    path: 'recipes/desserts',
    component: DessertComponent,
  },
  {
    path: 'recipes/soups',
    component: SoupComponent,
  },
  {
    path: 'recipes/maincourses',
    component: MainCourseComponent,
  },
  {
    path: 'recipes/drinks',
    component: DrinkComponent,
  },
  /*{
    path: 'playlist/:id',
    component: SongListComponent,
  },*/
  {
    path: 'login',
    component: LoginComponent,
  },
];

@NgModule({
  imports: [ RouterModule.forRoot(routes)  ],
  exports: [ RouterModule ],
  declarations: [],
})
export class RoutingModule { }