package ar.edu.unlu.poo.ListaPilasColas;

public class ListaEnlazadaSimple {
    private Nodo inicio = null;
    private int cantidad = 0;

    public ListaEnlazadaSimple() {
        this.inicio = null;
        this.cantidad = 0;
    }

    public void insertarPosicion(Object dato, int posicion) {
        Nodo nuevoNodo = new Nodo(dato);
        Nodo nodoAux = inicio;
        if (posicion == 0) {
            nuevoNodo.setSiguiente(inicio);
            inicio = nuevoNodo;
            cantidad++;
        } else {
            Nodo anterior = null;

            int indice;
            for(indice = 0; nodoAux != null && posicion > indice; ++indice) {
                anterior = nodoAux;
                nodoAux = nodoAux.getSiguiente();
            }

            if (posicion == indice) {
                anterior.setSiguiente(nuevoNodo);
                nuevoNodo.setSiguiente(nodoAux);
                cantidad++;
            } else {
                System.out.println("posicion fuera de rango.");
            }
        }

    }

    public void insertarFinal(Object dato) {
        NodoDoble nuevoNodo = new NodoDoble(dato);
        cantidad++;
        if (inicio == null) {
            inicio = nuevoNodo;
        } else {
            NodoDoble actual = (NodoDoble) inicio;
            while (actual.getSiguiente() != null){
                actual = (NodoDoble)actual.getSiguiente();
            }
            actual.setSiguiente(nuevoNodo);
            nuevoNodo.setAnterior(actual);
        }

    }

    public void mostrarLista() {
        for(Nodo actual = this.inicio; actual != null; actual = actual.getSiguiente()) {
            System.out.print(actual.getValor() + " ");
        }
        System.out.println();
    }

    public Object recuperarElemento(int posicion) {
        Object elemento = null;
        if (this.inicio == null) {
            System.out.println("Lista vacia\n");
        } else {
            Nodo nodoAux = this.inicio;

            for(int i = 0; i < posicion; ++i) {
                nodoAux = nodoAux.getSiguiente();
            }

            if (nodoAux == null) {
                System.out.println("Posicion fuera de rango\n");
            } else {
                elemento = nodoAux.getValor();
            }
        }

        return elemento;
    }

    public void eliminarElemento(Object elemento) {
        Nodo nodoAux = this.inicio;
        Nodo nodito = new Nodo(0);
        if (this.inicio == null) {
            System.out.println("Lista vacia.");
        } else if (elemento == nodoAux.getValor() && nodoAux.getSiguiente() == null) {
            this.inicio = null;
            this.cantidad = 0;
            System.out.println("Lista vacia, se elimino el unico elemento de la lista.");
        } else if (elemento == nodoAux.getValor()) {
            this.inicio = nodoAux.getSiguiente();
        } else {
            while(nodoAux.getValor() != elemento && nodoAux.getSiguiente() != null) {
                nodito = nodoAux;
                nodoAux = nodoAux.getSiguiente();
            }

            if (nodoAux.getValor() == elemento) {
                nodito.setSiguiente(nodoAux.getSiguiente());
            } else {
                System.out.println("No existia el elemento en la lista\n");
            }
        }

    }

    public boolean isListaVacia() {
        return this.inicio == null;
    }

    public int getCantidad() {
        return this.cantidad;
    }
}
