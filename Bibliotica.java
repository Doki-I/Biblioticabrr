/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.bibliotica;
import javax.swing.JOptionPane;

public class Bibliotica {

    public static void main(String[] args) {
        ListaCategorias listaCategorias = new ListaCategorias();
        ListaLibros listaLibros = new ListaLibros();

        DatoListaCategorias categoria1 = new DatoListaCategorias();
        categoria1.setIdCategoria(1);
        categoria1.setNombreCategoria("Accion");

        DatoListaCategorias categoria2 = new DatoListaCategorias();
        categoria2.setIdCategoria(2);
        categoria2.setNombreCategoria("Ciencia");

        DatoListaCategorias categoria3 = new DatoListaCategorias();
        categoria3.setIdCategoria(3);
        categoria3.setNombreCategoria("Romance");

        DatoListaCategorias categoria4 = new DatoListaCategorias();
        categoria4.setIdCategoria(4);
        categoria4.setNombreCategoria("Misterio");

        listaCategorias.agregarCategoria(categoria1);
        listaCategorias.agregarCategoria(categoria2);
        listaCategorias.agregarCategoria(categoria3);
        listaCategorias.agregarCategoria(categoria4);
        

        Libros libro1 = new Libros();
        libro1.setIdLibro(1);
        libro1.setNombre("1984");
        libro1.setCategoria("Accion");
        libro1.setAutor("George Orwell");
        libro1.setEditorial("Debolsillo");

        Libros libro2 = new Libros();
        libro2.setIdLibro(2);
        libro2.setNombre("Cien años de soledad");
        libro2.setCategoria("Accion");
        libro2.setAutor("Gabriel García Márquez");
        libro2.setEditorial("Cien años de soledad");

        listaLibros.insertar(libro1);
        listaLibros.insertar(libro2);

        //Menú interactivo con JOptionPane
        String[] opciones = {"Agregar Libro", "Eliminar Libro", "Ver Libros", "Salir"};

        while (true) {
            String opcionSeleccionada = (String) JOptionPane.showInputDialog(null,
                    "Selecciona una opción:", "Bibliotica", JOptionPane.PLAIN_MESSAGE,
                    null, opciones, opciones[0]);

            if (opcionSeleccionada == null || opcionSeleccionada.equals("Salir")) {
                JOptionPane.showMessageDialog(null, "¡Hasta luego!", "Bibliotica", JOptionPane.INFORMATION_MESSAGE);
                break;
            }

            switch (opcionSeleccionada) {
                case "Agregar Libro":
                    agregarLibro(listaLibros, listaCategorias);
                    break;
                case "Eliminar Libro":
                    eliminarLibro(listaLibros);
                    break;
                case "Ver Libros":
                    verLibros(listaLibros);
                    break;
                default:
                    break;
            }
        }
    }

    private static void agregarLibro(ListaLibros listaLibros, ListaCategorias listaCategorias) {
        Libros nuevoLibro = new Libros();

        try {
            int idLibro = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del libro:"));
            nuevoLibro.setIdLibro(idLibro);

            String nombre = JOptionPane.showInputDialog("Ingrese el nombre del libro:");
            nuevoLibro.setNombre(nombre);

            String autor = JOptionPane.showInputDialog("Ingrese el nombre del autor:");
            nuevoLibro.setAutor(autor);

            String editorial = JOptionPane.showInputDialog("Ingrese el nombre de la editorial:");
            nuevoLibro.setEditorial(editorial);

            //Mostrar categorías disponibles para seleccionar
            StringBuilder opcionesCategorias = new StringBuilder();
            NodoListaCategorias actual = listaCategorias.getPrimerNodo();
            do {
                DatoListaCategorias categoria = actual.getDato();
                opcionesCategorias.append(categoria.getIdCategoria()).append(". ")
                        .append(categoria.getNombreCategoria()).append("\n");
                actual = actual.getSiguiente();
            } while (actual != listaCategorias.getPrimerNodo());

            int idCategoriaSeleccionada = Integer.parseInt(JOptionPane.showInputDialog(
                    "Seleccione la categoría del libro:\n" + opcionesCategorias.toString()));

            //Asociar la categoría seleccionada al libro
            actual = listaCategorias.getPrimerNodo();
            do {
                DatoListaCategorias categoria = actual.getDato();
                if (categoria.getIdCategoria() == idCategoriaSeleccionada) {
                    nuevoLibro.setCategoria(categoria.getNombreCategoria());
                    break;
                }
                actual = actual.getSiguiente();
            } while (actual != listaCategorias.getPrimerNodo());

            //Insertar el nuevo libro en la lista de libros
            listaLibros.insertar(nuevoLibro);

            JOptionPane.showMessageDialog(null, "Libro agregado exitosamente.", "Bibliotica", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error: Ingrese un número válido para el ID del libro.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void eliminarLibro(ListaLibros listaLibros) {
        try {
            int idLibro = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del libro a eliminar:"));
            boolean eliminado = listaLibros.eliminarLibro(idLibro);
            if (eliminado) {
                JOptionPane.showMessageDialog(null, "Libro eliminado exitosamente.", "Bibliotica", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró un libro con ese ID.", "Bibliotica", JOptionPane.WARNING_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error: Ingrese un número válido para el ID del libro.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void verLibros(ListaLibros listaLibros) {
        StringBuilder librosStr = new StringBuilder();
        NodoListaLibros aux = listaLibros.getInicio();
        do {
            Libros libro = aux.getElemento();
            librosStr.append("ID: ").append(libro.getIdLibro())
                    .append(", Nombre: ").append(libro.getNombre())
                    .append(", Autor: ").append(libro.getAutor())
                    .append(", Editorial: ").append(libro.getEditorial())
                    .append(", Categoría: ").append(libro.getCategoria()) //Incluir la categoría en la impresión
                    .append("\n");
            aux = aux.getSiguiente();
        } while (aux != listaLibros.getInicio());

        JOptionPane.showMessageDialog(null, librosStr.toString(), "Lista de Libros", JOptionPane.PLAIN_MESSAGE);
    }
}
