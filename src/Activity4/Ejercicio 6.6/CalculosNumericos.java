package Excepciones;

import java.util.*;

/**
 * Esta clase denominada CalculosNumericos permite realizar dos calculos
 * matematicos: calcular el logaritmo neperiano de un valor y calcular la raiz
 * cuadrada de un valor (ejercicio 6.6).
 * @version 1.2/2020
 */
public class CalculosNumericos {

    /**
     * Metodo que calcula el logaritmo neperiano de un valor numerico.
     * Si el valor pasado como parametro no es correcto se genera la excepcion correspondiente.
     * @param valor Parametro que define el valor al cual se le calculara el logaritmo neperiano
     * @return El resultado del logaritmo neperiano
     * @throws ArithmeticException Excepcion aritmetica que indica que el numero debe ser positivo
     */
    static double calcularLogaritmoNeperiano(double valor) {
        if (valor < 0) {
            // Si el valor es negativo, se genera una excepcion aritmetica (pag. 413)
            throw new ArithmeticException("El valor debe ser un número positivo para calcular el logaritmo");
        }
        return Math.log(valor);
    }

    /**
     * Metodo que calcula la raiz cuadrada de un valor numerico.
     * Si el valor pasado como parametro no es correcto se genera la excepcion correspondiente.
     * @param valor Parametro que define el valor al cual se le calculara la raiz cuadrada
     * @return El resultado de la raiz cuadrada
     * @throws ArithmeticException Excepcion aritmetica que indica que el numero debe ser positivo
     */
    static double calcularRaizCuadrada(double valor) {
        if (valor < 0) {
            // Si el valor es negativo, se genera una excepcion aritmetica (pag. 413)
            throw new ArithmeticException("El valor debe ser un número positivo para calcular la raíz cuadrada");
        }
        return Math.sqrt(valor);
    }

    /**
     * Metodo main que solicita un valor numerico por teclado y calcula su logaritmo neperiano y raiz cuadrada
     * @param args Argumentos de la linea de comandos
     */
    public static void main(String[] args) {
        System.out.print("Valor numérico = ");
        Scanner teclado = new Scanner(System.in);
        try {
            double valor = teclado.nextDouble();
            System.out.println("Resultado logaritmo = " + calcularLogaritmoNeperiano(valor));
            System.out.println("Resultado raíz cuadrada = " + calcularRaizCuadrada(valor));
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("El valor debe ser numérico");
        }
    }
}
