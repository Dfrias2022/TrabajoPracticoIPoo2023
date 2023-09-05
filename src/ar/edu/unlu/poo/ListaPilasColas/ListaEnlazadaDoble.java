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
            System.out.print(actual.getValor() + " ");
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

    public void insertarElementoPosicion(Object valor, int pos) {
        NodoDoble nuevoNodo = new NodoDoble(valor);
        NodoDoble nuevoAux = inicio;
        if (pos == 0) {
            nuevoNodo.setAnterior(null);
            nuevoNodo.setSiguiente(inicio);
            inicio.setAnterior(nuevoNodo);
            inicio = nuevoNodo;
            cantidad++;
        } else {
            int contador = 0;
            while ((nuevoAux != null) && (contador < pos - 1)) {
                nuevoAux = (NodoDoble) nuevoAux.getSiguiente();
                contador++;
            }
            if (nuevoAux == null) {
                System.out.println("Posicion fuera de rango");
            } else {
                nuevoNodo.setSiguiente(nuevoAux.getSiguiente());
                nuevoNodo.setAnterior(nuevoAux);
                ((NodoDoble) nuevoAux.getSiguiente()).setAnterior(nuevoNodo);
                nuevoAux.setSiguiente(nuevoNodo);
                cantidad++;
            }
        }

    }

    public Object recuperarElemento(int posicion) {
        Object elemento = null;
        if (this.inicio == null) {
            System.out.println("Lista vacia.");
        } else {
            NodoDoble nodoAux = this.inicio;

            for(int i = 0; i < posicion; ++i) {
                nodoAux = (NodoDoble)nodoAux.getSiguiente();
            }

            if (nodoAux == null) {
                System.out.println("Posicion fuera de rango.");
            } else {
                elemento = nodoAux.getValor();
            }
        }

        return elemento;
    }

    public void eliminarElemento(Object elemento) {
        NodoDoble actual = inicio;
        if (inicio == null) {
            System.out.println("lista vacia.");
        }else if(actual.getValor().equals(elemento) && actual.getAnterior() == null && actual.getSiguiente() == null){
            this.inicio= null;
            this.cantidad = 0;
        }else if(actual.getValor().equals(elemento) && actual.getAnterior() == null){
            inicio = (NodoDoble) actual.getSiguiente();
            inicio.setAnterior(null);
        }else{
            while ((!actual.getValor().equals(elemento)) && (actual.getValor() !=null)){
                actual = (NodoDoble) actual.getSiguiente();
            }
            if(actual.getValor() == null){
                System.out.println("elemento no se encuentra en la lista.");
            }else{
                if(actual.getSiguiente() == null){
                    actual.getAnterior().setSiguiente(null);
                }else{
                    ((NodoDoble)actual.getSiguiente()).setAnterior(actual.getAnterior());
                    actual.getAnterior().setSiguiente(actual.getSiguiente());
                }
            }
        }

    }
}
