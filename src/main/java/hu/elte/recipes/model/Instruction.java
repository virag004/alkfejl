package hu.elte.recipes.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Instruction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "recipe_id")
    private Recipe recipe;

    @Column(name = "step")
    private Integer step;

    @Column(name = "description")
    private String description;

    public Instruction(Recipe recipe, Integer step, String description) {
        this.recipe = recipe;
        this.step = step;
        this.description = description;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Integer recipe) {
        this.recipe = recipe;
    }

    public Integer getStep() {
        return step;
    }

    public void setStep(Integer step) {
        this.step = step;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}