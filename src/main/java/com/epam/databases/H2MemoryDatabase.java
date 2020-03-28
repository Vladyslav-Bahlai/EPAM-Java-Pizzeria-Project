package com.epam.databases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class H2MemoryDatabase {
    private static String DB_DRIVER = "org.h2.Driver";
    private static String DB_CONNECTION = "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1";
    private static String DB_USER = "";
    private static String DB_PASSWORD = "";

    public static void createWithPreparedStatement(String createQuery)
            throws SQLException {
        Connection connection = getDBConection();
        PreparedStatement createPreparedStatement = null;

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

    public static void insertWithPreparedStatement(String insertQuery)
            throws SQLException {
        Connection connection = getDBConection();
        PreparedStatement insertPreparedStatement = null;

        try{
            connection.setAutoCommit(false);
            insertPreparedStatement = connection.prepareStatement(insertQuery);
            insertPreparedStatement.setInt(1, 1);
            insertPreparedStatement.setString(2, "Vlad");
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

    private static Connection getDBConection(){
        Connection dbConnection = null;

        // registering the JDBC database driver.
        try{
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

        // opening a connection to DB
        try{
            dbConnection = DriverManager.getConnection(
                    DB_CONNECTION,
                    DB_USER,
                    DB_PASSWORD);

            return dbConnection;
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }

        return dbConnection;
    }
}
