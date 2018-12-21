package hu.elte.recipes.controller;

import hu.elte.recipes.model.Quantity;
import hu.elte.recipes.repository.QuantityRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/quantities") // !!!!!!!
public class QuantityController {

    @Autowired
    private QuantityRepository quantityRepository;

    @GetMapping("")
    public Iterable<Quantity> getAll() {
        return quantityRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Quantity> getById(@PathVariable Integer id) {
        Optional<Quantity> quantity = quantityRepository.findById(id);
        if (quantity.isPresent()) {
            return ResponseEntity.ok(quantity.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Quantity> create(@RequestBody Quantity quantity) {
        if ((quantity.getRecipeId() != null && quantityRepository.existsById(quantity.getRecipeId())) &&
            quantity.getIngredientId() != null && quantityRepository.existsById(quantity.getIngredientId())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        return ResponseEntity.ok(quantityRepository.save(quantity));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Quantity> replace(@PathVariable Integer id, @RequestBody Quantity quantity) {
        Optional<Quantity> oQuantity = quantityRepository.findById(id);
        if (oQuantity.isPresent()) {
            quantity.setRecipeId(oQuantity.get().getRecipeId());
            quantity.setIngredientId(oQuantity.get().getIngredientId());
            return ResponseEntity.ok(quantityRepository.save(quantity));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Quantity> modify(@PathVariable Integer id, @RequestBody Quantity quantity) {
        Optional<Quantity> oQuantity = quantityRepository.findById(id);
        if (oQuantity.isPresent()) {
            Quantity modifiableQuantity = oQuantity.get();
            if (quantity.getQuantity() != null) {
                modifiableQuantity.setQuantity((quantity.getQuantity()));
            }
            return ResponseEntity.ok(quantityRepository.save(modifiableQuantity));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        Optional<Quantity> oQuantity = quantityRepository.findById(id);
        if (oQuantity.isPresent()) {
            quantityRepository.delete(oQuantity.get());
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}