/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bibliotica;

public class ListaCategorias {
    private NodoListaCategorias primerNodo;

    public ListaCategorias() {
        this.primerNodo = null;
    }

    public NodoListaCategorias getPrimerNodo() {
        return primerNodo;
    }

    public void setPrimerNodo(NodoListaCategorias primerNodo) {
        this.primerNodo = primerNodo;
    }

    public void agregarCategoria(DatoListaCategorias datoCategoria) {
        NodoListaCategorias nuevoNodo = new NodoListaCategorias(datoCategoria);

        if (primerNodo == null) {
            primerNodo = nuevoNodo;
            primerNodo.setSiguiente(primerNodo);
        } else {
            NodoListaCategorias ultimo = primerNodo;
            while (ultimo.getSiguiente() != primerNodo) {
                ultimo = ultimo.getSiguiente();
            }
            ultimo.setSiguiente(nuevoNodo);
            nuevoNodo.setSiguiente(primerNodo);
        }
    }
}
