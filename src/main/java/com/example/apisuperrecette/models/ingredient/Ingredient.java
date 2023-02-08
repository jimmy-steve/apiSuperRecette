package com.example.apisuperrecette.models.ingredient;

import com.example.apisuperrecette.models.plate.Plate;
import lombok.*;

import javax.persistence.*;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private int quantity;
    private boolean deleted;
    private String unit;



    @ManyToOne
    @JoinColumn(name = "plate_id")
    private Plate plate;

    public Ingredient(String name, int quantity, boolean deleted, String unit) {
        this.name = name;
        this.quantity = quantity;
        this.deleted = deleted;
        this.unit = unit;
    }
}
