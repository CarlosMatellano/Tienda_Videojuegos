package com.ilerba.Game.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Alumno
 */
public class Conexion {
    String url = "jdbc:mysql://localhost:3306/tienda_juegos";
    String user = "root";
    String pass = "";
    Connection c;

    public Connection conectar() throws SQLException {
        c = DriverManager.getConnection(url, user, pass);
        return c;
    }
}    

