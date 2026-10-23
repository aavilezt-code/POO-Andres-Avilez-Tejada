package Figuras;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VentanaCubo extends JFrame implements ActionListener {
    private Container contenedor;
    private JLabel lado, volumen, superficie, imagenFigura;
    private JTextField campoLado;
    private JButton calcular;

    public VentanaCubo() {
        inicio();
        setTitle("Cubo");
        setSize(400, 200); 
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void inicio() {
        contenedor = getContentPane();
        contenedor.setLayout(null);

        lado = new JLabel("Lado (cms):");
        lado.setBounds(20, 20, 135, 23);
        campoLado = new JTextField();
        campoLado.setBounds(100, 20, 135, 23);

        calcular = new JButton("Calcular");
        calcular.setBounds(100, 50, 135, 23);
        calcular.addActionListener(this);

        volumen = new JLabel("Volumen (cm3):");
        volumen.setBounds(20, 90, 150, 23);
        superficie = new JLabel("Superficie (cm2):");
        superficie.setBounds(20, 120, 150, 23);

        imagenFigura = new JLabel();
        imagenFigura.setBounds(250, 20, 120, 120); 
        
        ImageIcon icono = new ImageIcon("src/main/java/Figuras/cubo.png");
        
        if (icono.getIconWidth() > 0) { 
            Image imgEscalada = icono.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
            imagenFigura.setIcon(new ImageIcon(imgEscalada));
            imagenFigura.setText(""); 
        } else {
            imagenFigura.setText("Sin imagen");
        }

        contenedor.add(lado);
        contenedor.add(campoLado);
        contenedor.add(calcular);
        contenedor.add(volumen);
        contenedor.add(superficie);
        contenedor.add(imagenFigura); 
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        boolean error = false;
        try {
            double l = Double.parseDouble(campoLado.getText());
            Cubo cubo = new Cubo(l);
            volumen.setText("Volumen (cm3): " + String.format("%.2f", cubo.calcularVolumen()));
            superficie.setText("Superficie (cm2): " + String.format("%.2f", cubo.calcularSuperficie()));
        } catch (Exception e) {
            error = true;
        } finally {
            if (error) JOptionPane.showMessageDialog(null, "Error en formato numérico", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
