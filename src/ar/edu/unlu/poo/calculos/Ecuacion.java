package ar.edu.unlu.poo.calculos;

public class Ecuacion {
    private final double a;
    private final double b;
    private final double c;

    public Ecuacion(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return this.a;
    }

    public double getB() {
        return this.b;
    }

    public double getC() {
        return this.c;
    }

    public Resultado resolverEcuacion() {
        double respuestaParcial = 0.0;
        double respuestaParcial2 = 0.0;
        respuestaParcial = Math.pow(this.b, 2.0) - 4.0 * this.a * this.c;
        if (respuestaParcial < 0.0) {
            return new Resultado(true);
        } else {
            if (respuestaParcial == 0.0) {
                respuestaParcial = -this.b / (2.0 * this.a);
            } else {
                double aux = respuestaParcial;
                respuestaParcial = (-this.b + Math.sqrt(respuestaParcial)) / (2.0 * this.a);
                respuestaParcial2 = (-this.b - Math.sqrt(aux)) / (2.0 * this.a);
            }

            return respuestaParcial2 == 0.0 ? new Resultado(respuestaParcial) : new Resultado(respuestaParcial, respuestaParcial2);
        }
    }

    public Resultado calcularY(double x) {
        return new Resultado(this.a * Math.pow(x, 2.0) + this.b * x + this.c);
    }
}