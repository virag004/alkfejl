package hu.elte.recipes.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    // @JoinColumn
    @JsonIgnore
    @Column(name = "user_id")
    private User user;

    @Column(name = "name")
    private String name;

    @Column(name = "picture")
    private String picture;

    public Recipe(User user, String name, String picture) {
        this.user = user;
        this.name = name;
        this.picture = picture;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUserId() {
        return user;
    }

    public void setUserId(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Recipe getRecipe(Integer id) {
        //
    }
}