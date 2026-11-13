package Archivos;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.*;

/**
 * Esta clase denominada VentanaLeerArchivo permite leer un archivo de texto
 * mediante flujo de bytes y mostrar su contenido en interfaz grafica (ejercicio 6.8).
 * @version 1.2/2020
 */
public class VentanaLeerArchivo extends JFrame implements ActionListener {

    private Container contenedor;
    private JLabel etiquetaRuta;
    private JTextField campoRuta;
    private JButton leer, limpiar;
    private JTextArea contenido;

    /**
     * Constructor de la clase VentanaLeerArchivo
     */
    public VentanaLeerArchivo() {
        inicio();
        setTitle("Ejercicio 6.8 - Lectura de archivos");
        setSize(560, 380);
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

        etiquetaRuta = new JLabel("Ruta del archivo:");
        etiquetaRuta.setBounds(20, 20, 120, 23);

        campoRuta = new JTextField("C:/prueba.txt");
        campoRuta.setBounds(140, 20, 385, 23);

        leer = new JButton("Leer archivo");
        leer.setBounds(20, 55, 130, 25);
        leer.addActionListener(this);

        limpiar = new JButton("Limpiar");
        limpiar.setBounds(165, 55, 100, 25);
        limpiar.addActionListener(this);

        contenido = new JTextArea();
        contenido.setEditable(false);
        JScrollPane panel = new JScrollPane(contenido);
        panel.setBounds(20, 95, 505, 230);

        contenedor.add(etiquetaRuta);
        contenedor.add(campoRuta);
        contenedor.add(leer);
        contenedor.add(limpiar);
        contenedor.add(panel);
    }

    /**
     * Gestiona los eventos de los botones
     */
    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == leer) {
            String nombreArchivo = campoRuta.getText().trim();
            try {
                contenido.setText(LeerArchivo.leer(nombreArchivo));
            } catch (IOException e) {
                contenido.setText("");
                JOptionPane.showMessageDialog(this, "No se pudo leer el archivo.",
                        "Error de lectura", JOptionPane.ERROR_MESSAGE);
            }
        }
        if (evento.getSource() == limpiar) {
            contenido.setText("");
        }
    }
}
