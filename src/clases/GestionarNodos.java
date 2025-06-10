package clases;

public interface GestionarNodos {

    void agregarNodoAlInicio(int valor);

    String suprimirNodoDeLaLista(int valor);

    void ordenarElementosDeLaLista();

    boolean agregarNodoAlFinal(int valor);

    String listarElementos();

    boolean vaciarLista();
}
