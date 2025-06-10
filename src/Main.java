import clases.GestionarNodos;
import clases.GestionarNodosImpl;

import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {

        GestionarNodos gestionarNodos = new GestionarNodosImpl();
        int opcion;

        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(" Opciones Disponibles: \n\n" +
                    "1. Agregar elemento al inicio de la lista.\n" +
                    "2. Suprimir elemento de la lista.\n" +
                    "3. Ordenar los elementos de la lista.\n" +
                    "4. Agregar elemento al final de la lista.\n" +
                    "5. Listar todos los elementos de la lista.\n" +
                    "6. Vaciar la lista completa.\n" +
                    "0. Salir.\n\n"));

            switch (opcion){

                case 1:
                    int valor = Integer.parseInt(JOptionPane.showInputDialog("Ingresa un valor entero: "));
                    gestionarNodos.agregarNodoAlInicio(valor);
                    JOptionPane.showMessageDialog(null, "¡Elemento agregado al inicio de la lista!");
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    valor = Integer.parseInt(JOptionPane.showInputDialog("Ingresa un valor entero: "));
                    if (gestionarNodos.agregarNodoAlFinal(valor))
                        JOptionPane.showMessageDialog(null, "¡Elemento agregado al final de la lista!");
                    else
                        JOptionPane.showMessageDialog(null, "¡Primero agrega un elemento al inicio!");

                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, gestionarNodos.listarElementos());
                    break;
                case 6:
                    JOptionPane.showMessageDialog(null, "Vaciando la lista...");
                    gestionarNodos.vaciarLista();
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null, "Saliendo del programa...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "¡Ingresa una opcion valida!");
                    break;
            }
        }while(opcion != 0);
    }
}
