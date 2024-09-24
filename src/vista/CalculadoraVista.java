package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CalculadoraVista extends JFrame {
    private JTextField display;
    private JButton[] numeroButtons;
    private JButton btnSuma, btnResta, btnMultiplicacion, btnDivision, btnIgual, btnLimpiar;
    private JButton btnPorcentaje, btnRaizCuadrada, btnDecimal, btnCambiarSigno;

    public CalculadoraVista() {
        // Configuración del JFrame
        setTitle("Calculadora");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Establecer el ícono de la aplicación
        setAppIcon();

        // Área de texto para mostrar los números y resultados
        display = new JTextField("0");
        display.setEditable(false);
        display.setPreferredSize(new Dimension(250, 50));
        display.setFont(new Font("Arial", Font.PLAIN, 30));  // Tamaño de letra más grande
        display.setHorizontalAlignment(JTextField.RIGHT);    // Alinear a la derecha
        display.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // Borde alrededor del display
        add(display, BorderLayout.NORTH);

        // Panel para los botones
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 4)); // Reconfiguración del layout a 5 filas y 4 columnas

        // Crear botones numéricos y posicionarlos
        numeroButtons = new JButton[10];
        for (int i = 1; i < 10; i++) {
            numeroButtons[i] = new JButton(String.valueOf(i));
            numeroButtons[i].setFont(new Font("Arial", Font.PLAIN, 24));  // Fuente más grande
        }
        numeroButtons[0] = new JButton("0");
        numeroButtons[0].setFont(new Font("Arial", Font.PLAIN, 24));  // Fuente más grande

        // Botones de funciones y operaciones
        btnSuma = new JButton("+");
        btnSuma.setBackground(Color.LIGHT_GRAY);
        btnSuma.setFont(new Font("Arial", Font.PLAIN, 24));

        btnResta = new JButton("-");
        btnResta.setBackground(Color.LIGHT_GRAY);
        btnResta.setFont(new Font("Arial", Font.PLAIN, 24));

        btnMultiplicacion = new JButton("*");
        btnMultiplicacion.setBackground(Color.LIGHT_GRAY);
        btnMultiplicacion.setFont(new Font("Arial", Font.PLAIN, 24));

        btnDivision = new JButton("/");
        btnDivision.setBackground(Color.LIGHT_GRAY);
        btnDivision.setFont(new Font("Arial", Font.PLAIN, 24));

        btnIgual = new JButton("=");
        btnIgual.setBackground(Color.ORANGE);
        btnIgual.setFont(new Font("Arial", Font.PLAIN, 24));

        btnLimpiar = new JButton("C");
        btnLimpiar.setBackground(Color.RED);
        btnLimpiar.setFont(new Font("Arial", Font.PLAIN, 24));

        btnPorcentaje = new JButton("%");
        btnPorcentaje.setFont(new Font("Arial", Font.PLAIN, 24));

        btnRaizCuadrada = new JButton("√");
        btnRaizCuadrada.setFont(new Font("Arial", Font.PLAIN, 24));

        btnDecimal = new JButton(".");
        btnDecimal.setFont(new Font("Arial", Font.PLAIN, 24));

        btnCambiarSigno = new JButton("+/-");
        btnCambiarSigno.setFont(new Font("Arial", Font.PLAIN, 24));

        // Añadir botones en el orden correcto
        panel.add(btnPorcentaje);
        panel.add(btnRaizCuadrada);
        panel.add(btnDecimal);
        panel.add(btnCambiarSigno);

        panel.add(numeroButtons[7]);
        panel.add(numeroButtons[8]);
        panel.add(numeroButtons[9]);
        panel.add(btnDivision);

        panel.add(numeroButtons[4]);
        panel.add(numeroButtons[5]);
        panel.add(numeroButtons[6]);
        panel.add(btnMultiplicacion);

        panel.add(numeroButtons[1]);
        panel.add(numeroButtons[2]);
        panel.add(numeroButtons[3]);
        panel.add(btnResta);

        panel.add(btnLimpiar);
        panel.add(numeroButtons[0]);
        panel.add(btnIgual);
        panel.add(btnSuma);

        add(panel, BorderLayout.CENTER);

        // Opcional: Configurar atajos de teclado
        setKeyboardShortcuts();
    }

    // Método para cambiar el ícono de la aplicación
    private void setAppIcon() {
        ImageIcon icono = new ImageIcon(getClass().getResource("/Imagen/calculadora.jpg")); // Ajusta la ruta del ícono
        setIconImage(icono.getImage());
    }

    // Cambia el texto del display y ajusta el tamaño de la fuente si es necesario
    public void setDisplayText(String text) {
        display.setText(text);
        if (text.length() > 10) {
            display.setFont(new Font("Arial", Font.PLAIN, 20));
        } else {
            display.setFont(new Font("Arial", Font.PLAIN, 30));
        }
    }

    public String getDisplayText() {
        return display.getText();
    }

    public void addNumeroListener(ActionListener listenForNumeroButtons) {
        for (JButton button : numeroButtons) {
            button.addActionListener(listenForNumeroButtons);
        }
    }

    public void addDecimalListener(ActionListener listenForDecimalButton) {
        btnDecimal.addActionListener(listenForDecimalButton);
    }

    public void addOperacionListener(ActionListener listenForOperacionButtons) {
        btnSuma.addActionListener(listenForOperacionButtons);
        btnResta.addActionListener(listenForOperacionButtons);
        btnMultiplicacion.addActionListener(listenForOperacionButtons);
        btnDivision.addActionListener(listenForOperacionButtons);
    }

    public void addIgualListener(ActionListener listenForIgualButton) {
        btnIgual.addActionListener(listenForIgualButton);
    }

    public void addLimpiarListener(ActionListener listenForLimpiarButton) {
        btnLimpiar.addActionListener(listenForLimpiarButton);
    }

    public void addFuncionesListener(ActionListener listenForFunciones) {
        btnPorcentaje.addActionListener(listenForFunciones);
        btnRaizCuadrada.addActionListener(listenForFunciones);
        btnCambiarSigno.addActionListener(listenForFunciones);
    }

    private void setKeyboardShortcuts() {
        btnSuma.setMnemonic('+');
        btnResta.setMnemonic('-');
        btnMultiplicacion.setMnemonic('*');
        btnDivision.setMnemonic('/');
        btnIgual.setMnemonic('=');
        btnLimpiar.setMnemonic('C');
    }
}

