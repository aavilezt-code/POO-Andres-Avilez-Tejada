# Ejercicio 6.6 - Catchs múltiples

Este ejercicio consiste en una aplicación en Java con interfaz Swing que calcula el logaritmo neperiano (`Math.log`) y la raíz cuadrada (`Math.sqrt`) de un número, gestionando múltiples bloques `catch` (`NumberFormatException` y `ArithmeticException`).

## Archivos principales

* `CalculosNumericos.java`: Define los métodos estáticos `calcularLogaritmoNeperiano` y `calcularRaizCuadrada` con validación de valores negativos.
* `VentanaCalculosNumericos.java`: Interfaz gráfica Swing con múltiples bloques `catch` para realizar los cálculos y reportar errores.
* `Principal.java`: Clase principal con el método `main` que inicia la ventana del ejercicio.

## Compilación y ejecución

```bash
javac -d . *.java
java Excepciones.Principal
```
