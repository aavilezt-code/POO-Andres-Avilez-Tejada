package Excepciones;

public class PruebaExcepciones {

    public static String ejecutarPruebas(String numeradorStr, String denominadorStr, String texto) {
        StringBuilder log = new StringBuilder();

        // Primer bloque try-catch-finally: División
        try {
            log.append("Ingresando al primer try...\n");
            double num = Double.parseDouble(numeradorStr.trim());
            double den = Double.parseDouble(denominadorStr.trim());
            if (den == 0) {
                throw new ArithmeticException("División por cero");
            }
            double cociente = num / den;
            log.append("Resultado de la división: ").append(cociente).append("\n");
        } catch (ArithmeticException e) {
            log.append("Excepción aritmética: ").append(e.getMessage()).append("\n");
        } catch (NumberFormatException e) {
            log.append("Error de formato numérico en numerador o denominador.\n");
        } finally {
            log.append("Ingresando al primer finally.\n\n");
        }

        // Segundo bloque try-catch-finally: Referencia nula
        try {
            log.append("Ingresando al segundo try...\n");
            String valor = (texto == null || texto.isEmpty()) ? null : texto;
            log.append("Texto en mayúsculas: ").append(valor.toUpperCase()).append("\n");
        } catch (NullPointerException e) {
            log.append("Ocurrió una excepción: el objeto es nulo (NullPointerException).\n");
        } finally {
            log.append("Ingresando al segundo finally.\n");
        }

        return log.toString();
    }
}
