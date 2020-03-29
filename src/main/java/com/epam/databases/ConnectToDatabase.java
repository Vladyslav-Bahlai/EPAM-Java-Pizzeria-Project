package com.epam.databases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectToDatabase {
    private static String DB_DRIVER = "org.h2.Driver";
    private static String DB_CONNECTION = "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1";
    private static String DB_USER = "";
    private static String DB_PASSWORD = "";

    public static Connection createConnection(){
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
