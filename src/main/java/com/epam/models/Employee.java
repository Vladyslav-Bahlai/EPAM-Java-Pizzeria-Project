package com.epam.models;


import com.epam.enums.Position;

public abstract class Employee {
    private int id;
    private String fullName;
    private int age;
    private int salary;
    private int pizzeriaId;
    private Position position;

    public Employee() { }

    public Employee(int id, String fullName, int age, int salary, int pizzeriaId, Position position) {
        this.id = id;
        this.fullName = fullName;
        this.age = age;
        this.salary = salary;
        this.pizzeriaId = pizzeriaId;
        this.position = position;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getPizzeriaId() {
        return pizzeriaId;
    }

    public void setPizzeriaId(int pizzeriaId) {
        this.pizzeriaId = pizzeriaId;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", pizzeriaId=" + pizzeriaId +
                ", position=" + position +
                '}';
    }
}
