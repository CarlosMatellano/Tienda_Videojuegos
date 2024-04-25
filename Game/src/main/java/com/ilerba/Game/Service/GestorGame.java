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
    public List<Juego> listar() throws SQLException {
        Statement consulta = c.conectar().createStatement();
        ResultSet rs = consulta.executeQuery("SELECT * FROM almacen");
        List<Juego> lista = new ArrayList<>();

        while (rs.next()) {
            Juego j = new Juego(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("categoria"),
                    rs.getDouble("precio"),
                    rs.getString("pegi"),
                    rs.getInt("unidades")
            );
            lista.add(j);
        }
        rs.close();
        consulta.close();
        return lista;
    }    
}
