package ar.edu.unlu.poo.calculos;

public class Resultado {
    private double valor1;
    private double valor2;
    private final int cantResul;
    private final boolean raizImag;

    public Resultado(double valor1, double valor2) {
        this.valor1 = valor1;
        this.valor2 = valor2;
        this.cantResul = 2;
        this.raizImag = false;
    }

    public Resultado(double valor1) {
        this.valor1 = valor1;
        this.cantResul = 1;
        this.raizImag = false;
    }

    public Resultado(boolean raizImag) {
        this.cantResul = 0;
        this.raizImag = raizImag;
    }

    public double getValor1() {
        return this.valor1;
    }

    public double getValor2() {
        return this.valor2;
    }

    public void setValor1(double valor1) {
        this.valor1 = valor1;
    }

    public void setValor2(double valor2) {
        this.valor2 = valor2;
    }

    public int getCantResul() {
        return this.cantResul;
    }

    public boolean isRaizImag() {
        return this.raizImag;
    }
}
