package com.example.apisuperrecette.models.plate;

import com.example.apisuperrecette.models.ingredient.Ingredient;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.context.annotation.Lazy;

import java.io.Serializable;
import java.util.List;

public class PlateWithIngredients implements Serializable {
    private Plate plate;
    @Lazy
    private List<Ingredient> ingredients;

    public PlateWithIngredients(Plate plate, List<Ingredient> ingredients) {
        this.plate = plate;
        this.ingredients = ingredients;
    }

    public Plate getPlate() {
        return plate;
    }
    @Lazy
    public List<Ingredient> getIngredients() {
        return ingredients;
    }
}

