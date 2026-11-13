package Excepciones;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * Esta clase denominada VentanaEquipo permite crear un equipo de maraton de
 * programacion y validar los datos de sus integrantes (ejercicio 6.7).
 * @version 1.2/2020
 */
public class VentanaEquipo extends JFrame implements ActionListener {

    private Container contenedor;
    private EquipoMaratonProgramacion equipo;
    private JTextField campoNombreEquipo, campoUniversidad, campoLenguaje;
    private JTextField campoNombre, campoApellidos;
    private JButton crearEquipo, anadir, limpiar;
    private JTextArea datos;
    private JLabel estado;

    /**
     * Constructor de la clase VentanaEquipo
     */
    public VentanaEquipo() {
        inicio();
        setTitle("Ejercicio 6.7 - Validación de campos");
        setSize(580, 460);
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

        contenedor.add(etiqueta("Nombre del equipo:", 20, 15));
        campoNombreEquipo = campo(180, 15, 190);

        contenedor.add(etiqueta("Universidad:", 20, 45));
        campoUniversidad = campo(180, 45, 190);

        contenedor.add(etiqueta("Lenguaje programación:", 20, 75));
        campoLenguaje = campo(180, 75, 190);

        crearEquipo = boton("Crear equipo", 390, 45, 155);

        contenedor.add(etiqueta("Nombre integrante:", 20, 115));
        campoNombre = campo(180, 115, 190);

        contenedor.add(etiqueta("Apellidos integrante:", 20, 145));
        campoApellidos = campo(180, 145, 190);

        anadir = boton("Añadir integrante", 390, 115, 155);
        limpiar = boton("Limpiar todo", 390, 145, 155);

        estado = new JLabel("Cree un equipo (mínimo 2, máximo 3 integrantes).");
        estado.setBounds(20, 180, 525, 23);
        contenedor.add(estado);

        datos = new JTextArea();
        datos.setEditable(false);
        JScrollPane panel = new JScrollPane(datos);
        panel.setBounds(20, 210, 525, 195);
        contenedor.add(panel);
    }

    private JLabel etiqueta(String texto, int x, int y) {
        JLabel l = new JLabel(texto);
        l.setBounds(x, y, 155, 23);
        return l;
    }

    private JTextField campo(int x, int y, int ancho) {
        JTextField t = new JTextField();
        t.setBounds(x, y, ancho, 23);
        contenedor.add(t);
        return t;
    }

    private JButton boton(String texto, int x, int y, int ancho) {
        JButton b = new JButton(texto);
        b.setBounds(x, y, ancho, 25);
        b.addActionListener(this);
        contenedor.add(b);
        return b;
    }

    /**
     * Gestiona los eventos de los botones
     */
    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == crearEquipo) {
            String nomEq = campoNombreEquipo.getText().trim();
            String univ = campoUniversidad.getText().trim();
            String leng = campoLenguaje.getText().trim();
            if (nomEq.isEmpty() || univ.isEmpty() || leng.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Complete todos los datos del equipo.",
                        "Aviso", JOptionPane.WARNING_MESSAGE);
                return;
            }
            equipo = new EquipoMaratonProgramacion(nomEq, univ, leng);
            datos.setText(equipo.imprimir());
            estado.setText("Equipo creado. Integrantes: 0 de 3 | Equipo completo: No");
        }
        if (evento.getSource() == anadir) {
            agregarIntegrante();
        }
        if (evento.getSource() == limpiar) {
            equipo = null;
            campoNombreEquipo.setText("");
            campoUniversidad.setText("");
            campoLenguaje.setText("");
            campoNombre.setText("");
            campoApellidos.setText("");
            datos.setText("");
            estado.setText("Cree un equipo (mínimo 2, máximo 3 integrantes).");
        }
    }

    /**
     * Valida nombre y apellidos mediante validarCampo y anade el programador al equipo
     */
    private void agregarIntegrante() {
        if (equipo == null) {
            JOptionPane.showMessageDialog(this, "Primero debe crear el equipo.",
                    "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        try {
            String nombre = campoNombre.getText().trim();
            String apellidos = campoApellidos.getText().trim();
            EquipoMaratonProgramacion.validarCampo(nombre);
            EquipoMaratonProgramacion.validarCampo(apellidos);
            Programador programador = new Programador(nombre, apellidos);
            equipo.anadir(programador);
            datos.setText(equipo.imprimir());
            String completo = equipo.estaCompleto() ? "Sí" : "No";
            estado.setText("Integrantes: " + equipo.tamanoEquipo + " de 3 | Equipo completo: " + completo);
            campoNombre.setText("");
            campoApellidos.setText("");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(),
                    "Error de validación", JOptionPane.ERROR_MESSAGE);
        }
    }
}
