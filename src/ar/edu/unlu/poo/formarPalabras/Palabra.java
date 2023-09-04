package ar.edu.unlu.poo.formarPalabras;

public class Palabra {
    private String palabra;
    private int puntaje;

    public Palabra(String palabra) {
        this.palabra = palabra.toLowerCase();
        this.puntaje = this.puntaje();
    }

    public String getPalabra() {
        return this.palabra;
    }

    public int puntaje() {
        int total = 0;
        for(int i = 0; i < this.palabra.length(); ++i) {
            char letra = this.palabra.charAt(i);
            if (letra != 'w' && letra != 'k' && letra != 'z' && letra != 'y' && letra != 'q') {
                ++total;
            } else {
                total += 2;
            }
        }

        return total;
    }

    public int getPuntaje() {
        return this.puntaje;
    }
}
