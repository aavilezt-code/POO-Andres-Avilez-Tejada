package Figuras;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VentanaPiramide extends JFrame implements ActionListener {
    private Container contenedor;
    private JLabel base, altura, apotema, volumen, superficie, imagenFigura;
    private JTextField campoBase, campoAltura, campoApotema;
    private JButton calcular;

    public VentanaPiramide() {
        inicio();
        setTitle("Pirámide");
        setSize(400, 240); 
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void inicio() {
        contenedor = getContentPane();
        contenedor.setLayout(null);

        base = new JLabel("Base (cms):");
        base.setBounds(20, 20, 135, 23);
        campoBase = new JTextField();
        campoBase.setBounds(120, 20, 120, 23);

        altura = new JLabel("Altura (cms):");
        altura.setBounds(20, 50, 135, 23);
        campoAltura = new JTextField();
        campoAltura.setBounds(120, 50, 120, 23);

        apotema = new JLabel("Apotema (cms):");
        apotema.setBounds(20, 80, 135, 23);
        campoApotema = new JTextField();
        campoApotema.setBounds(120, 80, 120, 23);

        calcular = new JButton("Calcular");
        calcular.setBounds(120, 110, 120, 23);
        calcular.addActionListener(this);

        volumen = new JLabel("Volumen (cm3):");
        volumen.setBounds(20, 140, 150, 23);

        superficie = new JLabel("Superficie (cm2):");
        superficie.setBounds(20, 170, 150, 23);

        imagenFigura = new JLabel();
        imagenFigura.setBounds(260, 20, 110, 110); 
        
        ImageIcon icono = new ImageIcon("src/main/java/Figuras/piramide.png");
        
        if (icono.getIconWidth() > 0) { 
            Image imgEscalada = icono.getImage().getScaledInstance(110, 110, Image.SCALE_SMOOTH);
            imagenFigura.setIcon(new ImageIcon(imgEscalada));
            imagenFigura.setText(""); 
        } else {
            imagenFigura.setText("Sin imagen");
        }

        contenedor.add(base);
        contenedor.add(campoBase);
        contenedor.add(altura);
        contenedor.add(campoAltura);
        contenedor.add(apotema);
        contenedor.add(campoApotema);
        contenedor.add(calcular);
        contenedor.add(volumen);
        contenedor.add(superficie);
        contenedor.add(imagenFigura);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        boolean error = false;
        try {
            double b = Double.parseDouble(campoBase.getText());
            double h = Double.parseDouble(campoAltura.getText());
            double a = Double.parseDouble(campoApotema.getText());
            Piramide piramide = new Piramide(b, h, a);
            volumen.setText("Volumen (cm3): " + String.format("%.2f", piramide.calcularVolumen()));
            superficie.setText("Superficie (cm2): " + String.format("%.2f", piramide.calcularSuperficie()));
        } catch (Exception e) {
            error = true;
        } finally {
            if (error) JOptionPane.showMessageDialog(null, "Campo nulo o error en formato", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
