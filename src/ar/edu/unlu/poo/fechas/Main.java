package ar.edu.unlu.poo.fechas;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Fecha> fechas = new ArrayList<>();
        String formato1 = "dd-MM-yyyy";
        String formato2 = "MM-dd-yyyy";
        Scanner ingreso = new Scanner(System.in);

        Fecha fecha;
        for(int i = 0; i < 3; ++i) {
            boolean estado = false;
            fecha = null;
            int valorIngresador = 0;

            do {
                System.out.println("Seleccione el formato de ingreso (1)dd-MM-yyyy (2)MM-dd-yyyy");
                if (ingreso.hasNextInt()) {
                    valorIngresador = ingreso.nextInt();
                } else {
                    System.out.println("El valor debe ser numerico.\n");
                }
                ingreso.nextLine();
            } while(valorIngresador != 1 && valorIngresador != 2);

            do {
                System.out.printf("Ingrese la fecha %d: \n", i);
                String fechaIngresada = ingreso.nextLine();
                if (valorIngresador == 1) {
                    try {
                        fecha = new Fecha(LocalDate.parse(fechaIngresada, DateTimeFormatter.ofPattern(formato1)));
                        estado = true;
                        fechas.add(fecha);
                    } catch (DateTimeParseException var12) {
                        System.out.println("Error de formato de fecha ingresada por el usuario.\n");
                    }
                } else {
                    try {
                        fecha = new Fecha(LocalDate.parse(fechaIngresada, DateTimeFormatter.ofPattern(formato2)));
                        estado = true;
                        fechas.add(fecha);
                    } catch (DateTimeParseException var11) {
                        System.out.println("Error de formato de fecha ingresada por el usuario.\n");
                    }
                }
            } while(!estado);
        }

        Fecha fecha1 = fechas.get(0);
        Fecha fecha2 = fechas.get(1);
        Fecha fecha3 = fechas.get(2);
        if (fecha1.esMayor(fecha2.getFecha())) {
            System.out.printf("la fecha %s es mayor que la fecha %s.\n",fecha1.getFecha(),fecha2.getFecha());
        } else if (fecha1.esMenor(fecha2.getFecha())) {
            System.out.printf("la fecha %s es mayor que la fecha %s.\n",fecha2.getFecha(),fecha1.getFecha());
        }

        if (fecha1.entreFechas(fecha2.getFecha(), fecha3.getFecha())) {
            System.out.printf("la fecha %s esta entre %s y %s.\n",fecha1.getFecha(),fecha2.getFecha(),fecha3.getFecha());
        } else {
            System.out.printf("la fecha %s NO esta entre %s y %s.\n",fecha1.getFecha(),fecha2.getFecha(),fecha3.getFecha());
        }

    }
}
