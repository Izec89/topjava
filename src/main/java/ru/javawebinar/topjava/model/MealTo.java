package ru.javawebinar.topjava.model;

import java.time.LocalDateTime;

public class MealTo {

    private final String dateTime;


    private final String description;

    private final int calories;

    private final boolean excess;

    public String getDateTime() {
        return dateTime;
    }

    public String getDescription() {
        return description;
    }

    public int getCalories() {
        return calories;
    }

    public boolean isExcess() {
        return excess;
    }



    public MealTo(String dateTime, String description, int calories, boolean excess) {
        this.dateTime = dateTime;
        this.description = description;
        this.calories = calories;
        this.excess = excess;
    }

    @Override
    public String toString() {
        return "MealTo{" +
                "dateTime=" + dateTime +
                ", description='" + description + '\'' +
                ", calories=" + calories +
                ", excess=" + excess +
                '}';
    }

    public String clearDate(LocalDateTime dateTime) {
        String string = dateTime.toString().replaceAll("T", " ");
        return "";
    }
}
