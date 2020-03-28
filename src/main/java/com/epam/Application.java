package com.epam;

import com.epam.databases.H2MemoryDatabase;

import java.sql.SQLException;

public class Application {
    public static void main(String[] args) throws SQLException {
        H2MemoryDatabase.openServerModeInBrowser();

        H2MemoryDatabase.createWithPreparedStatement(
                "CREATE TABLE PERSON(id int primary key, name varchar(255))");

        H2MemoryDatabase.insertWithPreparedStatement(
                "INSERT INTO PERSON" + "(id, name) values" + "(?,?)");

        H2MemoryDatabase.selectWithPreparedStatement(
                "select * from PERSON");

        System.out.println("Successful db operations");
    }
}
