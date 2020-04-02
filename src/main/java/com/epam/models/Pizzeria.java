package com.epam.models;

import java.util.List;

public class Pizzeria {
    private int id;
    private String address;
    private String workingHours;
    private List<Employee> employeeList;
    private List<Product> productList;

    public Pizzeria() { }

    public Pizzeria(String address, String workingHours) {
        this.address = address;
        this.workingHours = workingHours;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
                ", address='" + address + '\'' +
                ", workingHours='" + workingHours + '\'' +
                ", employeeList=" + employeeList +
                ", productList=" + productList +
                '}';
    }
}
