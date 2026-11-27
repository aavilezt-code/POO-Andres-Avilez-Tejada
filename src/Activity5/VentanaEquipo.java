package Excepciones;

import javax.swing.*;
import java.awt.*;

public class VentanaEquipo extends JFrame {
    private final JTextField txtEquipo = new JTextField("UNAL Dev");
    private final JTextField txtUniversidad = new JTextField("UNAL");
    private final JTextField txtLenguaje = new JTextField("Java");
    private final JTextField txtNombreProg = new JTextField();
    private final JTextField txtApellidosProg = new JTextField();
    private final JTextArea txtResumen = new JTextArea(6, 35);

    private EquipoMaratonProgramacion equipo;

    public VentanaEquipo() {
        setTitle("Ejercicio 6.7 - Validación de Campos (Equipo)");
        setSize(520, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JPanel panelForm = new JPanel(new GridLayout(6, 2, 6, 6));
        panelForm.add(new JLabel("Nombre del equipo:"));
        panelForm.add(txtEquipo);
        panelForm.add(new JLabel("Universidad:"));
        panelForm.add(txtUniversidad);
        panelForm.add(new JLabel("Lenguaje de programación:"));
        panelForm.add(txtLenguaje);
        panelForm.add(new JLabel("Nombre del programador:"));
        panelForm.add(txtNombreProg);
        panelForm.add(new JLabel("Apellidos del programador:"));
        panelForm.add(txtApellidosProg);

        JButton btnCrear = new JButton("Crear/Reiniciar Equipo");
        JButton btnAgregar = new JButton("Agregar Programador");
        btnCrear.addActionListener(e -> crearEquipo());
        btnAgregar.addActionListener(e -> agregarProgramador());

        panelForm.add(btnCrear);
        panelForm.add(btnAgregar);

        txtResumen.setEditable(false);
        panel.add(panelForm, BorderLayout.NORTH);
        panel.add(new JScrollPane(txtResumen), BorderLayout.CENTER);
        add(panel);
    }

    private void crearEquipo() {
        equipo = new EquipoMaratonProgramacion(
            txtEquipo.getText().trim(),
            txtUniversidad.getText().trim(),
            txtLenguaje.getText().trim()
        );
        txtResumen.setText("Equipo creado.\n" + equipo.obtenerResumen());
    }

    private void agregarProgramador() {
        if (equipo == null) {
            crearEquipo();
        }
        try {
            String nombre = txtNombreProg.getText().trim();
            String apellidos = txtApellidosProg.getText().trim();
            EquipoMaratonProgramacion.validarCampo(nombre);
            EquipoMaratonProgramacion.validarCampo(apellidos);

            equipo.anadir(new Programador(nombre, apellidos));
            txtNombreProg.setText("");
            txtApellidosProg.setText("");
            txtResumen.setText(equipo.obtenerResumen());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error de validación", JOptionPane.ERROR_MESSAGE);
        }
    }
}
