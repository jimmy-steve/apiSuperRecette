package com.example.apisuperrecette.models.user;

import com.example.apisuperrecette.models.plate.Plate;
import com.example.apisuperrecette.models.recipe.Recipe;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.beans.BeanMetadataAttribute;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String email;
    @Size(min = 2, max = 25, message = "First name must be between 2 and 25 characters")
    private String firstName;
    @Size(min = 2, max = 25, message = "Last name must be between 2 and 25 characters")
    private String lastName;
    private String password;

    //    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
//    private List<Recipe> recettes = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Plate> plates = new ArrayList<>();

    public void setPlates(List<Plate> plates) {
        this.plates = plates;
    }

    public UserInfo(String email, String firstName, String lastName, String password) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
    }

    public void setPlate(Plate plate) {
        this.plates.add(plate);
    }

    public List<Plate> getPlates() {
        return plates;
    }

}
