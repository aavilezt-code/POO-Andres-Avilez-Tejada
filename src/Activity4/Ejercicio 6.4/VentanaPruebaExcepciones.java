package Excepciones;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * Esta clase denominada VentanaPruebaExcepciones muestra en pantalla la
 * ejecucion del ejercicio 6.4 mediante una interfaz grafica.
 * @version 1.2/2020
 */
public class VentanaPruebaExcepciones extends JFrame implements ActionListener {

    private Container contenedor;
    private JButton ejecutar, limpiar;
    private JTextArea salida;

    /**
     * Constructor de la clase VentanaPruebaExcepciones
     */
    public VentanaPruebaExcepciones() {
        inicio();
        setTitle("Ejercicio 6.4 - Excepciones");
        setSize(520, 340);
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

        ejecutar = new JButton("Ejecutar prueba");
        ejecutar.setBounds(20, 20, 150, 25);
        ejecutar.addActionListener(this);

        limpiar = new JButton("Limpiar");
        limpiar.setBounds(185, 20, 100, 25);
        limpiar.addActionListener(this);

        salida = new JTextArea();
        salida.setEditable(false);
        JScrollPane panel = new JScrollPane(salida);
        panel.setBounds(20, 60, 465, 225);

        contenedor.add(ejecutar);
        contenedor.add(limpiar);
        contenedor.add(panel);
    }

    /**
     * Gestiona los eventos de los botones
     */
    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == ejecutar) {
            salida.setText(PruebaExcepciones.ejecutarPrueba());
        }
        if (evento.getSource() == limpiar) {
            salida.setText("");
        }
    }
}
