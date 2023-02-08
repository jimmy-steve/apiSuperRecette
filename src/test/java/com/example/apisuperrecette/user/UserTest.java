package com.example.apisuperrecette.user;

import com.example.apisuperrecette.ApiSuperRecetteApplication;
import com.example.apisuperrecette.models.plate.Plate;
import com.example.apisuperrecette.models.plate.PlateRepository;
import com.example.apisuperrecette.models.user.UserInfo;
import com.example.apisuperrecette.models.user.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PlateRepository plateRepository;

    @Test
    public void testUserCreationWithPlate() {
        UserInfo user = new UserInfo();
        user.setFirstName("John33344444");
        user.setLastName("Doe");
        user.setEmail("asc@site.com");
        UserInfo savedUser = userRepository.save(user);


        Plate plate = new Plate();
        plate.setName("Ma recette test");
        plate.setDate(LocalDate.parse("2023-02-03"));
        plate.setDeleted(false);

        plate.setUser(user);

        Plate savedPlate = plateRepository.save(plate);

        assertNotNull(savedPlate);
        assertNotNull(savedUser);
        assertEquals(user.getFirstName(), savedUser.getFirstName());
        assertEquals(user.getLastName(), savedUser.getLastName());
        assertEquals(user.getEmail(), savedUser.getEmail());

    }

    @Test
    public void testUserCreation() {
        UserInfo user = new UserInfo();
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setEmail("asc@site.com");

        UserInfo savedUser = userRepository.save(user);
        assertNotNull(savedUser);
        assertEquals(user.getFirstName(), savedUser.getFirstName());
        assertEquals(user.getLastName(), savedUser.getLastName());
        assertEquals(user.getEmail(), savedUser.getEmail());
    }

}
