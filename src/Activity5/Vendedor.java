package Excepciones;

public class Vendedor {
    private final String nombre;
    private final String apellidos;
    private int edad;

    public Vendedor(String nombre, String apellidos) {
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    public void verificarEdad(int edad) {
        if (edad < 18) {
            throw new IllegalArgumentException("El vendedor debe ser mayor de 18 años.");
        }
        if (edad < 0 || edad > 120) {
            throw new IllegalArgumentException("La edad no puede ser negativa ni mayor a 120.");
        }
        this.edad = edad;
    }

    public String imprimir() {
        return "Nombre del vendedor: " + nombre +
               "\nApellidos del vendedor: " + apellidos +
               "\nEdad del vendedor: " + edad;
    }
}
