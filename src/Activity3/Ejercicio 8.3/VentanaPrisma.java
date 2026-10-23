package Figuras;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VentanaPrisma extends JFrame implements ActionListener {
    private Container contenedor;
    private JLabel base, altura, profundidad, volumen, superficie, imagenFigura;
    private JTextField campoBase, campoAltura, campoProfundidad;
    private JButton calcular;

    public VentanaPrisma() {
        inicio();
        setTitle("Prisma");
        setSize(420, 270); 
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void inicio() {
        contenedor = getContentPane();
        contenedor.setLayout(null);

        base = new JLabel("Base (cms):");
        base.setBounds(20, 20, 135, 23);
        campoBase = new JTextField();
        campoBase.setBounds(140, 20, 100, 23);

        altura = new JLabel("Altura (cms):");
        altura.setBounds(20, 50, 135, 23);
        campoAltura = new JTextField();
        campoAltura.setBounds(140, 50, 100, 23);
        
        profundidad = new JLabel("Profundidad (cms):");
        profundidad.setBounds(20, 80, 135, 23);
        campoProfundidad = new JTextField();
        campoProfundidad.setBounds(140, 80, 100, 23);

        calcular = new JButton("Calcular");
        calcular.setBounds(140, 115, 100, 23);
        calcular.addActionListener(this);

        volumen = new JLabel("Volumen (cm3):");
        volumen.setBounds(20, 160, 200, 23);
        
        superficie = new JLabel("Superficie (cm2):");
        superficie.setBounds(20, 190, 200, 23);

        imagenFigura = new JLabel();
        imagenFigura.setBounds(260, 30, 120, 120); 
        
        ImageIcon icono = new ImageIcon("src/main/java/Figuras/prisma.png");
        
        if (icono.getIconWidth() > 0) { 
            Image imgEscalada = icono.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
            imagenFigura.setIcon(new ImageIcon(imgEscalada));
            imagenFigura.setText(""); 
        } else {
            imagenFigura.setText("Sin imagen");
        }

        contenedor.add(base);
        contenedor.add(campoBase);
        contenedor.add(altura);
        contenedor.add(campoAltura);
        contenedor.add(profundidad);
        contenedor.add(campoProfundidad);
        contenedor.add(calcular);
        contenedor.add(volumen);
        contenedor.add(superficie);
        contenedor.add(imagenFigura);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        boolean error = false;
        try {
            double b = Double.parseDouble(campoBase.getText());
            double h = Double.parseDouble(campoAltura.getText());
            double p = Double.parseDouble(campoProfundidad.getText());
            
            Prisma prisma = new Prisma(b, h, p);
            
            volumen.setText("Volumen (cm3): " + String.format("%.2f", prisma.calcularVolumen()));
            superficie.setText("Superficie (cm2): " + String.format("%.2f", prisma.calcularSuperficie()));
        } catch (Exception e) {
            error = true;
        } finally {
            if (error) JOptionPane.showMessageDialog(null, "Error en formato numérico", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
