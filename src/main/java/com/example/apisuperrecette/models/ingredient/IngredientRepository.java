package com.example.apisuperrecette.models.ingredient;

import com.example.apisuperrecette.models.plate.Plate;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredientRepository extends CrudRepository<Ingredient, Integer> {
    //    List<Ingredient> findByPlateId(Integer id);
//    @Query("SELECT i FROM Ingredient i WHERE i.plate.id = :id")
//    List<Ingredient> findByPlateId(Integer plateId);



//    @Query("SELECT i FROM Ingredient i WHERE i.plate.id = :id")
//    List<Ingredient> findByPlateId(@Param("id") Integer id);

//    @Query("SELECT p FROM Plate p WHERE p.id = :id")
//    Optional<Plate> findPlateById(@Param("id") Integer id);
}
