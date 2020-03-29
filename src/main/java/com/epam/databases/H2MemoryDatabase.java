package com.epam.databases;

import org.h2.tools.Server;

import java.sql.*;

public class H2MemoryDatabase {


    public static void createWithPreparedStatement()
            throws SQLException {
        Connection connection = ConnectToDatabase.createConnection();
        PreparedStatement createPreparedStatement = null;
        String createQuery = "CREATE TABLE PERSON(id int primary key, name varchar(255))";

        try{
            connection.setAutoCommit(false);

            createPreparedStatement = connection.prepareStatement(createQuery);
            createPreparedStatement.executeUpdate();
            createPreparedStatement.close();

            connection.commit();
        } catch (SQLException e){
            System.out.println(e.getMessage());
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            connection.close();
        }

    }

    public static void insertWithPreparedStatement(int id, String name)
            throws SQLException {
        Connection connection = ConnectToDatabase.createConnection();
        PreparedStatement insertPreparedStatement = null;
        String insertQuery = "INSERT INTO PERSON" + "(id, name) values" + "(?,?)";

        try{
            connection.setAutoCommit(false);
            insertPreparedStatement = connection.prepareStatement(insertQuery);
            insertPreparedStatement.setInt(1, id);
            insertPreparedStatement.setString(2, name);
            insertPreparedStatement.executeUpdate();
            insertPreparedStatement.close();

            connection.commit();
        } catch (SQLException e){
            System.out.println(e.getMessage());
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            connection.close();
        }
    }

    public static void selectWithPreparedStatement()
            throws SQLException {
        Connection connection = ConnectToDatabase.createConnection();
        PreparedStatement selectPreparedStatement = null;
        String selectQuery = "select * from PERSON";

        try {
            connection.setAutoCommit(false);
            selectPreparedStatement = connection.prepareStatement(selectQuery);
            ResultSet resultSet = selectPreparedStatement.executeQuery();

            while (resultSet.next()){
                System.out.println(
                        "Id: " + resultSet.getInt("id") +
                        " Name: " + resultSet.getString("name"));
            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            connection.close();
        }
    }
}
