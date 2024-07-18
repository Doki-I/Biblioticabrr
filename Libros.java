/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bibliotica;

public class Libros {
    private int idLibro;
    private String nombre;
    private String autor;
    private String editorial;
    private String categoria; 

    public Libros() {
        this.idLibro = 0;
        this.nombre = "";
        this.autor = "";
        this.editorial = "";
        this.categoria = "";
    }

    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "ID: " + idLibro + ", Nombre: " + nombre + ", Autor: " + autor + ", Editorial: " + editorial + ", Categoría: " + categoria;
    }
}
