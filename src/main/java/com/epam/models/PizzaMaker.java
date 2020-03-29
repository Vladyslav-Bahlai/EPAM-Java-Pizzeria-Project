package com.epam.models;

import com.epam.enums.Position;

public class PizzaMaker extends Employee {
    private double yearsOfExperience;
    private String cookingEducation;

    public PizzaMaker() { }

    public PizzaMaker(
            int id,
            String fullName,
            int age,
            int salary,
            int pizzeriaId,
            Position position,
            double yearsOfExperience,
            String cookingEducation
    ) {
        super(id, fullName, age, salary, pizzeriaId, position);
        this.yearsOfExperience = yearsOfExperience;
        this.cookingEducation = cookingEducation;
    }

    public double getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(double yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public String getCookingEducation() {
        return cookingEducation;
    }

    public void setCookingEducation(String cookingEducation) {
        this.cookingEducation = cookingEducation;
    }

    @Override
    public String toString() {
        return "PizzaMaker{" +
                "yearsOfExperience=" + yearsOfExperience +
                ", cookingEducation='" + cookingEducation + '\'' +
                '}';
    }
}
