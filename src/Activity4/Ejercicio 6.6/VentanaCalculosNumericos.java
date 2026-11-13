package Excepciones;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * Esta clase denominada VentanaCalculosNumericos permite calcular el logaritmo
 * neperiano y la raiz cuadrada de un valor mediante catchs multiples (ejercicio 6.6).
 * @version 1.2/2020
 */
public class VentanaCalculosNumericos extends JFrame implements ActionListener {

    private Container contenedor;
    private JLabel etiquetaValor, resultado;
    private JTextField campoValor;
    private JButton logaritmo, raiz, limpiar;

    /**
     * Constructor de la clase VentanaCalculosNumericos
     */
    public VentanaCalculosNumericos() {
        inicio();
        setTitle("Ejercicio 6.6 - Catchs múltiples");
        setSize(490, 220);
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

        etiquetaValor = new JLabel("Valor numérico:");
        etiquetaValor.setBounds(20, 25, 120, 23);

        campoValor = new JTextField();
        campoValor.setBounds(140, 25, 180, 23);

        logaritmo = new JButton("Logaritmo neperiano");
        logaritmo.setBounds(20, 70, 175, 25);
        logaritmo.addActionListener(this);

        raiz = new JButton("Raíz cuadrada");
        raiz.setBounds(205, 70, 140, 25);
        raiz.addActionListener(this);

        limpiar = new JButton("Limpiar");
        limpiar.setBounds(355, 70, 100, 25);
        limpiar.addActionListener(this);

        resultado = new JLabel("Resultado = ");
        resultado.setBounds(20, 120, 440, 25);

        contenedor.add(etiquetaValor);
        contenedor.add(campoValor);
        contenedor.add(logaritmo);
        contenedor.add(raiz);
        contenedor.add(limpiar);
        contenedor.add(resultado);
    }

    /**
     * Gestiona los eventos de los botones empleando multiples bloques catch
     */
    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == limpiar) {
            campoValor.setText("");
            resultado.setText("Resultado = ");
            return;
        }
        try {
            double valor = Double.parseDouble(campoValor.getText().trim());
            if (evento.getSource() == logaritmo) {
                double res = CalculosNumericos.calcularLogaritmoNeperiano(valor);
                resultado.setText("Resultado = " + res);
            }
            if (evento.getSource() == raiz) {
                double res = CalculosNumericos.calcularRaizCuadrada(valor);
                resultado.setText("Resultado = " + res);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El valor debe ser numérico.",
                    "Error de formato", JOptionPane.ERROR_MESSAGE);
        } catch (ArithmeticException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(),
                    "Excepción aritmética", JOptionPane.ERROR_MESSAGE);
        }
    }
}
