# Ejercicio 6.8 - Lectura de archivos

Este ejercicio consiste en una aplicación en Java con interfaz Swing que lee un archivo de texto línea a línea utilizando `FileInputStream`, `InputStreamReader` y `BufferedReader`, controlando errores de entrada/salida mediante `IOException`.

## Archivos principales

* `LeerArchivo.java`: Implementa la lectura de archivos mediante flujo de bytes (`FileInputStream`), conversor de caracteres (`InputStreamReader`) y búfer (`BufferedReader`).
* `VentanaLeerArchivo.java`: Interfaz gráfica Swing para indicar la ruta del archivo, leer su contenido y mostrarlo en pantalla.
* `Principal.java`: Clase principal con el método `main` que inicia la ventana del ejercicio.

## Compilación y ejecución

```bash
javac -d . *.java
java Archivos.Principal
```
