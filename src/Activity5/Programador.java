package Excepciones;

public class Programador {
    private final String nombre;
    private final String apellidos;

    public Programador(String nombre, String apellidos) {
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    @Override
    public String toString() {
        return nombre + " " + apellidos;
    }
}
