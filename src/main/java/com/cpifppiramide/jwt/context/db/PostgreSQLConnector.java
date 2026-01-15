package com.cpifppiramide.jwt.context.db;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Component // 1. Marcamos la clase para que Spring la gestione
public class PostgreSQLConnector {

    // 2. Definimos variables para los datos del properties
    private static String dbUrl;
    private static String dbUser;
    private static String dbPass;

    private static Connection connection;

    // 3. Spring inyecta los valores a través de los setters
    @Value("${spring.datasource.url}")
    public void setDbUrl(String url) {
        PostgreSQLConnector.dbUrl = url;
    }

    @Value("${spring.datasource.username}")
    public void setDbUser(String user) {
        PostgreSQLConnector.dbUser = user;
    }

    @Value("${spring.datasource.password}")
    public void setDbPass(String pass) {
        PostgreSQLConnector.dbPass = pass;
    }

    private PostgreSQLConnector(){
    }

    public static Connection getInstance() {
        if(connection == null) {
            try {
                // 4. Usamos las variables inyectadas en lugar de texto fijo
                connection = DriverManager.getConnection(dbUrl, dbUser, dbPass);
                System.out.println("Conexión establecida con éxito a: " + dbUrl);
            } catch (SQLException e) {
                throw new RuntimeException("Error conectando a la base de datos", e);
            }
        }
        return PostgreSQLConnector.connection;
    }
}