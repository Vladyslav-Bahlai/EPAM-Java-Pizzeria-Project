package com.epam.dao;


import com.epam.databases.ConnectToDatabase;
import com.epam.models.Pizzeria;
import com.sun.istack.internal.NotNull;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Implements <code>PizzeriaDao</code> interface and provides a functionality
 * to do CRUD operations on <code>Pizzeria</code> class
 */
public class PizzeriaDaoImpl implements PizzeriaDao{
    private final String createQuery = "CREATE TABLE PIZZERIA(id int primary key, " +
            "address varchar(255), workingHours varchar(255))";
    private final String insertQuery = "INSERT INTO PIZZERIA" + "(id, address, workingHours) values" + "(?,?,?)";
    private final String getbyIdQuery = "SELECT * FROM PIZZERIA WHERE id=?";
    private final String getAllQuery = "SELECT * FROM PIZZERIA";
    private final String updateQuery = "UPDATE PIZZERIA SET adress=?, workingHours=? WHERE id=?";
    private final String deleteQuery = "DELETE FROM PIZZERIA WHERE id=?";

    @Override
    public void createPizzeriaTable() {
        Connection connection = ConnectToDatabase.createConnection();

        if (connection != null){
            try (Statement createStatement = connection.createStatement()) {
                createStatement.execute(createQuery);
            } catch (SQLException e){
                System.out.println(e.getMessage());
            } finally {
                closeConnection(connection);
            }
        } else {
            System.out.println("Connection is null");
        }
    }

    @Override
    public void addPizzeria(Pizzeria pizzeria) {
        Connection connection = ConnectToDatabase.createConnection();

        if (connection != null){
            try (PreparedStatement insertPreparedStatement = connection.prepareStatement(insertQuery)) {
                insertPreparedStatement.setInt(1, pizzeria.getId());
                insertPreparedStatement.setString(2, pizzeria.getAddress());
                insertPreparedStatement.setString(3, pizzeria.getWorkingHours());
                insertPreparedStatement.executeUpdate();
            } catch (SQLException e){
                System.out.println(e.getMessage());
            } finally {
                closeConnection(connection);
            }
        } else {
            System.out.println("Connection is null");
        }
    }

    @Override
    public Pizzeria getPizzeriaById(int pizzeriaId) {
        Connection connection = ConnectToDatabase.createConnection();
        Pizzeria pizzeria = null;

        if (connection != null){
            try (PreparedStatement getByIdPreparedStatement = connection.prepareStatement(getbyIdQuery)) {
                getByIdPreparedStatement.setInt(1, pizzeriaId);

                try (ResultSet resultSet = getByIdPreparedStatement.executeQuery()) {
                    pizzeria = new Pizzeria();

                    while (resultSet.next()) {
                        pizzeria.setId(resultSet.getInt(1));
                        pizzeria.setAddress(resultSet.getString(2));
                        pizzeria.setWorkingHours(resultSet.getString(3));
                    }
                }
            } catch (SQLException e){
                e.getMessage();
            } finally {
                closeConnection(connection);
            }
        } else {
            System.out.println("Connection is null");
        }

        return pizzeria;
    }

    @Override
    public List<Pizzeria> getAllPizzerias() {
        Connection connection = ConnectToDatabase.createConnection();
        List<Pizzeria> pizzeriaList = new ArrayList<>();

        if (connection != null){
            try (Statement getAllStatement = connection.createStatement()){
                try (ResultSet resultSet = getAllStatement.executeQuery(getAllQuery)){
                    while (resultSet.next()) {
                        Pizzeria pizzeria = new Pizzeria();
                        pizzeria.setId(resultSet.getInt(1));
                        pizzeria.setAddress(resultSet.getString(2));
                        pizzeria.setWorkingHours(resultSet.getString(3));
                        pizzeriaList.add(pizzeria);
                    }
                }
            } catch (SQLException e){
                e.getMessage();
            } finally {
                closeConnection(connection);
            }
        } else {
            System.out.println("Connection is null");
        }

        return pizzeriaList;
    }

    @Override
    public void updatePizzeria(Pizzeria pizzeria) {
        Connection connection = ConnectToDatabase.createConnection();

        if (connection != null){
            try (PreparedStatement updateStatement = connection.prepareStatement(updateQuery)){
                updateStatement.setString(1, pizzeria.getAddress());
                updateStatement.setString(2, pizzeria.getWorkingHours());
                updateStatement.setInt(3, pizzeria.getId());
                updateStatement.executeUpdate();
            } catch (SQLException e){
                e.getMessage();
            } finally {
                closeConnection(connection);
            }
        } else {
            System.out.println("Connection is null");
        }
    }

    @Override
    public void deletePizzeria(int pizzeriaId) {
        Connection connection = ConnectToDatabase.createConnection();

        if (connection != null){
            try (PreparedStatement deletePreparedStatement = connection.prepareStatement(deleteQuery)){
                deletePreparedStatement.setInt(1, pizzeriaId);
                deletePreparedStatement.executeUpdate();
            } catch (SQLException e){
                e.getMessage();
            } finally {
                closeConnection(connection);
            }
        } else {
            System.out.println("Connection is null");
        }
    }

    private void closeConnection(Connection connection){
        try {
            connection.close();
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
