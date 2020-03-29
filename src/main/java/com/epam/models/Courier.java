package com.epam.models;

import com.epam.enums.CourierType;
import com.epam.enums.Position;

public class Courier extends Employee {
    private CourierType courierType;
    private double rating;

    public Courier() { }

    public Courier(
            int id,
            String fullName,
            int age,
            int salary,
            int pizzeriaId,
            Position position,
            CourierType courierType,
            double rating
    ) {
        super(id, fullName, age, salary, pizzeriaId, position);
        this.courierType = courierType;
        this.rating = rating;
    }

    public CourierType getCourierType() {
        return courierType;
    }

    public void setCourierType(CourierType courierType) {
        this.courierType = courierType;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Corier{" +
                "courierType=" + courierType +
                ", rating=" + rating +
                '}';
    }
}
