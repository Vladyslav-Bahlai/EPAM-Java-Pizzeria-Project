package com.epam;

import com.epam.dao.PizzeriaDaoImpl;
import com.epam.models.Pizzeria;

import java.util.List;


public class Application {
    final static private PizzeriaDaoImpl pizzeriaDao = new PizzeriaDaoImpl();

    public static void main(String[] args) {

        pizzeriaDao.createPizzeriaTable();

        pizzeriaDao.addPizzeria(new Pizzeria("Lviv", "9:00 - 20:00"));
        pizzeriaDao.addPizzeria(new Pizzeria("Kyiv", "8:00 - 21:00"));
        pizzeriaDao.addPizzeria(new Pizzeria("Kharkiv", "8:30 - 21:30"));
        pizzeriaDao.addPizzeria(new Pizzeria("Dnipro", "7:30 - 22:00"));
        pizzeriaDao.addPizzeria(new Pizzeria("Odessa", "10:00 - 6:00"));

        pizzeriaDao.deletePizzeria(4);

        List<Pizzeria> pizzeriaList = pizzeriaDao.getAllPizzerias();
        pizzeriaList.forEach(System.out::println);

        System.out.println("\nBy id:");
        System.out.println(pizzeriaDao.getPizzeriaById(1));
        System.out.println(pizzeriaDao.getPizzeriaById(4));

        System.out.println("Successful db operations");
    }
}
