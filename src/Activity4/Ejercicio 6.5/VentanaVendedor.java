package Excepciones;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * Esta clase denominada VentanaVendedor permite ingresar los datos de un
 * vendedor y verificar su edad mediante una interfaz grafica (ejercicio 6.5).
 * @version 1.2/2020
 */
public class VentanaVendedor extends JFrame implements ActionListener {

    private Container contenedor;
    private JLabel etiquetaNombre, etiquetaApellidos, etiquetaEdad;
    private JTextField campoNombre, campoApellidos, campoEdad;
    private JButton crearVendedor, limpiar;
    private JTextArea resultado;

    /**
     * Constructor de la clase VentanaVendedor
     */
    public VentanaVendedor() {
        inicio();
        setTitle("Ejercicio 6.5 - Lanzamiento de excepciones");
        setSize(500, 360);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
    }

    /**
     * Crea los componentes graficos y los ubica en la ventana
     */
    private void inicio() {
        contenedor = getContentPane();
        contenedor.setLayout(null);

        etiquetaNombre = new JLabel("Nombre del vendedor:");
        etiquetaNombre.setBounds(20, 20, 150, 23);
        campoNombre = new JTextField();
        campoNombre.setBounds(180, 20, 220, 23);

        etiquetaApellidos = new JLabel("Apellidos del vendedor:");
        etiquetaApellidos.setBounds(20, 55, 150, 23);
        campoApellidos = new JTextField();
        campoApellidos.setBounds(180, 55, 220, 23);

        etiquetaEdad = new JLabel("Edad del vendedor:");
        etiquetaEdad.setBounds(20, 90, 150, 23);
        campoEdad = new JTextField();
        campoEdad.setBounds(180, 90, 220, 23);

        crearVendedor = new JButton("Verificar y crear");
        crearVendedor.setBounds(20, 130, 160, 25);
        crearVendedor.addActionListener(this);

        limpiar = new JButton("Limpiar");
        limpiar.setBounds(195, 130, 100, 25);
        limpiar.addActionListener(this);

        resultado = new JTextArea();
        resultado.setEditable(false);
        JScrollPane panel = new JScrollPane(resultado);
        panel.setBounds(20, 170, 445, 135);

        contenedor.add(etiquetaNombre);
        contenedor.add(campoNombre);
        contenedor.add(etiquetaApellidos);
        contenedor.add(campoApellidos);
        contenedor.add(etiquetaEdad);
        contenedor.add(campoEdad);
        contenedor.add(crearVendedor);
        contenedor.add(limpiar);
        contenedor.add(panel);
    }

    /**
     * Gestiona los eventos de los botones
     */
    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == crearVendedor) {
            verificarVendedor();
        }
        if (evento.getSource() == limpiar) {
            campoNombre.setText("");
            campoApellidos.setText("");
            campoEdad.setText("");
            resultado.setText("");
        }
    }

    /**
     * Crea el vendedor, verifica su edad y captura IllegalArgumentException o NumberFormatException
     */
    private void verificarVendedor() {
        try {
            String nombre = campoNombre.getText().trim();
            String apellidos = campoApellidos.getText().trim();
            if (nombre.isEmpty() || apellidos.isEmpty()) {
                throw new IllegalArgumentException("El nombre y los apellidos son obligatorios.");
            }
            int edad = Integer.parseInt(campoEdad.getText().trim());
            Vendedor vendedor = new Vendedor(nombre, apellidos);
            vendedor.verificarEdad(edad);
            resultado.setText(vendedor.imprimir());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "La edad debe ser un valor numérico entero.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException e) {
            resultado.setText("");
            JOptionPane.showMessageDialog(this, e.getMessage(),
                    "Excepción de argumento ilegal", JOptionPane.ERROR_MESSAGE);
        }
    }
}
