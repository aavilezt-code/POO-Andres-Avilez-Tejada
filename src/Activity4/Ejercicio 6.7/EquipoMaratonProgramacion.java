package Excepciones;

import java.util.*;

/**
 * Esta clase denominada EquipoMaratonProgramacion modela un equipo de
 * programadores que participara en una maraton de programacion.
 * @version 1.2/2020
 */
public class EquipoMaratonProgramacion {

    String nombreEquipo;         // Nombre del equipo de la maraton
    String universidad;          // Universidad a la que pertenece el equipo
    String lenguajeProgramacion; // Lenguaje de programacion utilizado por el equipo
    Programador[] programadores; // Programadores que conforman el equipo
    int tamanoEquipo;            // Tamano del equipo

    /**
     * Constructor de la clase EquipoMaratonProgramacion
     * @param nombreEquipo Nombre del equipo de la maraton
     * @param universidad Universidad a la que pertenece el equipo
     * @param lenguajeProgramacion Lenguaje de programacion que utilizara el equipo
     */
    EquipoMaratonProgramacion(String nombreEquipo, String universidad, String lenguajeProgramacion) {
        this.nombreEquipo = nombreEquipo;
        this.universidad = universidad;
        this.lenguajeProgramacion = lenguajeProgramacion;
        tamanoEquipo = 0; // El tamano del equipo inicialmente es cero
        programadores = new Programador[3]; // Crea un array con tres programadores
    }

    /**
     * Metodo que determina si el array de programadores del equipo esta lleno o no
     * @return Valor boolean que determina si el array de programadores esta lleno
     */
    boolean estaLleno() {
        return tamanoEquipo == programadores.length;
    }

    /**
     * Metodo que determina si el equipo cumple con el minimo de dos integrantes
     * @return true si tiene 2 o 3 integrantes
     */
    boolean estaCompleto() {
        return tamanoEquipo >= 2;
    }

    /**
     * Metodo que permite anadir un programador al array de programadores
     * @param programador Programador a agregar al equipo
     * @throws Exception Excepcion que indica que el equipo esta completo
     */
    void anadir(Programador programador) throws Exception {
        if (estaLleno()) {
            throw new Exception("El equipo está completo. No se pudo agregar programador.");
        }
        programadores[tamanoEquipo] = programador;
        tamanoEquipo++;
    }

    /**
     * Metodo que permite validar un campo evaluando si no tiene digitos y su
     * longitud no es superior a 20 caracteres (algoritmo del libro, pag. 420-421)
     * @param campo Parametro que define el campo a validar
     * @throws Exception Excepcion si el campo tiene digitos o longitud mayor a 20
     */
    static void validarCampo(String campo) throws Exception {
        if (campo == null || campo.trim().isEmpty()) {
            throw new Exception("El campo no puede estar vacío.");
        }
        for (int j = 0; j < campo.length(); j++) {
            char c = campo.charAt(j);
            if (Character.isDigit(c)) {
                throw new Exception("El nombre no puede tener dígitos.");
            }
        }
        if (campo.length() > 20) {
            throw new Exception("La longitud no debe ser superior a 20 caracteres.");
        }
    }

    /**
     * Devuelve los datos del equipo y sus integrantes registrados
     * @return Texto con la informacion del equipo
     */
    String imprimir() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nombre del equipo = ").append(nombreEquipo).append("\n");
        sb.append("Universidad = ").append(universidad).append("\n");
        sb.append("Lenguaje de programación = ").append(lenguajeProgramacion).append("\n");
        sb.append("Integrantes registrados (").append(tamanoEquipo).append("/3):\n");
        for (int i = 0; i < tamanoEquipo; i++) {
            sb.append("  ").append(i + 1).append(". ")
              .append(programadores[i].nombre).append(" ")
              .append(programadores[i].apellidos).append("\n");
        }
        return sb.toString();
    }

    /**
     * Metodo main de consola del ejercicio 6.7
     * @param args Argumentos de la linea de comandos
     * @throws Exception Si ocurre un error de validacion
     */
    public static void main(String[] args) throws Exception {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Nombre del equipo = ");
        String nombre = teclado.next();
        System.out.println("Universidad = ");
        String universidad = teclado.next();
        System.out.println("Lenguaje de programación = ");
        String lenguaje = teclado.next();
        EquipoMaratonProgramacion equipo = new EquipoMaratonProgramacion(nombre, universidad, lenguaje);
        System.out.println("Datos de los integrantes del equipo");
        for (int i = 0; i < 3; i++) {
            System.out.println("Nombre del integrante = ");
            String nombreProgramador = teclado.next();
            validarCampo(nombreProgramador);
            System.out.println("Apellidos del integrante = ");
            String apellidosProgramador = teclado.next();
            validarCampo(apellidosProgramador);
            Programador programador = new Programador(nombreProgramador, apellidosProgramador);
            equipo.anadir(programador);
        }
    }
}
