import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Recipe } from './model/Recipe';

@Injectable({
  providedIn: 'root'
})
export class RecipeService {

  private recipeItems: Recipe[] = [];

  constructor(
    private httpClient: HttpClient
  ) { }

  getRecipe(recipeId: number): Promise<Recipe> {
    const recipe = this.recipeItems.find(
      recipe => recipe.id === recipeId
    );
    if (recipe) {
      return Promise.resolve(recipe);
    } else {
      return this.httpClient
        .get<Recipe>(`/api/recipes/${recipeId}`)
        .toPromise()
        .then(recipe => { return recipe});
    }
  }

  filter(filterText: string): Recipe[] {
    const filteredRecipeItems: Recipe[] = [];
    for (let recipeItem of this.recipeItems) {

      if (recipeItem.name.startsWith(filterText)) {

        filteredRecipeItems.push(recipeItem);

      }

    }
    return filteredRecipeItems;
  }

  requestRecipes() {
    this.httpClient
      .get<Recipe[]>('/api/recipes')
      .toPromise()
      .then(recipes =>
          this.recipeItems = recipes);
  }

}