package hu.elte.recipes.model;

import lombok.Data;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
public class Quantity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    // @JoinColumn
    @JsonIgnore
    @Column(name = "recipe_id")
    private Recipe recipe;

    @ManyToOne
    // @JoinColumn
    @JsonIgnore
    @Column(name = "ingredient_id")
    private Ingredient ingredient;

    @Column(name = "quantity")
    private Double quantity; // 0.5

    public Quantity(Recipe recipe, Ingredient ingredient, Double quantity) {
        this.recipe = recipe;
        this.ingredient = ingredient;
        this.quantity = quantity;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredientId(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }
}