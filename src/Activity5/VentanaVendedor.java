package Excepciones;

import javax.swing.*;
import java.awt.*;

public class VentanaVendedor extends JFrame {
    private final JTextField txtNombre = new JTextField();
    private final JTextField txtApellidos = new JTextField();
    private final JTextField txtEdad = new JTextField();
    private final JTextArea txtResultado = new JTextArea(6, 35);

    public VentanaVendedor() {
        setTitle("Ejercicio 6.5 - Lanzamiento de Excepciones (Vendedor)");
        setSize(480, 320);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JPanel panelForm = new JPanel(new GridLayout(4, 2, 8, 8));
        panelForm.add(new JLabel("Nombre del vendedor:"));
        panelForm.add(txtNombre);
        panelForm.add(new JLabel("Apellidos del vendedor:"));
        panelForm.add(txtApellidos);
        panelForm.add(new JLabel("Edad del vendedor:"));
        panelForm.add(txtEdad);

        JButton btnValidar = new JButton("Registrar y Verificar Edad");
        btnValidar.addActionListener(e -> registrarVendedor());
        panelForm.add(new JLabel());
        panelForm.add(btnValidar);

        txtResultado.setEditable(false);
        panel.add(panelForm, BorderLayout.NORTH);
        panel.add(new JScrollPane(txtResultado), BorderLayout.CENTER);
        add(panel);
    }

    private void registrarVendedor() {
        try {
            String nombre = txtNombre.getText().trim();
            String apellidos = txtApellidos.getText().trim();
            int edad = Integer.parseInt(txtEdad.getText().trim());

            Vendedor vendedor = new Vendedor(nombre, apellidos);
            vendedor.verificarEdad(edad);
            txtResultado.setText("Registro exitoso:\n" + vendedor.imprimir());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "La edad debe ser un número entero.", "Error de formato", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException e) {
            txtResultado.setText("Excepción capturada: " + e.getMessage());
            JOptionPane.showMessageDialog(this, e.getMessage(), "Validación fallida", JOptionPane.WARNING_MESSAGE);
        }
    }
}
