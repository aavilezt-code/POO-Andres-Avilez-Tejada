package Excepciones;

import javax.swing.*;
import java.awt.*;

public class VentanaPruebaExcepciones extends JFrame {
    private final JTextField txtNumerador = new JTextField("10000");
    private final JTextField txtDenominador = new JTextField("0");
    private final JTextField txtTexto = new JTextField("");
    private final JTextArea txtResultado = new JTextArea(10, 40);

    public VentanaPruebaExcepciones() {
        setTitle("Ejercicio 6.4 - Excepciones (try, catch, finally)");
        setSize(520, 380);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JPanel panelEntradas = new JPanel(new GridLayout(4, 2, 8, 8));
        panelEntradas.add(new JLabel("Numerador:"));
        panelEntradas.add(txtNumerador);
        panelEntradas.add(new JLabel("Denominador:"));
        panelEntradas.add(txtDenominador);
        panelEntradas.add(new JLabel("Texto (vacío simula null):"));
        panelEntradas.add(txtTexto);

        JButton btnEjecutar = new JButton("Ejecutar bloques try-catch-finally");
        btnEjecutar.addActionListener(e -> {
            String resultado = PruebaExcepciones.ejecutarPruebas(
                txtNumerador.getText(),
                txtDenominador.getText(),
                txtTexto.getText()
            );
            txtResultado.setText(resultado);
        });

        panelEntradas.add(new JLabel());
        panelEntradas.add(btnEjecutar);

        txtResultado.setEditable(false);
        panel.add(panelEntradas, BorderLayout.NORTH);
        panel.add(new JScrollPane(txtResultado), BorderLayout.CENTER);
        add(panel);
    }
}
