package ar.edu.unlu.poo.ListaPilasColas;

public class Nodo {
    private Object valor;
    private Nodo siguiente;

    public Nodo(Object dato) {
        this.valor = dato;
        this.siguiente = null;
    }

    public Object getValor() {
        return this.valor;
    }

    public Nodo getSiguiente() {
        return this.siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    public void setValor(Object valor) {
        this.valor = valor;
    }
}
