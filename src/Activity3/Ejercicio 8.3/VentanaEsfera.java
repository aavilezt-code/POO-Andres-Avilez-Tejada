package Figuras;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VentanaEsfera extends JFrame implements ActionListener {
    private Container contenedor;
    private JLabel radio, volumen, superficie, imagenFigura;
    private JTextField campoRadio;
    private JButton calcular;

    public VentanaEsfera() {
        inicio();
        setTitle("Esfera");
        setSize(400, 200); 
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

        calcular = new JButton("Calcular");
        calcular.setBounds(100, 50, 135, 23);
        calcular.addActionListener(this);

        volumen = new JLabel("Volumen (cm3):");
        volumen.setBounds(20, 90, 150, 23);

        superficie = new JLabel("Superficie (cm2):");
        superficie.setBounds(20, 120, 150, 23);

        imagenFigura = new JLabel();
        imagenFigura.setBounds(250, 20, 120, 120); 
        
        ImageIcon icono = new ImageIcon("src/main/java/Figuras/esfera.png");
        
        if (icono.getIconWidth() > 0) { 
            Image imgEscalada = icono.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
            imagenFigura.setIcon(new ImageIcon(imgEscalada));
            imagenFigura.setText(""); 
        } else {
            imagenFigura.setText("Sin imagen");
        }

        contenedor.add(radio);
        contenedor.add(campoRadio);
        contenedor.add(calcular);
        contenedor.add(volumen);
        contenedor.add(superficie);
        contenedor.add(imagenFigura);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == calcular) {
            boolean error = false;
            try {
                double r = Double.parseDouble(campoRadio.getText());
                Esfera esfera = new Esfera(r);
                volumen.setText("Volumen (cm3): " + String.format("%.2f", esfera.calcularVolumen()));
                superficie.setText("Superficie (cm2): " + String.format("%.2f", esfera.calcularSuperficie()));
            } catch (Exception e) {
                error = true;
            } finally {
                if (error) JOptionPane.showMessageDialog(null, "Campo nulo o error en formato", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
