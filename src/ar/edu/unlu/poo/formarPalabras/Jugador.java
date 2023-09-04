package ar.edu.unlu.poo.formarPalabras;

import java.util.ArrayList;
import java.util.List;

public class Jugador {
    private List<Palabra> palabras;
    private String nombre;

    public Jugador(String nombre) {
        this.nombre = nombre;
        palabras = new ArrayList<>();
    }

    public void agregarPalabra(Palabra palabra) {
        this.palabras.add(palabra);
    }

    public String getNombre() {
        return this.nombre;
    }

    public List<Palabra> getPalabras() {
        return this.palabras;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Palabra generarPalabra(String palabra, Diccionario diccionarioPalabras) {
        for(Palabra p:diccionarioPalabras.getListaPalabrasValidas()){
            if(p.getPalabra().equals(palabra)){
                return p;
            }
        }
        return null;
    }

    public int puntajeTotal() {
        int total = 0;
        Palabra palabra;
        for(Palabra p:palabras){
            total = total + p.getPuntaje();
        }
        return total;
    }
}
