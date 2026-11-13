# Ejercicio 6.4 - Excepciones

Este ejercicio consiste en una aplicación en Java con interfaz Swing que ejecuta dos bloques `try/catch/finally` para demostrar la captura de `ArithmeticException` (división por cero) y `Exception` (referencia nula), mostrando en pantalla la secuencia exacta de ejecución.

## Archivos principales

* `PruebaExcepciones.java`: Contiene los bloques `try`, `catch` y `finally` del ejercicio 6.4 (pág. 400).
* `VentanaPruebaExcepciones.java`: Interfaz gráfica Swing para ejecutar la prueba y visualizar los mensajes en pantalla.
* `Principal.java`: Clase principal con el método `main` que inicia la ventana del ejercicio.

## Compilación y ejecución

```bash
javac -d . *.java
java Excepciones.Principal
```
