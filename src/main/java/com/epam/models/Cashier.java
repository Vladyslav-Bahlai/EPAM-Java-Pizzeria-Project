package com.epam.models;

import com.epam.enums.Position;

public class Cashier extends Employee {
    private boolean isPartJanitor;

    public Cashier() { }

    public Cashier(int id, String fullName, int age, int salary, int pizzeriaId, Position position, boolean isPartJanitor) {
        super(id, fullName, age, salary, pizzeriaId, position);
        this.isPartJanitor = isPartJanitor;
    }

    public boolean isPartJanitor() {
        return isPartJanitor;
    }

    public void setPartJanitor(boolean partJanitor) {
        isPartJanitor = partJanitor;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Cashier{" +
                "isPartJanitor=" + isPartJanitor +
                '}';
    }
}
