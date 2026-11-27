package Excepciones;

import javax.swing.*;
import java.awt.*;

public class VentanaCalculosNumericos extends JFrame {
    private final JTextField txtValor = new JTextField();
    private final JTextArea txtResultado = new JTextArea(6, 35);

    public VentanaCalculosNumericos() {
        setTitle("Ejercicio 6.6 - Catchs Múltiples");
        setSize(480, 280);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JPanel panelSuperior = new JPanel(new GridLayout(2, 2, 8, 8));
        panelSuperior.add(new JLabel("Valor numérico:"));
        panelSuperior.add(txtValor);

        JButton btnCalcular = new JButton("Calcular Logaritmo y Raíz");
        btnCalcular.addActionListener(e -> calcular());
        panelSuperior.add(new JLabel());
        panelSuperior.add(btnCalcular);

        txtResultado.setEditable(false);
        panel.add(panelSuperior, BorderLayout.NORTH);
        panel.add(new JScrollPane(txtResultado), BorderLayout.CENTER);
        add(panel);
    }

    private void calcular() {
        try {
            double valor = Double.parseDouble(txtValor.getText().trim());
            double ln = CalculosNumericos.calcularLogaritmoNeperiano(valor);
            double raiz = CalculosNumericos.calcularRaizCuadrada(valor);

            txtResultado.setText(String.format(
                "Valor ingresado: %.2f%nLogaritmo neperiano: %.4f%nRaíz cuadrada: %.4f",
                valor, ln, raiz
            ));
        } catch (NumberFormatException e) {
            txtResultado.setText("Error: El valor ingresado debe ser numérico.");
        } catch (ArithmeticException e) {
            txtResultado.setText("Error aritmético: " + e.getMessage());
        }
    }
}
