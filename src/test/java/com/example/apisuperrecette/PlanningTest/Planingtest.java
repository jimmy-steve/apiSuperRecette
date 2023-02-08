package com.example.apisuperrecette.PlanningTest;

import com.example.apisuperrecette.models.ingredient.Ingredient;
import com.example.apisuperrecette.models.planning.*;
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
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Planingtest {
@Autowired
private PlateRepository plateRepository;

    @Autowired
    private WeekRepository weekRepository;

    @Autowired
    private DayRepository dayRepository;

    @Autowired
    private PlanningRepository planningRepository;

    @Test
    public void addWeekWithDaysAndRecipesTest() {
        Planning planning = new Planning();
        planning.setName("Planning 1");
        planning.setDescription("Description of Planning 1");
        planning.setStartDate("2023-02-07");
        planning.setEndDate("2023-02-13");
        planning.setNumber(5);
        planning.setYear(2023);
        planning.setDeleted(false);

        planning = planningRepository.save(planning);

//        Week week = new Week();
//        week.setStartDate(LocalDate.of(2023, 2, 7));
//        week.setEndDate(LocalDate.of(2023, 2, 13));
//        week.setNumber(5);
//        week.setYear(2023);
//        week.setDeleted(false);
//        week.setPlanning(planning);
//
//        Day day1 = new Day(LocalDate.of(2023, 2, 7));
//        Day day2 = new Day(LocalDate.of(2023, 2, 8));
//        Day day3 = new Day(LocalDate.of(2023, 2, 9));
//        Day day4 = new Day(LocalDate.of(2023, 2, 10));
//        Day day5 = new Day(LocalDate.of(2023, 2, 11));
//        Day day6 = new Day(LocalDate.of(2023, 2, 12));
//        Day day7 = new Day(LocalDate.of(2023, 2, 13));
//
//        day1.setWeek(week);
//        day2.setWeek(week);
//        day3.setWeek(week);
//        day4.setWeek(week);
//        day5.setWeek(week);
//        day6.setWeek(week);
//        day7.setWeek(week);
//
//        List<Day> days = new ArrayList<>();
//        days.add(day1);
//        days.add(day2);
//        days.add(day3);
//        days.add(day4);
//        days.add(day5);
//        days.add(day6);
//        days.add(day7);
//
//        week.setDays(days);
//
//        planning.getWeeks().add(week);
//
//        planningRepository.save(planning);
    }

    @Test
    public void testWeekCreation() {
//        Week week = new Week();
//        week.setNumber(1);
//        week.setYear(2021);
//        week.setDeleted(false);
//
//        List<Day> days = new ArrayList<>();
//        days.add(new Day(LocalDate.parse("2021-01-01")));
//        days.add(new Day(LocalDate.parse("2021-01-02")));
//        days.add(new Day(LocalDate.parse("2021-01-03")));
//        days.add(new Day(LocalDate.parse("2021-01-04")));
//        days.add(new Day(LocalDate.parse("2021-01-05")));
//        days.add(new Day(LocalDate.parse("2021-01-06")));
//        days.add(new Day(LocalDate.parse("2021-01-07")));
//        week.setDays(days);
//
//        Week savedWeek = weekRepository.save(week);
//        assertNotNull(savedWeek);
//        assertEquals(week.getNumber(), savedWeek.getNumber());
//        assertEquals(week.getYear(), savedWeek.getYear());
//        assertEquals(week.isDeleted(), savedWeek.isDeleted());
//        assertEquals(week.getDays().size(), savedWeek.getDays().size());

    }

    @Test
    public void givenWeek_whenSave_thenGetOk() {
        Week week = new Week();
        week.setNumber(2023);
        week.setYear(2023);
        week.setStartDate(LocalDate.of(2023, 2, 7));
        week.setEndDate(LocalDate.of(2023, 2, 13));

        week = weekRepository.save(week);
        Optional<Week> foundWeek = weekRepository.findById(Math.toIntExact(week.getId()));

        assertThat(foundWeek.get().getNumber()).isEqualTo(week.getNumber());
        assertThat(foundWeek.get().getYear()).isEqualTo(week.getYear());
        assertThat(foundWeek.get().getStartDate()).isEqualTo(week.getStartDate());
        assertThat(foundWeek.get().getEndDate()).isEqualTo(week.getEndDate());
    }

    @Test
    public void givenWeek_whenUpdate_thenGetUpdatedOk() {
        Week week = new Week();
        week.setNumber(2023);
        week.setYear(2023);
        week.setStartDate(LocalDate.of(2023, 2, 7));
        week.setEndDate(LocalDate.of(2023, 2, 13));

        week = weekRepository.save(week);
        Optional<Week> foundWeek = weekRepository.findById(Math.toIntExact(week.getId()));

        foundWeek.get().setNumber(2024);
        foundWeek.get().setYear(2024);
        foundWeek.get().setStartDate(LocalDate.of(2024, 2, 7));
        foundWeek.get().setEndDate(LocalDate.of(2024, 2, 13));

        weekRepository.save(foundWeek.get());

        Optional<Week> updatedWeek = weekRepository.findById(Math.toIntExact(week.getId()));

        assertThat(updatedWeek.get().getNumber()).isEqualTo(foundWeek.get().getNumber());
        assertThat(updatedWeek.get().getYear()).isEqualTo(foundWeek.get().getYear());
        assertThat(updatedWeek.get().getStartDate()).isEqualTo(foundWeek.get().getStartDate());
        assertThat(updatedWeek.get().getEndDate()).isEqualTo(foundWeek.get().getEndDate());
    }

    @Test
    public void givenWeek_whenDelete_thenGetDeletedOk() {
        Week week = new Week();
        week.setNumber(2023);
        week.setYear(2023);
        week.setStartDate(LocalDate.of(2023, 2, 7));
        week.setEndDate(LocalDate.of(2023, 2, 13));

        week = weekRepository.save(week);
        Optional<Week> foundWeek = weekRepository.findById(Math.toIntExact(week.getId()));

        weekRepository.delete(foundWeek.get());

        Optional<Week> deletedWeek = weekRepository.findById(Math.toIntExact(week.getId()));

        assertThat(deletedWeek.isPresent()).isEqualTo(false);
    }

    @Test
    public void AddPlateByDayTest(){
        Plate plate = new Plate();
        plate.setName("Plate1");
        plate.setDeleted(false);


        Day day = new Day();
        day.setDate(LocalDate.of(2023, 2, 7));
        day.setPlanning(planningRepository.findById(1).get());
        dayRepository.save(day);
        plateRepository.save(plate);

    }


}
