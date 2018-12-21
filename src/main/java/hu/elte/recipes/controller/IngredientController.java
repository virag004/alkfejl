package hu.elte.recipes.controller;

import hu.elte.recipes.model.Ingredient;
import hu.elte.recipes.repository.IngredientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/ingredients") // !!!!!!!
public class IngredientController {

    @Autowired
    private IngredientRepository ingredientRepository;

    @GetMapping("")
    public Iterable<Ingredient> getAll() {
        return ingredientRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ingredient> getById(@PathVariable Integer id) {
        Optional<Ingredient> ingredient = ingredientRepository.findById(id);
        if (ingredient.isPresent()) {
            return ResponseEntity.ok(ingredient.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Ingredient> create(@RequestBody Ingredient ingredient) {
        if (ingredient.getId() != null && ingredientRepository.existsById(ingredient.getId())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        return ResponseEntity.ok(ingredientRepository.save(ingredient));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ingredient> replace(@PathVariable Integer id, @RequestBody Ingredient ingredient) {
        Optional<Ingredient> oIngredient = ingredientRepository.findById(id);
        if (oIngredient.isPresent()) {
            ingredient.setId(oIngredient.get().getId());
            return ResponseEntity.ok(ingredientRepository.save(ingredient));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Ingredient> modify(@PathVariable Integer id, @RequestBody Ingredient ingredient) {
        Optional<Ingredient> oIngredient = ingredientRepository.findById(id);
        if (oIngredient.isPresent()) {
            Ingredient modifiableIngredient = oIngredient.get();
            if (ingredient.getName() != null) {
                modifiableIngredient.setName((ingredient.getName()));
            }
            if (ingredient.getUnit() != null) {
                modifiableIngredient.setUnit((ingredient.getUnit()));
            }
            return ResponseEntity.ok(ingredientRepository.save(modifiableIngredient));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        Optional<Ingredient> oIngredient = ingredientRepository.findById(id);
        if (oIngredient.isPresent()) {
            ingredientRepository.delete(oIngredient.get());
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}