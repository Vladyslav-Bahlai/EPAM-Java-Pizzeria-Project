package com.epam.models;

import java.util.List;

public class Pizzeria {
    private int id;
    private String adress;
    private String workingHours;
    private List<Employee> employeeList;
    private List<Product> productList;

    public Pizzeria() { }

    public Pizzeria(int id, String adress, String workingHours) {
        this.id = id;
        this.adress = adress;
        this.workingHours = workingHours;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(String workingHours) {
        this.workingHours = workingHours;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    public String toString() {
        return "Pizzeria{" +
                "id=" + id +
                ", adress='" + adress + '\'' +
                ", workingHours='" + workingHours + '\'' +
                ", employeeList=" + employeeList +
                ", productList=" + productList +
                '}';
    }
}
