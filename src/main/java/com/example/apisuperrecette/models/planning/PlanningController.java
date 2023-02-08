package com.example.apisuperrecette.models.planning;

import com.example.apisuperrecette.models.ingredient.Ingredient;
import com.example.apisuperrecette.models.ingredient.IngredientRepository;
import com.example.apisuperrecette.models.plate.Plate;
import com.example.apisuperrecette.models.plate.PlateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
//@SecurityRequirement(name = "bearerAuth")
//TODO Remettre la sécurité avec le principal
public class PlanningController {

    @Autowired
    private WeekRepository weekRepository;

    @Autowired
    private DayRepository dayRepository;

    @GetMapping(value = "/weeks")
    public ResponseEntity<List<Week>> getAllWeeks() {
        Iterable<Week> weeks = weekRepository.findAll();
        return new ResponseEntity(weeks, HttpStatus.CREATED);
    }
    @GetMapping(value = "/days")
    public ResponseEntity<List<Day>> getAllDays() {
        Iterable<Day> days = dayRepository.findAll();
        return new ResponseEntity(days, HttpStatus.CREATED);
    }

    @PostMapping(value = "/weeks")
    public ResponseEntity addWeek(@Valid @RequestBody Week week) {
        Week savedWeek = weekRepository.save(week);
        return new ResponseEntity(savedWeek, HttpStatus.CREATED);
    }



}
