# Actividad 3 - Interfaces Gráficas y Modelado UML (10%)

Fecha de entrega: Jueves, 22 de Octubre  
Modalidad: Individual

## Descripción

Esta carpeta contiene el desarrollo de la Actividad 3 del curso de Programación Orientada a Objetos 2026-2S. La actividad se centra en el diseño de Interfaces Gráficas de Usuario (GUI) utilizando javax.swing y java.awt, además del modelado de sistemas mediante diagramas UML.

Los ejercicios están basados en el libro guía: "Ejercicios de Programación Orientada a Objetos con Java y UML" de Leonardo Bermón Angarita.

## Ejercicios Desarrollados

### Ejercicio 8.2 (Página 483):

Incluye el desarrollo principal y la parte propuesta por el autor.

Implementación de interfaz gráfica interactiva.

### Ejercicio 8.3 (Página 495) - Figuras Geométricas:

Incluye el desarrollo principal y la parte propuesta.

Cálculo de volumen y superficie para: Cilindro, Esfera, Pirámide, Cubo y Prisma.

Interfaz gráfica con ventanas emergentes e imágenes renderizadas de cada figura 3D.

## Entregables Adicionales

Como parte de los requerimientos de esta actividad, junto con este código fuente, se entrega un documento PDF al correo del docente que incluye:

- Imágenes de las interfaces de usuario funcionando.
- Enlaces a este repositorio de GitHub.
- Diagrama de Clases.
- Diagrama de Objetos.
- Diagrama de Casos de Uso.

## Estructura del Código (Ejemplo Figuras)

- Principal.java: Clase principal que lanza el menú o ventana inicial.
- VentanaCilindro.java, VentanaEsfera.java, etc.: Clases JFrame para cada figura.
- Cilindro.java, Esfera.java, etc.: Lógica matemática y herencia de figuras.
- Carpeta con recursos gráficos (.png).

## Instrucciones de Ejecución

Para compilar y ejecutar el proyecto de figuras geométricas desde la línea de comandos (asegúrate de estar en la carpeta raíz del proyecto):

### Compilar:

```bash
javac -d . src/Activity3/Figuras/*.java
```

### Ejecutar:

```bash
java Figuras.Principal
```

Nota: En caso de usar un IDE como NetBeans, Maven se encargará de compilar y ejecutar automáticamente usando el botón "Run".
