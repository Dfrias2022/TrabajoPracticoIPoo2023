package ar.edu.unlu.poo.ListaPilasColas;

public class Pila {
    private Nodo tope = null;
    private int cantidad = 0;

    public Pila() {
        this.tope = null;
        this.cantidad = 0;
    }

    public boolean isVacia() {
        return tope == null;
    }

    public Object devolverTope() {
        if (this.tope == null) {
            System.out.println("Pila vacia.");
            return null;
        } else {
            return tope.getValor();
        }
    }

    public void apilar(Object elemento) {
        Nodo nuevoNodo = new Nodo(elemento);
        if (tope == null) {
            tope = nuevoNodo;
            cantidad++;
        } else {
            nuevoNodo.setSiguiente(tope);
            tope = nuevoNodo;
            cantidad++;
        }

    }

    public void desapilar() {
        Nodo nodoAux = tope;
        if (tope == null) {
            System.out.println("Pila vacia.");
        } else {
            tope = nodoAux.getSiguiente();
            cantidad--;
        }

    }

    public Nodo getTope() {
        return this.tope;
    }

    public void mostrarPila() {
        String listarPila = "";
        Nodo nodoAux = this.tope;
        if (this.tope == null) {
            System.out.println("Pila vacia.");
        } else {
            while(nodoAux != null) {
                listarPila = listarPila + " " + nodoAux.getValor();
                nodoAux = nodoAux.getSiguiente();
            }
            System.out.println(listarPila);
        }
    }
}
