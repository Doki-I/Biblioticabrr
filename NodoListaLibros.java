/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bibliotica;

public class NodoListaLibros {
    private Libros elemento;
    private NodoListaLibros siguiente;
    private NodoListaLibros anterior;

    public NodoListaLibros() {
        this.siguiente = null;
        this.anterior = null;
    }

    public Libros getElemento() {
        return elemento;
    }

    public void setElemento(Libros elemento) {
        this.elemento = elemento;
    }

    public NodoListaLibros getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoListaLibros siguiente) {
        this.siguiente = siguiente;
    }

    public NodoListaLibros getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoListaLibros anterior) {
        this.anterior = anterior;
    }
}
