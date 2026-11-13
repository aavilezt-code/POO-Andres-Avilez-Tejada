# Ejercicio 6.7 - Validación de campos

Este ejercicio consiste en una aplicación en Java con interfaz Swing que gestiona un `EquipoMaratonProgramacion` (mínimo 2, máximo 3 integrantes) y valida que los nombres y apellidos de cada `Programador` no contengan dígitos ni superen los 20 caracteres.

## Archivos principales

* `Programador.java`: Modela un integrante del equipo con atributos `nombre` y `apellidos`.
* `EquipoMaratonProgramacion.java`: Gestiona el arreglo de programadores, verifica capacidad (`estaLleno`) y valida campos (`validarCampo`).
* `VentanaEquipo.java`: Interfaz gráfica Swing para crear el equipo, registrar integrantes y mostrar mensajes de validación.
* `Principal.java`: Clase principal con el método `main` que inicia la ventana del ejercicio.

## Compilación y ejecución

```bash
javac -d . *.java
java Excepciones.Principal
```
