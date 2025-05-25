package com.playfix.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {

    private static final String URL = "jdbc:postgresql://localhost:5432/PlayFix";
    private static final String USER = "postgres";
    private static final String PASSWORD = "6087";

    static {
        try {
            Class.forName("org.postgresql.Driver");  // Carga explícita del driver
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection obtenerConexion() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

}
