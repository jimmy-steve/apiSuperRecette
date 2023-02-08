package com.example.apisuperrecette.models.planning;

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
public class Week {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate startDate;
    private LocalDate endDate;

    private int number;
    private int year;
    private boolean deleted;

    @ManyToOne
    @JoinColumn(name = "planning_id")
    private Planning planning;



//    @OneToMany(mappedBy = "planning", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
//    private List<Day> days;


    public Week() {
    }

}
