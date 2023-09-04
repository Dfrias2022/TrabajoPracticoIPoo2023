package ar.edu.unlu.poo.calculos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Ecuacion> listaEcuaciones = new ArrayList();

        for(int i = 0; i < 2; ++i) {
            double valor = 0.0;
            System.out.println("Ingrese el coeficiente de a :\n");
            double coefA = input.nextDouble();
            System.out.println("Ingrese el coeficiente de b :\n");
            double coefB = input.nextDouble();
            System.out.println("Ingrese el coeficiente de c :\n");
            double coefC = input.nextDouble();
            Ecuacion ecuacion = new Ecuacion(coefA, coefB, coefC);
            Resultado resultado = ecuacion.resolverEcuacion();
            if (resultado.isRaizImag()) {
                System.out.println("No existen raices reales.\n");
            } else if (resultado.getCantResul() == 2) {
                System.out.printf("Las raices son %.2f y %.2f .\n", resultado.getValor1(), resultado.getValor2());
            } else {
                System.out.printf("La unica raiz es %.2f .\n", resultado.getValor1());
            }

            System.out.println("Ingrese el valor de X :\n");
            valor = input.nextDouble();
            Resultado valorY = ecuacion.calcularY(valor);
            System.out.printf("Valor de Y = %.2f.\n", valorY.getValor1());
            listaEcuaciones.add(ecuacion);
        }

        System.out.println("ECUACIONES INGRESADAS");
        for(Ecuacion e:listaEcuaciones){
            System.out.printf("Y = (%.0fX^2) + (%.0fX) + (%.0f).\n", e.getA(), e.getB(), e.getC());
        }
    }
}
