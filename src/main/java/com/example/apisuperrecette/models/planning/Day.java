package com.example.apisuperrecette.models.planning;

import com.example.apisuperrecette.models.ingredient.Ingredient;
import com.example.apisuperrecette.models.plate.Plate;
import lombok.*;
import org.springframework.data.repository.cdi.Eager;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@ToString
public class Day {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;

    @OneToMany(mappedBy = "day", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Plate> plates;

//    private List<Plate> plates = new ArrayList<>();

    @ManyToOne
    @JoinColumn( name = "planning_id", foreignKey = @ForeignKey(name = "fk_day_planning_id"))
    private Planning planning;

//    @ManyToOne
//    @JoinColumn(name = "week_id")
//    private Week week;

    public Day(LocalDate date) {
        this.date = date;
    }

//        @ManyToMany
//    @JoinTable(
//            name = "day_plate",
//            joinColumns = @JoinColumn(name = "day_id"),
//            inverseJoinColumns = @JoinColumn(name = "plate_id")
//    )
//    private List<Plate> plates;


    public Day() {

    }


}
