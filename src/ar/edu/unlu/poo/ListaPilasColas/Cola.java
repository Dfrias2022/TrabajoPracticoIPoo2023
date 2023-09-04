package ar.edu.unlu.poo.ListaPilasColas;

public class Cola {
    private Nodo frente = null;
    private Nodo fin = null;
    private int cantidad = 0;

    public Cola() {
        this.frente = null;
        this.fin = null;
        this.cantidad = 0;
    }

    public boolean isVacia() {
        return frente == null;
    }

    public int getCantidad() {
        return this.cantidad;
    }

    public Nodo getFrente() {
        return this.frente;
    }

    public Nodo getFin() {
        return this.fin;
    }

    public void encolar(Object elemento) {
        Nodo nuevoNodo = new Nodo(elemento);
        if (frente == null) {
            frente = nuevoNodo;
            fin = nuevoNodo;
            cantidad++;
        } else {
            fin.setSiguiente(nuevoNodo);
            fin = nuevoNodo;
            cantidad++;
        }

    }

    public void desencolar() {
        if (frente == null) {
            System.out.println("Cola vacia.");
        } else if (frente == fin) {
            frente = null;
            fin = null;
            cantidad = 0;
        } else {
            frente = this.frente.getSiguiente();
            cantidad--;
        }

    }

    public void mostrarElementos() {
        Nodo nodoAux = frente;
        Cola cAux = new Cola();
        if (frente == null) {
            System.out.println("Cola vacia.");
        } else {
            while(!isVacia()) {
                System.out.print(frente.getValor() + " ");
                cAux.encolar(frente.getValor());
                cantidad--;
                desencolar();
            }
            while (!cAux.isVacia()){
                encolar(cAux.getFrente());
                cAux.desencolar();
                cantidad++;
            }
        }

    }
}
