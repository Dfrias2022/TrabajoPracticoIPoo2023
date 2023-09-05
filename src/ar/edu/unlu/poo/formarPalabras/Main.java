package ar.edu.unlu.poo.formarPalabras;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int puntaje1 = 0;
        int puntaje2 = 0;
        Scanner ingreso = new Scanner(System.in);
        Diccionario diccionario = new Diccionario();
        List<Jugador> jugadores = new ArrayList<>();
        for(int i=1;i<3;i++){
            String ingresoNombre;
            System.out.println("[--CARGA DE 2 JUGADORES--]");
            System.out.printf("Ingrese el nombre del jugador %s.\n",i);
            ingresoNombre = ingreso.nextLine();
            Jugador jugador = new Jugador(ingresoNombre);
            jugadores.add(jugador);
        }
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
                System.out.printf("Turno jugador \"%s\".\n", jugador.getNombre());
                String palabraIngresada = ingreso.nextLine();
                Palabra palabra = jugador.generarPalabra(palabraIngresada.toLowerCase(), diccionario);
                if (palabra != null) {
                    jugador.agregarPalabra(palabra);
                    System.out.printf("Puntaje de la palabra: %d\n",palabra.getPuntaje());
                } else {
//Anotacion personal: cuando un jugador ingresa una palabra que no se encuentra en el diccionario, le informa que
//la palabra no era valida y pierde el turno, por lo que no genera puntos a favor.
                    System.out.println("Palabra no valida.");
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
            }else if(sParcial == puntajeGanador){
                ganador = null;
            }
        }
        if(ganador !=null) {
            System.out.println("[--SCORE--]");
            System.out.printf("%s - puntaje: %d\n", ((Jugador) jugadores.get(0)).getNombre(), ((Jugador) jugadores.get(0)).puntajeTotal());
            System.out.printf("%s - puntaje: %d\n", ((Jugador) jugadores.get(1)).getNombre(), ((Jugador) jugadores.get(1)).puntajeTotal());
            System.out.printf("El ganador fue el jugador %s con un total de %d puntos.\n", ganador.getNombre(), puntajeGanador);
        }else{
            System.out.printf("[EMPATE] - Ambos jugadores obtuvieron el mismo puntaje %d.\n",puntajeGanador);
        }
    }
}
