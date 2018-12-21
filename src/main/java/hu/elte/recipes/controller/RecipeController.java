package hu.elte.recipes.controller;

import hu.elte.recipes.model.Recipe;
import hu.elte.recipes.repository.RecipeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/recipes") // !!!!!!!
public class RecipeController {

    @Autowired
    private RecipeRepository recipeRepository;

    @GetMapping("")
    public Iterable<Recipe> getAll() {
        return recipeRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Recipe> getById(@PathVariable Integer id) {
        Optional<Recipe> recipe = recipeRepository.findById(id);
        if (recipe.isPresent()) {
            return ResponseEntity.ok(recipe.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping    //////////////////////////////////////////////////////
    public ResponseEntity<Recipe> create(@RequestBody Recipe recipe) {
        if (recipe.getId() != null && recipeRepository.existsById(recipe.getId())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        return ResponseEntity.ok(recipeRepository.save(recipe));
    }

    @PutMapping("/{id}")    ////////////////////////////////////////////////
    public ResponseEntity<Recipe> replace(@PathVariable Integer id, @RequestBody Recipe recipe) {
        Optional<Recipe> oRecipe = recipeRepository.findById(id);
        if (oRecipe.isPresent()) {
            recipe.setId(oRecipe.get().getId());
            return ResponseEntity.ok(recipeRepository.save(recipe));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/{id}")  ////////////////////////////////////////
    public ResponseEntity<Recipe> modify(@PathVariable Integer id, @RequestBody Recipe recipe) {
        Optional<Recipe> oRecipe = recipeRepository.findById(id);
        if (oRecipe.isPresent()) {
            Recipe modifiableRecipe = oRecipe.get();
            if (recipe.getName() != null) {
                modifiableRecipe.setName((recipe.getName()));
            }
            if (recipe.getPicture() != null) {
                modifiableRecipe.setPicture((recipe.getPicture()));
            }
            return ResponseEntity.ok(recipeRepository.save(modifiableRecipe));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        Optional<Recipe> oRecipe = recipeRepository.findById(id);
        if (oRecipe.isPresent()) {
            recipeRepository.delete(oRecipe.get());
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}