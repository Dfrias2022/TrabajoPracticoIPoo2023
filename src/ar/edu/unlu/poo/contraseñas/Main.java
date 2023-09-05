package ar.edu.unlu.poo.contraseñas;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String opcion = "S";
        int ingreso = 0;
        boolean estado = false;
        List<Integer> debiles = new ArrayList();
        List<Password> paswords = new ArrayList();
        do {
            System.out.println("Ingrese la cantidad de contraseñas a generar: ");
            if(input.hasNextInt()) {
                ingreso = input.nextInt();
            }else{
                System.out.println("Solo valores enteros positivos.");
                input.nextLine();
            }
        }while (ingreso < 1);
        int valor = 0;
        for(int i = 0; i < ingreso; ++i) {
            do {
                System.out.println("Ingrese la longitud de la contraseña[8 para usar valor por defecto]:");
                if(input.hasNextInt()) {
                    valor = input.nextInt();
                }else{
                    System.out.println("Solo valores numericos mayores o iguales a 8 (Valor por defecto).");
                    input.nextLine();
                }
            } while(valor < 8);
            Password p1;
            if (valor == 8) {
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
            System.out.println("Regenerar las contraseñas debiles?[S/N].");
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
            if(!debiles.isEmpty()){
                System.out.println("-AUN QUEDAN PASSWORDS DEBILES-");
            }else{
                System.out.println("YA NO QUEDAN PASSWORDS DEBILES");
            }
        } while(!debiles.isEmpty() && opcion.equals("S"));

        System.out.println("--MOSTRANDO LA LISTA DE PASSWORDS--");
        for(Password p:paswords){
            if (p.nivelContrasenia() != Tipo.FUERTE) {
                System.out.printf("<%s> - DEBIL\n", p.getPass());
            } else {
                System.out.printf("<%s> - FUERTE\n", p.getPass());
            }
        }

        }

    }
