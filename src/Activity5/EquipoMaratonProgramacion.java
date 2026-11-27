package Excepciones;

public class EquipoMaratonProgramacion {
    private final String nombreEquipo;
    private final String universidad;
    private final String lenguajeProgramacion;
    private final Programador[] programadores;
    private int tamanoEquipo;

    public EquipoMaratonProgramacion(String nombreEquipo, String universidad, String lenguajeProgramacion) {
        this.nombreEquipo = nombreEquipo;
        this.universidad = universidad;
        this.lenguajeProgramacion = lenguajeProgramacion;
        this.programadores = new Programador[3];
        this.tamanoEquipo = 0;
    }

    public boolean estaLleno() {
        return tamanoEquipo == programadores.length;
    }

    public void anadir(Programador programador) throws Exception {
        if (estaLleno()) {
            throw new Exception("El equipo está completo. No se pueden agregar más programadores.");
        }
        programadores[tamanoEquipo] = programador;
        tamanoEquipo++;
    }

    public static void validarCampo(String campo) throws Exception {
        if (campo == null || campo.trim().isEmpty()) {
            throw new Exception("El campo no puede estar vacío.");
        }
        for (int i = 0; i < campo.length(); i++) {
            if (Character.isDigit(campo.charAt(i))) {
                throw new Exception("El campo no puede contener dígitos.");
            }
        }
        if (campo.length() > 20) {
            throw new Exception("La longitud no debe ser superior a 20 caracteres.");
        }
    }

    public String obtenerResumen() {
        StringBuilder sb = new StringBuilder();
        sb.append("Equipo: ").append(nombreEquipo)
          .append(" | Universidad: ").append(universidad)
          .append(" | Lenguaje: ").append(lenguajeProgramacion).append("\nIntegrantes:\n");
        for (int i = 0; i < tamanoEquipo; i++) {
            sb.append(" - ").append(programadores[i]).append("\n");
        }
        return sb.toString();
    }
}
