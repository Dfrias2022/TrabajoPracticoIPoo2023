package ar.edu.unlu.poo.ListaPilasColas;

public class Main {
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
        lista.eliminarElemento(1);
        lista.mostrarLista();
        lista.eliminarElemento(35);
        lista.eliminarElemento(8);
        lista.mostrarLista();
        lista.eliminarElemento(1);
        System.out.println("----LISTA ENLAZADA DOBLE----");
        lista2.mostrarLista();
        lista2.insertarElementoFinal(1);
        lista2.insertarElementoFinal(2);
        lista2.insertarElementoFinal(4);
        lista2.insertarElementoFinal(1200);
        lista2.insertarElementoPosicion(0,1);
        lista2.mostrarLista();
        lista2.eliminarElemento(1);
        lista2.mostrarLista();
        lista2.insertarElementoPosicion(345, 0);
        lista2.mostrarLista();
        lista2.eliminarElemento(1200);
        lista2.mostrarLista();
        System.out.println("---Pila---");
        pila.apilar(12);
        pila.apilar(14);
        pila.apilar(16);
        pila.apilar(230);
        pila.apilar(1200);
        pila.mostrarPila();
        System.out.println("TOPE ACTUAL DE LA PILA: " + pila.getTope().getValor());
        pila.desapilar();
        pila.mostrarPila();
        System.out.println("TOPE ACTUAL DE LA PILA: " + pila.getTope().getValor());
        pila.desapilar();
        pila.desapilar();
        pila.desapilar();
        System.out.println("TOPE ACTUAL DE LA PILA: " + pila.getTope().getValor());
    }
}
