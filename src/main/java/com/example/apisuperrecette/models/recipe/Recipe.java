package com.example.apisuperrecette.models.recipe;

import com.example.apisuperrecette.models.user.UserInfo;

import javax.persistence.*;

@Entity
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private int preparationTime;
    private int cookingTime;
    private String instructions;
    private int numberOfPeople;

    private String imageRecipe;

//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private UserInfo user;

    public Recipe() {
    }





    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public int getPreparationTime() {
        return preparationTime;
    }

    public void setPreparationTime(int preparationTime) {
        this.preparationTime = preparationTime;
    }

    public int getCookingTime() {
        return cookingTime;
    }

    public void setCookingTime(int cookingTime) {
        this.cookingTime = cookingTime;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }


    public String getImageRecipe() {
        return imageRecipe;
    }

    public void setImageRecipe(String imageRecipe) {
        this.imageRecipe = imageRecipe;
    }



}
