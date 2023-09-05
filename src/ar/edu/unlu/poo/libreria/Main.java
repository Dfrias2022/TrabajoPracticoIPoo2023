package ar.edu.unlu.poo.libreria;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        Biblioteca condor = new Biblioteca();
        Libro libro1 = new Libro("El principito", "Antoine de Saint-Exupéry", 120, 10, 10);
        Libro libro2 = new Libro("la guerra de los mundos", "Herbert George Wells", 320, 1, 1);
        condor.agregarLibro(libro1);
        condor.agregarLibro(libro2);
        for(Libro l: condor.getLibros()){
            System.out.println(l.getDescripcion());
        }
//Libro con mayor cantidad de paginas
        if (libro1.getPaginas() > libro2.getPaginas()) {
            System.out.printf("El libro \"%s\" tiene mas paginas (%d) que el libro \"%s\" (%d).\n", libro1.getTitulo(), libro1.getPaginas(), libro2.getTitulo(), libro2.getPaginas());
        } else if (libro1.getPaginas() < libro2.getPaginas()) {
            System.out.printf("El libro \"%s\" tiene mas paginas (%d) que el libro \"%s\" (%d).\n", libro2.getTitulo(), libro2.getPaginas(), libro1.getTitulo(), libro1.getPaginas());
        } else {
            System.out.printf("Los libros \"%s\" y \"%s\" tienen la misma cantidad de paginas.\n", libro1.getTitulo(), libro2.getTitulo());
        }

        System.out.println("----Prestamos----");
//Simula 10 prestamos
        for(int i = 0; i < 10; ++i) {
            (condor.getLibros().get(0)).prestar();
            System.out.println((condor.getLibros().get(0)).getDescripcion());
        }
//Se intenta prestar un libro que tiene solo 1 ejemplar disponible
        (condor.getLibros().get(1)).prestar();
        System.out.println((condor.getLibros().get(1)).getDescripcion());
        System.out.printf("Se realizaron %d prestamos en total.\n", condor.prestamosTotales());
    }
}
