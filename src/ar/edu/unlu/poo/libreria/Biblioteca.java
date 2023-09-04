package ar.edu.unlu.poo.libreria;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Libro> libros;

    public Biblioteca() {
        this.libros = new ArrayList<>();
    }

    public void agregarLibro(Libro libro) {
        this.libros.add(libro);
    }

    public int prestamosTotales() {
        int total = 0;
        for(Libro l:libros){
            total = total + (l.getEjemplaresTotales() - l.getEjemplaresDisponibles());
        }
        return total;
    }

    public List<Libro> getLibros() {
        return this.libros;
    }
}
