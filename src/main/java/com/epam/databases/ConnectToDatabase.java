package com.epam.databases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Allows to create a connection to a database which is described in static fields
 * <code>DB_DRIVER</code>
 * <code>DB_CONNECTION</code>
 * <code>DB_USER</code>
 * <code>DB_PASSWORD</code>
 */
public class ConnectToDatabase {
    private static final String DB_DRIVER = "org.h2.Driver";
    private static final String DB_CONNECTION = "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1";
    private static final String DB_USER = "";
    private static final String DB_PASSWORD = "";

    /**
     * Creates a connection to database and returns it
     *
     * @return Connection object to database or null if something went wrong
     */
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
