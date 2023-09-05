package ar.edu.unlu.poo.ListaPilasColas;

public class NodoDoble extends Nodo {
    private Nodo anterior;

    public NodoDoble(Object valor) {
        super(valor);
        this.anterior = null;
    }

    public Nodo getAnterior() {
        return this.anterior;
    }

    public void setAnterior(Nodo anterior) {
        this.anterior = anterior;
    }
}
