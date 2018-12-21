import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { ActivatedRoute, Router } from '@angular/router';
import { Recipe } from '../model/Recipe';


@Component({
  selector: 'app-recipe-add',
  templateUrl: './recipe-add.component.html',
  styleUrls: ['./recipe-add.component.scss']
})
export class RecipeAddComponent implements OnInit {
  model: Recipe = new Recipe();
  private recipeId: number;

  constructor(
    private httpClient: HttpClient,
    private route: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit() {
    this.recipeId = parseInt(this.route.snapshot.params.id as string);
  }

  async save(form: NgForm) {
    if (form.valid) {
      const newRecipe: Recipe = form.value;
      var splitted=newRecipe.ingredients[0].split(", ", 1024);
      newRecipe.ingredients=splitted;
      var splitted2=newRecipe.instructions[0].split(", ", 1024);
      newRecipe.instructions=splitted2;
      const createdRecipe = await this.httpClient
        .post('/api/recipes', newRecipe)
        .toPromise();
      if (this.recipeId) {
        await this.httpClient
          .post(
            `/api/recipes/${this.recipeId}/recipes`,
            createdRecipe
          )
          .toPromise();
        this.router.navigate(
          ['recipe', this.recipeId]);
      }
    }
  }

}