package Main;
import controlador.CalculadoraControlador;
import modelo.CalculadoraModelo;
import vista.CalculadoraVista;

import javax.swing.*;

/**
 * La clase {@code Main.CalculadoraMain} es el punto de entrada de la aplicación de calculadora.
 * Crea instancias del modelo, la vista y el controlador, y luego inicia la aplicación.
 */
public class CalculadoraMain {
    /**
     * Método principal que inicia la calculadora.
     *
     * @param args los argumentos de la línea de comandos
     */
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Crear el modelo, la vista y el controlador
        CalculadoraModelo modelo = new CalculadoraModelo();
        CalculadoraVista vista = new CalculadoraVista();
        CalculadoraControlador controlador = new CalculadoraControlador(modelo, vista);

        // Iniciar la calculadora
        vista.setVisible(true);
    }

}
