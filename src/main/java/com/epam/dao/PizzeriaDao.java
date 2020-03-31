package com.epam.dao;

import com.epam.models.Pizzeria;

import java.util.List;

/**
 * Provides methods to implement Pizzeria Dao class with CRUD operations
 */
public interface PizzeriaDao {

    void createPizzeriaTable();

    void addPizzeria(Pizzeria pizzeria);

    Pizzeria getPizzeriaById(int pizzeriaId);

    List<Pizzeria> getAllPizzerias();

    void updatePizzeria(Pizzeria pizzeria);

    void deletePizzeria(int pizzeriaId);
}
