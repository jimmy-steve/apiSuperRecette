package com.example.apisuperrecette.models.plate;

import com.example.apisuperrecette.models.ingredient.Ingredient;
import com.example.apisuperrecette.models.planning.Day;
import com.example.apisuperrecette.models.user.UserInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@ToString
public class Plate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private LocalDate date;
    private boolean deleted;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "day_id")
    private Day day;


    @JsonIgnore
    @OneToMany(mappedBy = "plate", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Ingredient> ingredients;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserInfo user;

//    @ManyToMany( mappedBy = "day_plate")
//    private List<Day> days;


    public Plate() {
        this.ingredients = new ArrayList<>();

    }

}
