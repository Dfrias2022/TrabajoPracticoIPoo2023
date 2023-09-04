package ar.edu.unlu.poo.formarPalabras;

import java.util.ArrayList;
import java.util.List;

public class Diccionario {
    private List<Palabra> listaPalabrasValidas;

    public Diccionario() {
        this.listaPalabrasValidas = new ArrayList<>();
    }

    public List<Palabra> getListaPalabrasValidas() {
        return this.listaPalabrasValidas;
    }

    public void agregarPalabra(String palabraIngresada) {
        Palabra palabra = new Palabra(palabraIngresada.toLowerCase());
        for(Palabra p:listaPalabrasValidas){
            if (p.getPalabra().equals(palabra.getPalabra())) {
                System.out.println("Ya existe la palabra en el diccionario");
                break;
            }
        }
        this.listaPalabrasValidas.add(palabra);
    }
}