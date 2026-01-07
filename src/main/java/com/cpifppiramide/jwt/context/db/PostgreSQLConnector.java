package com.cpifppiramide.jwt.context.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgreSQLConnector {

    private static Connection connection;

    private PostgreSQLConnector(){
    }

    public static Connection getInstance() {
        if(connection == null) {
            try {
                connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/springjwt", "postgres", "postgres");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return PostgreSQLConnector.connection;
    }

}
