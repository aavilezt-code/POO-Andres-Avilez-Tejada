package Excepciones;

/**
 * Esta clase denominada PruebaExcepciones lanza diferentes excepciones en
 * situaciones especificas del programa. Los mensajes que se muestran en
 * pantalla ayudan a identificar la porcion de codigo que se ejecuto o no.
 * @version 1.2/2020
 */
public class PruebaExcepciones {

    /**
     * Ejecuta los dos bloques try/catch/finally del ejercicio 6.4
     * @return Cadena con los mensajes generados durante la ejecucion
     */
    public static String ejecutarPrueba() {
        StringBuilder salida = new StringBuilder();

        // Primer bloque try
        try {
            salida.append("Ingresando al primer try\n");
            double cociente = 10000 / 0; // Se lanza una excepcion
            salida.append("Después de la división\n"); // Nunca se ejecuta
        } catch (ArithmeticException e) { // Se captura la excepcion
            salida.append("División por cero\n");
        } finally {
            // La sentencia finally siempre se ejecuta, ocurra o no una excepcion
            salida.append("Ingresando al primer finally\n");
        }

        // Segundo bloque try
        try {
            salida.append("Ingresando al segundo try\n");
            Object objeto = null;
            objeto.toString(); // Se lanza una excepcion
            salida.append("Imprimiendo objeto\n"); // Nunca se ejecuta
        } catch (ArithmeticException e) { // La excepcion lanzada no es de este tipo
            salida.append("División por cero\n");
        } catch (Exception e) { // Se captura la excepcion
            salida.append("Ocurrió una excepción\n");
        } finally {
            // La sentencia finally siempre se ejecuta, ocurra o no una excepcion
            salida.append("Ingresando al segundo finally\n");
        }

        return salida.toString();
    }

    /**
     * Metodo main con dos bloques try que generan excepciones que deben ser gestionadas
     * @param args Argumentos de la linea de comandos
     */
    public static void main(String[] args) {
        System.out.print(ejecutarPrueba());
    }
}
