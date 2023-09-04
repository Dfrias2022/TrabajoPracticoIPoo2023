package ar.edu.unlu.poo.formarPalabras;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int puntaje1 = 0;
        int puntaje2 = 0;
        Scanner ingreso = new Scanner(System.in);
        Diccionario diccionario = new Diccionario();
        List<Jugador> jugadores = new ArrayList<>();
        Jugador jugador1 = new Jugador("pepe");
        Jugador jugador2 = new Jugador("ariel");
        jugadores.add(jugador1);
        jugadores.add(jugador2);
        diccionario.agregarPalabra("programacion");
        diccionario.agregarPalabra("objetos");
        diccionario.agregarPalabra("universidad");
        diccionario.agregarPalabra("lujan");
        diccionario.agregarPalabra("aula");
        diccionario.agregarPalabra("computacion");
        diccionario.agregarPalabra("world");
        diccionario.agregarPalabra("hello");

        for(int i = 0; i < 3; ++i) {
            for(Jugador jugador:jugadores){
                System.out.printf("Turno jugador \"%s\"\n.", jugador.getNombre());
                String palabraIngresada = ingreso.nextLine();
                Palabra palabra = jugador.generarPalabra(palabraIngresada.toLowerCase(), diccionario);
                if (palabra != null) {
                    jugador.agregarPalabra(palabra);
                } else {
                    System.out.println("Palabra no valida.\n");
                }
            }
        }
        Jugador ganador = null;
        int puntajeGanador = 0;
        for(Jugador jugador:jugadores){
            int sParcial = jugador.puntajeTotal();
            if (sParcial > puntajeGanador) {
                puntajeGanador = sParcial;
                ganador = jugador;
            }
        }
        if(ganador !=null) {
            System.out.printf("%s - puntaje: %d\n", ((Jugador) jugadores.get(0)).getNombre(), ((Jugador) jugadores.get(0)).puntajeTotal());
            System.out.printf("%s - puntaje: %d\n", ((Jugador) jugadores.get(1)).getNombre(), ((Jugador) jugadores.get(1)).puntajeTotal());
            System.out.printf("El ganador fue el jugador %s con un total de %d puntos.\n", ganador.getNombre(), puntajeGanador);
        }
    }
}
