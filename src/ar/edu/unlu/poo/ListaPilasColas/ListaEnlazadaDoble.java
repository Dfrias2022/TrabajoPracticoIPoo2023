package ar.edu.unlu.poo.ListaPilasColas;

public class ListaEnlazadaDoble {
    private NodoDoble inicio = null;
    private int cantidad;

    public ListaEnlazadaDoble() {
        this.inicio = null;
        this.cantidad = 0;
    }

    public boolean isListaVacia() {
        return this.inicio == null;
    }

    public int getCantidad() {
        return this.cantidad;
    }

    public void mostrarLista() {
        Nodo actual = inicio;
        while(actual != null){
            System.out.println(actual.getValor() + " ");
            actual = actual.getSiguiente();
        }
        System.out.println();
    }

    public void insertarElementoFinal(Object valor) {
        NodoDoble nodoNuevo = new NodoDoble(valor);
        if (inicio == null) {
            inicio = nodoNuevo;
        } else {
            NodoDoble temporal = inicio;
             while(temporal.getSiguiente() != null){
                 temporal = (NodoDoble)temporal.getSiguiente();
             }
            temporal.setSiguiente(nodoNuevo);
            nodoNuevo.setAnterior(temporal);
            cantidad++;
        }

    }

    public void insertarElementoPosicion(int valor, int pos) {
        NodoDoble nuevoNodo = new NodoDoble(valor);
        NodoDoble nuevoAux = this.inicio;
        if (pos == 0) {
            nuevoNodo.setAnterior((Nodo)null);
            nuevoNodo.setSiguiente(this.inicio);
            this.inicio = nuevoNodo;
            ++this.cantidad;
        } else {
            for(int i = 0; i < pos - 1 && nuevoAux != null; ++i) {
                nuevoAux = (NodoDoble)nuevoAux.getSiguiente();
            }

            if (nuevoAux == null) {
                System.out.println("Posicion fuera de rango\n");
            } else {
                nuevoNodo.setSiguiente(nuevoAux.getSiguiente());
                nuevoNodo.setAnterior(nuevoAux);
                ((NodoDoble)nuevoAux.getSiguiente()).setAnterior(nuevoNodo);
                nuevoAux.getAnterior().setSiguiente(nuevoAux);
                ++this.cantidad;
            }
        }

    }

    public Object recuperarElemento(int posicion) {
        Object elemento = null;
        if (this.inicio == null) {
            System.out.println("Lista vacia\n");
        } else {
            NodoDoble nodoAux = this.inicio;

            for(int i = 0; i < posicion; ++i) {
                nodoAux = (NodoDoble)nodoAux.getSiguiente();
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
        NodoDoble nodoAux = this.inicio;
        if (this.inicio == null) {
            System.out.println("Lista vacia\n");
        } else if (elemento == nodoAux.getValor() && nodoAux.getAnterior() == null) {
            this.inicio = null;
            this.cantidad = 0;
            System.out.println("Lista vacia\n");
        } else if (elemento == nodoAux.getValor() && nodoAux.getSiguiente() == null) {
            nodoAux = (NodoDoble)nodoAux.getAnterior();
            nodoAux.setSiguiente((Nodo)null);
            --this.cantidad;
        } else {
            while(elemento != nodoAux.getValor() && nodoAux.getSiguiente() != null) {
                nodoAux = (NodoDoble)nodoAux.getSiguiente();
            }

            if (elemento == nodoAux.getValor()) {
                NodoDoble anterior = (NodoDoble)nodoAux.getAnterior();
                NodoDoble siguiente = (NodoDoble)nodoAux.getSiguiente();
                anterior.setSiguiente(siguiente);
                siguiente.setAnterior(anterior);
                --this.cantidad;
            } else {
                System.out.println("El elemento no existe en la lista\n");
            }
        }

    }
}
