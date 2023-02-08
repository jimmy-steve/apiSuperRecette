package com.example.apisuperrecette.models.plate;

import com.example.apisuperrecette.models.ingredient.Ingredient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlateRepository extends CrudRepository<Plate, Integer>  {


    Plate getPlateById(Integer id);
}
