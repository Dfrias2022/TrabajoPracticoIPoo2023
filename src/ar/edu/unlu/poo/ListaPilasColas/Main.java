package ar.edu.unlu.poo.ListaPilasColas;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        ListaEnlazadaSimple lista = new ListaEnlazadaSimple();
        ListaEnlazadaDoble lista2 = new ListaEnlazadaDoble();
        Pila pila = new Pila();
        Cola cola = new Cola();
        if(lista.isListaVacia()){
            System.out.println("La lista 1 esta vacia.");
        }else{
            System.out.println("La lista 1 no esta vacia.");
        }
        lista.insertarFinal(1);
        lista.insertarFinal(35);
        lista.insertarFinal(5);
        lista.insertarPosicion(8,2);
        lista.mostrarLista();
        lista.eliminarElemento(5);
        lista.mostrarLista();
    }
}
