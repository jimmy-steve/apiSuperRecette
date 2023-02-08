package com.example.apisuperrecette.models.planning;

import javax.persistence.*;
import java.util.List;
@Entity
public class Planning {
    @Id
    private Long id;
    private String name;
    private String description;
    private String startDate;
    private String endDate;
    private int number;
    private int year;
    private boolean deleted;
    @OneToMany(mappedBy = "planning", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Day> days;

//    @OneToMany(mappedBy = "planning", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
//    private List<Week> weeks;

    public Planning() {
    }

    public Planning(Long id, String name, String description, String startDate, String endDate, int number, int year, boolean deleted) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.number = number;
        this.year = year;
        this.deleted = deleted;
    }

    public List<Day> getDays() {
        return days;
    }

    public void setDays(List<Day> days) {
        this.days = days;
    }

//    public List<Week> getWeeks() {
//        return weeks;
//    }

//    public void setWeeks(List<Week> weeks) {
//        this.weeks = weeks;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

}
