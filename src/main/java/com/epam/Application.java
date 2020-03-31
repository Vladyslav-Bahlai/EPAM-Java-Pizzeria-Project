package com.epam;

import com.epam.dao.PizzeriaDaoImpl;
import com.epam.databases.H2MemoryDatabase;
import com.epam.models.Person;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) throws SQLException {
        List<Person> personList = new ArrayList<Person>();
        {
            personList.add(new Person(1, "Adam"));
            personList.add(new Person(2, "John"));
            personList.add(new Person(3, "Tomas"));
            personList.add(new Person(4, "Emily"));
            personList.add(new Person(5, "Krista"));
        }

        PizzeriaDaoImpl pizzeriaDao = new PizzeriaDaoImpl();
        pizzeriaDao.createPizzeriaTable();

        System.out.println("Successful db operations");
    }
}
