# Ejercicio 6.5 - Lanzamiento de excepciones

Este ejercicio consiste en una aplicación en Java con interfaz Swing que modela un `Vendedor` y valida su edad mediante la sentencia `throw new IllegalArgumentException(...)`, verificando que sea mayor de 18 años y se encuentre en el rango de 0 a 120.

## Archivos principales

* `Vendedor.java`: Modela el vendedor (`nombre`, `apellidos`, `edad`) y lanza `IllegalArgumentException` en `verificarEdad`.
* `VentanaVendedor.java`: Interfaz gráfica Swing para ingresar los datos del vendedor, validar su edad y mostrar los resultados o errores.
* `Principal.java`: Clase principal con el método `main` que inicia la ventana del ejercicio.

## Compilación y ejecución

```bash
javac -d . *.java
java Excepciones.Principal
```
