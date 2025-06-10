package clases;

public class Nodo {

    private int valor;
    private Nodo anterior;
    private Nodo siguiente;

    private static int cantidadNodos = 0;

    public Nodo() {
    }

    public Nodo(int valor) {
        this.valor = valor;
        cantidadNodos++;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public Nodo getAnterior() {
        return anterior;
    }

    public void setAnterior(Nodo anterior) {
        this.anterior = anterior;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    public static int obtenerCantidadNodos(){
        return cantidadNodos;
    }

    public static void decrementarCantidad(){
        cantidadNodos--;
    }
}
