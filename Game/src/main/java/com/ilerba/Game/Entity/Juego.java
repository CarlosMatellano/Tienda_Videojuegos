/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ilerba.Game.Entity;

/**
 *
 * @author Alumno
 */
public class Juego {
    private int id;
    private String nombre;
    private String categoria;
    private Double precio;
    private String pegi;
    private int unidades;

    public Juego(String nombre, String categoria, Double precio, String pegi, int unidades) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
        this.pegi = pegi;
        this.unidades = unidades;
    }

    public Juego(int id, String nombre, String categoria, Double precio, String pegi, int unidades) {
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
        this.pegi = pegi;
        this.unidades = unidades;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getPegi() {
        return pegi;
    }

    public void setPegi(String pegi) {
        this.pegi = pegi;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }
    
    @Override
    public String toString() {

        return String.format("%-4d %-20s %-20s %-15s %-25s %-35s",
                id,
                nombre,
                categoria,
                precio,
                pegi,
                unidades);
    }    
}
