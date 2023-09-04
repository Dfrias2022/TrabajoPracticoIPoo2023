package ar.edu.unlu.poo.ListaPilasColas;

public class NodoDoble extends Nodo {
    private Nodo anterior = null;

    public NodoDoble(Object valor) {
        super(valor);
    }

    public Nodo getAnterior() {
        return this.anterior;
    }

    public void setAnterior(Nodo anterior) {
        this.anterior = anterior;
    }
}
