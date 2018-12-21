import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatIconModule, MatToolbarModule, MatButtonModule, MatFormFieldModule, MatInputModule } from '@angular/material';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { LoginComponent } from './login/login.component';
import { RoutingModule } from './routing/routing.module';
import { RecipeListComponent } from './recipe-list/recipe-list.component';
import { IndexComponent } from './index/index.component';
import { RecipeAddComponent } from './recipe-add/recipe-add.component';
import { DessertComponent } from './recipe-list/dessert/dessert.component';
import { MainCourseComponent } from './recipe-list/main-course/main-course.component';
import { SoupComponent } from './recipe-list/soup/soup.component';
import { DrinkComponent } from './recipe-list/drink/drink.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RecipeListComponent,
    IndexComponent,
    RecipeAddComponent,
    DessertComponent,
    MainCourseComponent,
    SoupComponent,
    DrinkComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatIconModule,
    MatToolbarModule,
    MatButtonModule,
    MatFormFieldModule,
    MatInputModule,
    FormsModule,
    RoutingModule,
    ReactiveFormsModule,
    HttpClientModule,
	NgbModule.forRoot()
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
