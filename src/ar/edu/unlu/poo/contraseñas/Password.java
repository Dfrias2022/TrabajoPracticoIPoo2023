package ar.edu.unlu.poo.contraseñas;

import java.util.Random;

public class Password {
    private int longitud;
    private String pass;

    public Password() {
        this.longitud = 8;
        this.pass = this.generarPasword(this.longitud);
    }

    public Password(int longitud) {
        this.longitud = longitud;
        this.pass = this.generarPasword(longitud);
    }

    public int getLongitud() {
        return this.longitud;
    }

    public String getPass() {
        return this.pass;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }

    public void setPass(String password) {
        this.pass = password;
    }

    public String generarPasword(int longitud) {
        String characteres = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder clave = new StringBuilder(longitud);
        Random random = new Random();

        for(int i = 0; i < longitud; ++i) {
            int indice = random.nextInt(characteres.length());
            char caracter = characteres.charAt(indice);
            clave.append(caracter);
        }

        return clave.toString();
    }

    public Tipo nivelContrasenia() {
        int cMayusculas = 0;
        int cMinusculas = 0;
        int cNumeros = 0;
        String mayusculas = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String minusculas = "abcdefghijklmnopqrstuvwxyz";
        String numeros = "0123456789";

        for(int i = 0; i < pass.length(); ++i) {
            char caracter = pass.charAt(i);
            if (mayusculas.indexOf(caracter) != -1) {
                cMayusculas++;
            } else if (minusculas.indexOf(caracter) != -1) {
                cMinusculas++;
            } else {
                cNumeros++;
            }
        }
        if ((cMayusculas > 2) && (cMinusculas > 1) && (cNumeros >= 2)) {
            return Tipo.FUERTE;
        } else {
            return Tipo.DEBIL;
        }
    }
}
