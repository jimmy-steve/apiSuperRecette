package com.example.apisuperrecette.models.ingredient;

import com.example.apisuperrecette.models.plate.Plate;
import com.example.apisuperrecette.models.plate.PlateRepository;
import com.example.apisuperrecette.models.user.UserInfo;
import com.example.apisuperrecette.models.user.UserRepository;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.awt.print.Book;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

@RestController
//@SecurityRequirement(name = "bearerAuth")
//TODO Remettre la sécurité avec le principal
public class IngredientController {
    @Autowired
    private IngredientRepository ingredientRepository;

    @Autowired
    private PlateRepository plateRepository;

    @GetMapping(value = "/plates/{id}/ingredients")
    public ResponseEntity<List<Ingredient>> getIngredientsForPlate(@PathVariable Integer id) {
        Optional<Plate> optionalPlate = plateRepository.findById(id);

        if (!optionalPlate.isPresent()) {
            return new ResponseEntity("Plate not found", HttpStatus.BAD_REQUEST);
        }
        Plate plate = optionalPlate.get();
        List<Ingredient> ingredients = plate.getIngredients();
        return new ResponseEntity<>(ingredients, HttpStatus.OK);
    }


    @PostMapping(value = "/ingredients")
    public ResponseEntity addIngredient(@Valid @RequestBody Ingredient ingredient) {
        System.out.println("ingredient: " + ingredient);
        ingredientRepository.save(ingredient);
        return new ResponseEntity(ingredient, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/ingredients/{ingredientId}")
    public ResponseEntity deleteIngredient(@PathVariable("ingredientId") Integer ingredientId) {
        Optional<Ingredient> ingredientToDelete = ingredientRepository.findById(ingredientId);

        if (!ingredientToDelete.isPresent()) {
            return new ResponseEntity("Ingredient not found", HttpStatus.BAD_REQUEST);
        }

        Ingredient updatedIngredient = ingredientToDelete.get();
        updatedIngredient.setDeleted(true);
        ingredientRepository.save(updatedIngredient);
        updatedIngredient.setDeleted(true);
        ingredientRepository.save(updatedIngredient);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping(value = "/ingredients/{ingredientId}")
    public ResponseEntity updateIngredient(@PathVariable("ingredientId") Integer ingredientId, @RequestBody Ingredient ingredient) {
        Optional<Ingredient> ingredientToUpdate = ingredientRepository.findById(ingredientId);
        if (!ingredientToUpdate.isPresent()) {
            return new ResponseEntity("Ingredient not found", HttpStatus.BAD_REQUEST);
        }
        Ingredient ingredientToSave = ingredientToUpdate.get();
        ingredientToSave.setName(ingredient.getName());
        ingredientToSave.setQuantity(ingredient.getQuantity());
        ingredientToSave.setUnit(ingredient.getUnit());
        ingredientRepository.save(ingredientToSave);

        return new ResponseEntity(ingredientToSave, HttpStatus.OK);
    }
}
