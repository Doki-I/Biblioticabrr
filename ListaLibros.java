/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bibliotica;

public class ListaLibros {

    private NodoListaLibros inicio;
    private NodoListaLibros fin;

    public ListaLibros() {
        this.inicio = null;
        this.fin = null;
    }

    public boolean vacia() {
        return inicio == null;
    }

    public void insertar(Libros libro) {
        NodoListaLibros nuevoNodo = new NodoListaLibros();
        nuevoNodo.setElemento(libro);

        if (vacia()) {
            inicio = nuevoNodo;
            fin = inicio;
            fin.setSiguiente(inicio);
        } else if (libro.getIdLibro() < inicio.getElemento().getIdLibro()) {
            nuevoNodo.setSiguiente(inicio);
            inicio.setAnterior(nuevoNodo);
            inicio = nuevoNodo;
            fin.setSiguiente(inicio);
        } else if (libro.getIdLibro() > fin.getElemento().getIdLibro()) {
            fin.setSiguiente(nuevoNodo);
            nuevoNodo.setAnterior(fin);
            fin = nuevoNodo;
            fin.setSiguiente(inicio);
            inicio.setAnterior(fin);
        } else {
            NodoListaLibros aux = inicio;
            while (aux.getSiguiente().getElemento().getIdLibro() < libro.getIdLibro()) {
                aux = aux.getSiguiente();
            }

            nuevoNodo.setSiguiente(aux.getSiguiente());
            nuevoNodo.setAnterior(aux);
            aux.getSiguiente().setAnterior(nuevoNodo);
            aux.setSiguiente(nuevoNodo);
        }
    }

    public void imprimirLibros() {
        if (vacia()) {
            System.out.println("La lista de libros está vacía.");
        } else {
            NodoListaLibros aux = inicio;
            do {
                Libros libro = aux.getElemento();
                System.out.println("ID: " + libro.getIdLibro()
                        + ", Nombre: " + libro.getNombre()
                        + ", Autor: " + libro.getAutor()
                        + ", Editorial: " + libro.getEditorial()
                        + ", Categoría: " + libro.getCategoria());
                aux = aux.getSiguiente();
            } while (aux != inicio);
        }
    }

    public Libros buscarLibro(int idLibro) {
        if (vacia()) {
            return null;
        } else {
            NodoListaLibros aux = inicio;
            do {
                if (aux.getElemento().getIdLibro() == idLibro) {
                    return aux.getElemento();
                }
                aux = aux.getSiguiente();
            } while (aux != inicio);
        }
        return null;
    }

    public boolean eliminarLibro(int idLibro) {
        if (vacia()) {
            return false;
        } else {
            NodoListaLibros aux = inicio;
            do {
                if (aux.getElemento().getIdLibro() == idLibro) {
                    if (aux == inicio) {
                        if (inicio == fin) {
                            inicio = null;
                            fin = null;
                        } else {
                            inicio = inicio.getSiguiente();
                            inicio.setAnterior(fin);
                            fin.setSiguiente(inicio);
                        }
                    } else if (aux == fin) {
                        fin = fin.getAnterior();
                        fin.setSiguiente(inicio);
                        inicio.setAnterior(fin);
                    } else {
                        aux.getAnterior().setSiguiente(aux.getSiguiente());
                        aux.getSiguiente().setAnterior(aux.getAnterior());
                    }
                    return true;
                }
                aux = aux.getSiguiente();
            } while (aux != inicio);
        }
        return false;
    }

    @Override
    public String toString() {
        if (vacia()) {
            return "Lista vacía";
        } else {
            StringBuilder s = new StringBuilder();
            NodoListaLibros aux = inicio;
            do {
                Libros libro = aux.getElemento();
                s.append("ID: ").append(libro.getIdLibro())
                        .append(", Nombre: ").append(libro.getNombre())
                        .append(", Autor: ").append(libro.getAutor())
                        .append(", Editorial: ").append(libro.getEditorial())
                        .append(", Categoría: ").append(libro.getCategoria())
                        .append(" → ");
                aux = aux.getSiguiente();
            } while (aux != inicio);
            return s.toString();
        }
    }

    NodoListaLibros getInicio() {
        return inicio;
    }
}

