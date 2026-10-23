package Figuras;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class VentanaPrincipal extends JFrame implements ActionListener {
    private Container contenedor;
    private JButton cilindro, esfera, piramide, cubo, prisma;

    public VentanaPrincipal() {
        inicio();
        setTitle("Figuras");
        setSize(350, 160);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
    }

    private void inicio() {
        contenedor = getContentPane();
        contenedor.setLayout(null);

        cilindro = new JButton("Cilindro");
        cilindro.setBounds(20, 20, 140, 23);
        cilindro.addActionListener(this);

        esfera = new JButton("Esfera");
        esfera.setBounds(170, 20, 140, 23);
        esfera.addActionListener(this);

        piramide = new JButton("Pirámide");
        piramide.setBounds(20, 50, 140, 23);
        piramide.addActionListener(this);

        cubo = new JButton("Cubo");
        cubo.setBounds(170, 50, 140, 23);
        cubo.addActionListener(this);

        prisma = new JButton("Prisma");
        prisma.setBounds(95, 80, 140, 23);
        prisma.addActionListener(this);

        contenedor.add(cilindro);
        contenedor.add(esfera);
        contenedor.add(piramide);
        contenedor.add(cubo);
        contenedor.add(prisma);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == cilindro) { new VentanaCilindro().setVisible(true); }
        if (evento.getSource() == esfera) { new VentanaEsfera().setVisible(true); }
        if (evento.getSource() == piramide) { new VentanaPiramide().setVisible(true); }
        if (evento.getSource() == cubo) { new VentanaCubo().setVisible(true); }
        if (evento.getSource() == prisma) { new VentanaPrisma().setVisible(true); }
    }
}
