package clases;

public interface GestionarNodos {

    void agregarNodoAlInicio(int valor);

    void suprimirNodoDeLaLista(int valor);

    void ordenarElementosDeLaLista();

    boolean agregarNodoAlFinal(int valor);

    String listarElementos();

    void vaciarLista();
}
