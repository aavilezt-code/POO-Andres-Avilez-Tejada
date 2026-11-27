package Excepciones;

import Archivos.VentanaLeerArchivo;

import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal extends JFrame {

    public VentanaPrincipal() {
        setTitle("Actividad 5 - Menú Principal");
        setSize(420, 340);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(6, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 25, 20, 25));

        JLabel titulo = new JLabel("Seleccione un ejercicio", SwingConstants.CENTER);
        titulo.setFont(new Font("SansSerif", Font.BOLD, 16));
        panel.add(titulo);

        JButton btn64 = new JButton("Ejercicio 6.4 - Excepciones (try, catch, finally)");
        JButton btn65 = new JButton("Ejercicio 6.5 - Lanzamiento de excepciones (Vendedor)");
        JButton btn66 = new JButton("Ejercicio 6.6 - Catchs múltiples");
        JButton btn67 = new JButton("Ejercicio 6.7 - Validación de campos (Equipo)");
        JButton btn68 = new JButton("Ejercicio 6.8 - Lectura de archivos");

        btn64.addActionListener(e -> new VentanaPruebaExcepciones().setVisible(true));
        btn65.addActionListener(e -> new VentanaVendedor().setVisible(true));
        btn66.addActionListener(e -> new VentanaCalculosNumericos().setVisible(true));
        btn67.addActionListener(e -> new VentanaEquipo().setVisible(true));
        btn68.addActionListener(e -> new VentanaLeerArchivo().setVisible(true));

        panel.add(btn64);
        panel.add(btn65);
        panel.add(btn66);
        panel.add(btn67);
        panel.add(btn68);

        add(panel);
    }
}
