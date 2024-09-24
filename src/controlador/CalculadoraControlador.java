package controlador;

import modelo.CalculadoraModelo;
import vista.CalculadoraVista;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculadoraControlador {
    private CalculadoraModelo modelo;
    private CalculadoraVista vista;
    private String operador;
    private double numero1;
    private boolean nuevoNumero;  // Bandera para saber si se debe limpiar el display
    private String operacionCompleta;

    public CalculadoraControlador(CalculadoraModelo modelo, CalculadoraVista vista) {
        this.modelo = modelo;
        this.vista = vista;
        this.operacionCompleta = "";
        this.nuevoNumero = true;  // Indica que el próximo número es nuevo

        this.vista.addNumeroListener(new NumeroListener());
        this.vista.addOperacionListener(new OperacionListener());
        this.vista.addDecimalListener(new NumeroListener());
        this.vista.addIgualListener(new IgualListener());
        this.vista.addLimpiarListener(new LimpiarListener());
        this.vista.addFuncionesListener(new FuncionesListener());
    }

    /**
     * Listener para los botones numéricos y el punto decimal.
     */
    private class NumeroListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JButton source = (JButton) e.getSource();
            String numero = source.getText();

            // Si el display es "0.0" o el número es nuevo, reiniciar el display
            if (nuevoNumero) {
                // Si se presiona el ".", asegurarse de que el primer carácter sea "0."
                if (numero.equals(".")) {
                    vista.setDisplayText("0.");
                } else {
                    vista.setDisplayText(numero);
                }
                nuevoNumero = false;  // Indicar que ya no es un nuevo número
            } else {
                // Si se presiona el ".", asegurarse de que no haya más de un punto en el número actual
                if (numero.equals(".") && vista.getDisplayText().contains(".")) {
                    return; // Si ya existe un punto, no hacer nada
                }
                // Concatenar el nuevo número o punto al display
                vista.setDisplayText(vista.getDisplayText() + numero);
            }
        }
    }

    /**
     * Listener para los botones de operaciones (+, -, *, /).
     */
    private class OperacionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JButton source = (JButton) e.getSource();
            operador = source.getText();
            numero1 = Double.parseDouble(vista.getDisplayText());
            vista.setDisplayText("");  // Limpiar el display para el siguiente número
            operacionCompleta += " " + operador + " ";  // Agregar el operador a la operación completa
            nuevoNumero = true;  // Indicar que el próximo número es nuevo
        }
    }

    /**
     * Listener para el botón de igual (=), realiza el cálculo.
     */
    private class IgualListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // Controlar si no se ha seleccionado un operador válido
            if (operador == null || operador.isEmpty()) {
                vista.setDisplayText("Error: Operación inválida");
                return;
            }

            // Obtener el segundo número de la operación
            double numero2 = Double.parseDouble(vista.getDisplayText());

            // Variable para almacenar el resultado
            double resultado = 0;

            // Realizar la operación correspondiente
            switch (operador) {
                case "+":
                    modelo.sumar(numero1, numero2);
                    resultado = modelo.getResultado();
                    break;
                case "-":
                    modelo.restar(numero1, numero2);
                    resultado = modelo.getResultado();
                    break;
                case "*":
                    modelo.multiplicar(numero1, numero2);
                    resultado = modelo.getResultado();
                    break;
                case "/":
                    // Controlar el caso de división por cero
                    if (numero2 == 0) {
                        vista.setDisplayText("Error: División por 0");
                        return;  // Salir para no seguir ejecutando más código
                    }
                    modelo.dividir(numero1, numero2);
                    resultado = modelo.getResultado();
                    break;
            }

            // Mostrar la operación completa con el resultado, evitando duplicar números
            String resultadoFormateado = (resultado % 1 == 0) ? String.valueOf((int) resultado) : String.valueOf(resultado);
            operacionCompleta = numero1 + " " + operador + " " + numero2 + " = " + resultadoFormateado;
            vista.setDisplayText(operacionCompleta);

            // Reiniciar los valores para la próxima operación
            nuevoNumero = true;  // Indicar que el siguiente número es nuevo
            numero1 = resultado;  // Para que el resultado pueda ser usado en una operación posterior
            operacionCompleta = "";  // Reiniciar la operación completa
        }
    }

    /**
     * Listener para el botón de limpiar (C), reinicia la calculadora.
     */
    private class LimpiarListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            vista.setDisplayText("0.0");
            operador = "";
            operacionCompleta = "";
            nuevoNumero = true;  // Reiniciar bandera para el próximo número
        }
    }

    /**
     * Listener para las funciones avanzadas (% para porcentaje, √ para raíz cuadrada, +/- para cambiar de signo).
     */
    private class FuncionesListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JButton source = (JButton) e.getSource();
            String funcion = source.getText();
            double numero = Double.parseDouble(vista.getDisplayText());

            switch (funcion) {
                case "%":
                    vista.setDisplayText(String.valueOf(numero / 100));
                    break;
                case "√":
                    // Control de error para evitar raíz de número negativo
                    if (numero < 0) {
                        vista.setDisplayText("Error: Número negativo");
                    } else {
                        vista.setDisplayText(String.valueOf(Math.sqrt(numero)));
                    }
                    break;
                case "+/-":
                    vista.setDisplayText(String.valueOf(numero * -1));
                    break;
            }

            nuevoNumero = true;  // Indicar que el siguiente número es nuevo
        }
    }
}

