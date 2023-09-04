package ar.edu.unlu.poo.libreria;

public class Libro {
    private String titulo;
    private String autor;
    private int isbn;
    private int paginas;
    private int ejemplaresTotales;
    private int ejemplaresDisponibles;

    public Libro(String titulo, String autor, int paginas, int ejemplaresTotales, int ejemplaresDisponibles) {
        this.titulo = titulo;
        this.autor = autor;
        this.paginas = paginas;
        this.ejemplaresTotales = ejemplaresTotales;
        this.ejemplaresDisponibles = ejemplaresDisponibles;
    }

    public Libro(String titulo, String autor, int paginas, int isbn, int ejemplaresTotales, int ejemplaresDisponibles) {
        this.titulo = titulo;
        this.autor = autor;
        this.paginas = paginas;
        this.isbn = isbn;
        this.ejemplaresTotales = ejemplaresTotales;
        this.ejemplaresDisponibles = ejemplaresDisponibles;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public String getAutor() {
        return this.autor;
    }

    public int getIsbn() {
        return this.isbn;
    }

    public int getPaginas() {
        return this.paginas;
    }

    public int getEjemplaresTotales() {
        return this.ejemplaresTotales;
    }

    public int getEjemplaresDisponibles() {
        return this.ejemplaresDisponibles;
    }

    public void setEjemplaresTotales(int ejemplaresTotales) {
        this.ejemplaresTotales = ejemplaresTotales;
    }

    public void setEjemplaresDisponibles(int ejemplaresDisponibles) {
        this.ejemplaresDisponibles = ejemplaresDisponibles;
    }

    public void prestar() {
        if (this.ejemplaresDisponibles > 1) {
            this.ejemplaresDisponibles--;
            System.out.printf("prestamo de \"%s\" realizado.\n", this.titulo);
        } else {
            System.out.printf("No se puede realizar el prestamos de \"%s\", queda un ejemplar.\n", this.titulo);
        }
    }
    public void devolver() {
        if (this.ejemplaresDisponibles < this.ejemplaresTotales) {
            this.ejemplaresDisponibles++;
            System.out.println("Devolucion realizada!\n");
        } else {
            System.out.println("No se puede aceptar la devolucion, todos los ejemplares fueron devueltos\n");
        }

    }

    public String getDescripcion() {
        return "El libro " + this.titulo + " creado por el autor " + this.autor + " tiene " + this.paginas + " páginas, quedan " + this.ejemplaresDisponibles + " disponibles y se prestaron " + (this.ejemplaresTotales - this.ejemplaresDisponibles) + ".\n";
    }
}
