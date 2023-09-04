package ar.edu.unlu.poo.contraseñas;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String opcion = "S";
        boolean estado = false;
        List<Integer> debiles = new ArrayList();
        List<Password> paswords = new ArrayList();
        System.out.println("Ingrese la cantidad de contraseñas a generar: \n");
        int ingreso = input.nextInt();
        int valor = 0;

        for(int i = 0; i < ingreso; ++i) {
            do {
                System.out.println("Ingrese la longitud de la contraseña[-1 para usar valor por defecto]:\n");
                valor = input.nextInt();
            } while(valor < -1);

            Password p1;
            if (valor == -1) {
                p1 = new Password();
            } else {
                p1 = new Password(valor);
            }
            paswords.add(p1);
            if (p1.nivelContrasenia() == Tipo.DEBIL) {
                debiles.add(i);
                System.out.printf("<%s> - DEBIL\n", p1.getPass());
            } else {
                System.out.printf("<%s> - FUERTE\n", p1.getPass());
            }
        }
        input.nextLine();
        do {
            System.out.println("Regenerar las contraseñas debiles?[S/N]\n");
            opcion = input.nextLine().toUpperCase();
            if (opcion.equals("S")) {
                for(Integer elemento:debiles){
                    Password nueva = (Password)paswords.get(elemento);
                    String nPass = nueva.generarPasword(nueva.getLongitud());
                    System.out.printf("CONTRASEÑA A MODIFICAR: <%s>\n", nueva.getPass());
                    nueva.setPass(nPass);
                    System.out.printf("NUEVA CONTRASEÑA: %s\n", nueva.getPass());
                }

            }
            debiles.removeIf((elem) -> {
                return ((Password)paswords.get(elem)).nivelContrasenia() != Tipo.DEBIL;
            });
        } while(!debiles.isEmpty() && opcion.equals("S"));

        System.out.println("--MOSTRANDO LA LISTA DE PASSWORDS--\n");
        for(Password p:paswords){
            if (p.nivelContrasenia() != Tipo.FUERTE) {
                System.out.printf("<%s> - DEBIL\n", p.getPass());
            } else {
                System.out.printf("<%s> - FUERTE\n", p.getPass());
            }
        }

        }

    }
