/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bibliotica;

public class ListaCategorias {

    private NodoListaCategorias primerNodo;
    private NodoListaCategorias ultimoNodo;

    public ListaCategorias() {
        this.primerNodo = null;
        this.ultimoNodo = null;
    }

    public boolean estaVacia() {
        return primerNodo == null;
    }

    public void agregarCategoria(DatoListaCategorias datoCategoria) {
        NodoListaCategorias nuevoNodo = new NodoListaCategorias(datoCategoria);

        if (estaVacia()) {
            primerNodo = nuevoNodo;
            ultimoNodo = nuevoNodo;
        } else {
            ultimoNodo.setSiguiente(nuevoNodo);
            ultimoNodo = nuevoNodo;
        }
        ultimoNodo.setSiguiente(primerNodo);
    }

    public void agregarCategoriaNovela() {
        DatoListaCategorias categoriaNovela = new DatoListaCategorias();
        categoriaNovela.setIdCategoria(3); //insertar o asignar un ID único para novela
        categoriaNovela.setNombreCategoria("Novela");
        agregarCategoria(categoriaNovela);
    }

    public NodoListaCategorias getPrimerNodo() {
        return primerNodo;
    }
}

