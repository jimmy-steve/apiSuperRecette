package com.example.apisuperrecette.models.plate;

import com.example.apisuperrecette.models.ingredient.Ingredient;
import com.example.apisuperrecette.models.ingredient.IngredientRepository;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
//@SecurityRequirement(name = "bearerAuth")
//TODO Remettre la sécurité avec le principal
//changement

public class PlateController {
    @Autowired
    private PlateRepository plateRepository;

    @Autowired
    private IngredientRepository ingredientRepository;

    @GetMapping(value = "/plates")
    public ResponseEntity<Iterable<Plate>> getAllPlates() {
        Iterable<Plate> plates = plateRepository.findAll();
        return new ResponseEntity<>(plates, HttpStatus.OK);
    }

    @GetMapping(value = "/plates/ind")
    public ResponseEntity<Iterable<Plate>> getAllPlatesWithIngredients() {
        Iterable<Plate> plates = plateRepository.findAll();
        for (Plate plate : plates) {
            Hibernate.initialize(plate.getIngredients());
        }
        return new ResponseEntity<>(plates, HttpStatus.OK);
    }
    @PostMapping(value = "/plates/ingredients/v1")
    public ResponseEntity savePlateWithIngredients(@Valid @RequestBody Plate plate, List<Ingredient> ingredients) {
        plate = plateRepository.save(plate);
        for (Ingredient ingredient : ingredients) {
            ingredient.setPlate(plate);
            ingredientRepository.save(ingredient);
        }
        return new ResponseEntity(plate, HttpStatus.CREATED);
    }

    @PostMapping(value = "/plates")
    public ResponseEntity addPlate(@Valid @RequestBody Plate Plate) {
        System.out.println("Plate: " + Plate);
        List<Ingredient> ingredients = Plate.getIngredients();
        System.out.println("Ingredients: " + ingredients);

        Plate.setIngredients(ingredients);
        Plate savedPlate = plateRepository.save(Plate);
        return new ResponseEntity(savedPlate, HttpStatus.CREATED);
    }


    @DeleteMapping(value = "/plates/{plateId}")
    public ResponseEntity deletePlate(@PathVariable("plateId") Integer plateId) {
        Optional<Plate> plateToDelete = plateRepository.findById(plateId);

        if (!plateToDelete.isPresent()) {
            return new ResponseEntity("Plates not found", HttpStatus.BAD_REQUEST);
        }

        Plate updatedPlate = plateToDelete.get();
        updatedPlate.setDeleted(true);
        plateRepository.save(updatedPlate);
        updatedPlate.setDeleted(true);
        plateRepository.save(updatedPlate);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping(value = "/plates/{plateId}")
    public ResponseEntity updatePlate(@PathVariable("plateId") Integer plateId, @RequestBody Plate plate) {
        Optional<Plate> plateToUpdate = plateRepository.findById(plateId);
        if (!plateToUpdate.isPresent()) {
            return new ResponseEntity("Plate not found", HttpStatus.BAD_REQUEST);
        }
        Plate plateToSave = plateToUpdate.get();
        plateToSave.setName(plate.getName());
        plateToSave.setDate(plate.getDate());
        plateToSave.setDeleted(plate.isDeleted());
        plateToSave.setIngredients(plate.getIngredients());
        plateRepository.save(plate);

        return new ResponseEntity(plateToSave, HttpStatus.OK);
    }
}
