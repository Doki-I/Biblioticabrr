/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bibliotica;

public class NodoListaCategorias {
    private DatoListaCategorias dato;
    private NodoListaCategorias siguiente;

    public NodoListaCategorias(DatoListaCategorias dato) {
        this.dato = dato;
        this.siguiente = null;
    }

    public DatoListaCategorias getDato() {
        return dato;
    }

    public void setDato(DatoListaCategorias dato) {
        this.dato = dato;
    }

    public NodoListaCategorias getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoListaCategorias siguiente) {
        this.siguiente = siguiente;
    }
}
