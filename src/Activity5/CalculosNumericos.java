package Excepciones;

public class CalculosNumericos {

    public static double calcularLogaritmoNeperiano(double valor) {
        if (valor <= 0) {
            throw new ArithmeticException("El valor debe ser un número positivo para calcular el logaritmo neperiano.");
        }
        return Math.log(valor);
    }

    public static double calcularRaizCuadrada(double valor) {
        if (valor < 0) {
            throw new ArithmeticException("El valor debe ser un número positivo o cero para calcular la raíz cuadrada.");
        }
        return Math.sqrt(valor);
    }
}
