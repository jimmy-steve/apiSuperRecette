package com.example.apisuperrecette.plate;

import com.example.apisuperrecette.models.ingredient.Ingredient;
import com.example.apisuperrecette.models.plate.Plate;
import com.example.apisuperrecette.models.plate.PlateRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PlateTest {
    @Autowired
    private PlateRepository plateRepository;

    @Test
    public void testPlateCreation() {
        Plate plate = new Plate();
        plate.setName("Ma recette test");
        plate.setDate(LocalDate.parse("2023-02-03"));
        plate.setDeleted(false);

        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(new Ingredient("Tomates", 5, false, "pièces"));
        ingredients.add(new Ingredient("Oignons", 2, false, "pièces"));
        ingredients.add(new Ingredient("Pommes de terre", 10, false, "pièces"));
        plate.setIngredients(ingredients);

        Plate savedPlate = plateRepository.save(plate);
        assertNotNull(savedPlate);
        assertEquals(plate.getName(), savedPlate.getName());
        assertEquals(plate.getDate(), savedPlate.getDate());
        assertEquals(plate.isDeleted(), savedPlate.isDeleted());
        assertEquals(plate.getIngredients().size(), savedPlate.getIngredients().size());
    }

    @Test
    public void testUpdatePlate() {
        Plate plate = new Plate();
        plate.setName("jk.j.je");
        plate.setDate(LocalDate.parse("2023-02-03"));
        plate.setDeleted(false);

        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(new Ingredient("Tomates", 5, false, "pièces"));
        ingredients.add(new Ingredient("Oignons", 2, false, "pièces"));
        ingredients.add(new Ingredient("Pommes de terre", 10, false, "pièces"));
        plate.setIngredients(ingredients);

        Plate savedPlate = plateRepository.save(plate);
        assertNotNull(savedPlate);

        savedPlate.setName("New Name");
        Plate updatedPlate = plateRepository.save(savedPlate);
        assertNotNull(updatedPlate);
        assertEquals("New Name", updatedPlate.getName());
        plateRepository.deleteById(updatedPlate.getId());
    }

    @Test
    public void testDeletePlate() {
        Plate plate = new Plate();
        plate.setName("jk.j.je");
        plate.setDate(LocalDate.parse("2023-02-03"));
        plate.setDeleted(false);

        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(new Ingredient("Tomates", 5, false, "pièces"));
        ingredients.add(new Ingredient("Oignons", 2, false, "pièces"));
        ingredients.add(new Ingredient("Pommes de terre", 10, false, "pièces"));
        plate.setIngredients(ingredients);

        Plate savedPlate = plateRepository.save(plate);
        assertNotNull(savedPlate);

        plateRepository.deleteById(savedPlate.getId());
        Plate deletedPlate = plateRepository.getPlateById(savedPlate.getId());
        assertNull(deletedPlate);
    }
}
