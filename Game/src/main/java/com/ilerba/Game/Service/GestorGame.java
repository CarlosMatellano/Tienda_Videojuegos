/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ilerba.Game.Service;

import com.ilerba.Game.Database.Conexion;
import com.ilerba.Game.Entity.Juego;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alumno
 */
public class GestorGame {

    Conexion c = new Conexion();

    public void alta(Juego j) throws SQLException {
        Statement consulta = c.conectar().createStatement();
        // Conversión de Date a String. tratamiento de la fecha para que sea aceptada por MySQL
        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //String strFechaFormateada = sdf.format(p.getFechaNacimiento());
        // estring de inserción
        String cadena = "INSERT INTO almacen(nombre_juego, categoria, precio, pegi, unidades) VALUES ('"
                + j.getNombre() + "','"
                + j.getCategoria() + "','"
                + j.getPrecio() + "','"
                + j.getPegi() + "','"
                + j.getUnidades() + "');";
        //System.out.println(cadena);
        consulta.executeUpdate(cadena);
        consulta.close();
    }

    public void baja(int id) throws SQLException {
        try (Statement consulta = c.conectar().createStatement()) {
            String sql = "UPDATE juego SET unidades = unidades - ? WHERE id = ?";
            consulta.execute(sql);
        } catch (SQLException e) {
            e.getStackTrace();
        }
    }

    public List<Juego> listar() throws SQLException {
        Statement consulta = c.conectar().createStatement();
        ResultSet rs = consulta.executeQuery("SELECT * FROM almacen");
        List<Juego> lista = new ArrayList<>();

        while (rs.next()) {
            Juego j = new Juego(
                    rs.getInt("id"),
                    rs.getString("nombre_juego"),
                    rs.getString("categoria"),
                    rs.getDouble("precio"),
                    rs.getInt("pegi"),
                    rs.getInt("unidades")
            );
            lista.add(j);
        }
        rs.close();
        consulta.close();
        return lista;
    }
}
