package clases;

import javax.swing.*;

public class GestionarNodosImpl implements GestionarNodos {

    private Nodo cabeza;
    private Nodo actual;

    @Override
    public void agregarNodoAlInicio(int valor) {

        Nodo nuevo;

        if (cabeza != null){
            nuevo = new Nodo(valor);
            cabeza.setAnterior(nuevo);
            nuevo.setSiguiente(cabeza);
            cabeza = nuevo;
        }
        else
            cabeza = new Nodo(valor);

    }

    @Override
    public void suprimirNodoDeLaLista(int valor) {

    }

    @Override
    public void ordenarElementosDeLaLista() {

    }

    @Override
    public boolean agregarNodoAlFinal(int valor) {
        if(cabeza == null){
            return false;
        }

        actual = cabeza;
        while (actual.getSiguiente() != null)
            actual = actual.getSiguiente();

        Nodo nuevo = new Nodo(valor);
        actual.setSiguiente(nuevo);
        nuevo.setAnterior(actual);

        return true;
    }

    @Override
    public String listarElementos() {
        if (cabeza == null) {
            return "¡Lista vacia!";
        }

        StringBuilder str = new StringBuilder("La lista tiene " +
                Nodo.obtenerCantidadNodos() +
                " elementos: \n");

        StringBuilder str2 = new StringBuilder();

        actual = cabeza;
        while(actual != null){
            str2.append(actual.getValor()).append(" ");
            actual = actual.getSiguiente();
        }

        str.append(str2.toString().trim().replace(" ", ", "));

        return str.toString();
    }

    @Override
    public void vaciarLista() {
        if(cabeza == null) return;

        actual = cabeza;
        while (actual != null){

            if(actual.getSiguiente() != null){
                actual = actual.getSiguiente();
                actual.getAnterior().setSiguiente(null);
                actual.setAnterior(null);
            }else{

                actual = null;
            }
            Nodo.decrementarCantidad();
        }

        cabeza = null;
    }
}
