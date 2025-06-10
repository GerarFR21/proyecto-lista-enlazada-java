package clases;

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
    public String suprimirNodoDeLaLista(int valor) {

        if(cabeza == null) return "¡La lista esta vacia!";

        if(cabeza.getValor() == valor){
            if (cabeza.getSiguiente() != null){

                cabeza = cabeza.getSiguiente();
                cabeza.getAnterior().setSiguiente(null);
                cabeza.setAnterior(null);
            }
            else
                cabeza = null;

            Nodo.decrementarCantidad();
            return "Se elimino exitosamente el elemento: " + valor;
        }

        actual = cabeza.getSiguiente();

        while(actual != null){
            if(actual.getValor() == valor){

                if(actual.getSiguiente() != null){

                    actual.getAnterior().setSiguiente(actual.getSiguiente());
                    actual.getSiguiente().setAnterior(actual.getAnterior());
                    actual.setAnterior(null);
                    actual.setSiguiente(null);
                }else{

                    actual.getAnterior().setSiguiente(null);
                    actual.setAnterior(null);
                }

                actual = null;
                Nodo.decrementarCantidad();
                return "Se elimino exitosamente el elemento: " + valor;
            }

            actual = actual.getSiguiente();
        }

        return "El elemento " + valor + " no existe en la lista.";
    }

    @Override
    public boolean ordenarElementosDeLaLista() {
        if (cabeza == null) return false;

        actual = cabeza.getSiguiente();

        while (actual != null) {
            int valorActual = actual.getValor();
            Nodo anterior = actual.getAnterior();

            while (anterior != null && anterior.getValor() > valorActual) {
                anterior.getSiguiente().setValor(anterior.getValor());
                anterior = anterior.getAnterior();
            }

            if (anterior == null) {
                cabeza.setValor(valorActual);
            } else {
                anterior.getSiguiente().setValor(valorActual);
            }

            actual = actual.getSiguiente();
        }

        return true;
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
    public boolean vaciarLista() {
        if(cabeza == null) return false;

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
        return true;
    }
}
