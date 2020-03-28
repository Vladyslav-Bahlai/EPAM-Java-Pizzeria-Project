package com.epam.databases;

import org.h2.tools.Server;

import java.sql.*;

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

    public static void selectWithPreparedStatement(String selectQuery)
            throws SQLException {
        Connection connection = getDBConection();
        PreparedStatement selectPreparedStatement = null;

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

    public static void openServerModeInBrowser() throws SQLException {
        Server server = Server.createTcpServer().start();
        System.out.println("Server started and connection is open.");
        System.out.println("URL: jdbc:h2:" + server.getURL() + "/mem:test");
    }
}
