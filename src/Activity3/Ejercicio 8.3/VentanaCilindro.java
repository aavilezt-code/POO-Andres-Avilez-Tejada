package Figuras;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VentanaCilindro extends JFrame implements ActionListener {
    private Container contenedor;
    private JLabel radio, altura, volumen, superficie, imagenFigura;
    private JTextField campoRadio, campoAltura;
    private JButton calcular;

    public VentanaCilindro() {
        inicio();
        setTitle("Cilindro");
        setSize(400, 210); // Ancho ampliado para que quepa la imagen
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void inicio() {
        contenedor = getContentPane();
        contenedor.setLayout(null);

        radio = new JLabel("Radio (cms):");
        radio.setBounds(20, 20, 135, 23);
        campoRadio = new JTextField();
        campoRadio.setBounds(100, 20, 135, 23);

        altura = new JLabel("Altura (cms):");
        altura.setBounds(20, 50, 135, 23);
        campoAltura = new JTextField();
        campoAltura.setBounds(100, 50, 135, 23);

        calcular = new JButton("Calcular");
        calcular.setBounds(100, 80, 135, 23);
        calcular.addActionListener(this);

        volumen = new JLabel("Volumen (cm3):");
        volumen.setBounds(20, 110, 150, 23);

        superficie = new JLabel("Superficie (cm2):");
        superficie.setBounds(20, 140, 150, 23);

        // --- CÓDIGO PARA AGREGAR IMAGEN (RUTA DIRECTA) ---
        imagenFigura = new JLabel();
        imagenFigura.setBounds(250, 20, 120, 120); 
        
        // Leemos el archivo directamente desde la carpeta src
        ImageIcon icono = new ImageIcon("src/main/java/Figuras/cilindro.png");
        
        if (icono.getIconWidth() > 0) { // Si encuentra la imagen, el ancho será mayor a 0
            Image imgEscalada = icono.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
            imagenFigura.setIcon(new ImageIcon(imgEscalada));
            imagenFigura.setText(""); 
        } else {
            imagenFigura.setText("Sin imagen");
        }
        // -------------------------------------------------

        contenedor.add(radio);
        contenedor.add(campoRadio);
        contenedor.add(altura);
        contenedor.add(campoAltura);
        contenedor.add(calcular);
        contenedor.add(volumen);
        contenedor.add(superficie);
        contenedor.add(imagenFigura);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        boolean error = false;
        try {
            double r = Double.parseDouble(campoRadio.getText());
            double h = Double.parseDouble(campoAltura.getText());
            Cilindro cilindro = new Cilindro(r, h);
            volumen.setText("Volumen (cm3): " + String.format("%.2f", cilindro.calcularVolumen()));
            superficie.setText("Superficie (cm2): " + String.format("%.2f", cilindro.calcularSuperficie()));
        } catch (Exception e) {
            error = true;
        } finally {
            if (error) JOptionPane.showMessageDialog(null, "Campo nulo o error en formato", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
