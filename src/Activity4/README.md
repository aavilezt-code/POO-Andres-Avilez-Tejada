# Actividad 4 - Manejo de Excepciones y Archivos con Interfaz Gráfica (20%)

## Descripción

Actividad 4 del curso de Programación Orientada a Objetos. Basada en los ejercicios del libro de Leonardo Bermón Angarita (págs. 400 - 427), implementados con interfaz gráfica de usuario (`Swing`) e integrados desde un menú principal.

## Ejercicios

1. **Ejercicio 6.4 (pág. 400)** - Excepciones (`try`, `catch`, `finally`)
   - Archivos: `Excepciones/PruebaExcepciones.java`, `Excepciones/VentanaPruebaExcepciones.java`
   - Concepto: Captura de excepciones (`ArithmeticException`, `Exception`) y ejecución garantizada con `finally`

2. **Ejercicio 6.5 (pág. 406)** - Lanzamiento de excepciones
   - Archivos: `Excepciones/Vendedor.java`, `Excepciones/VentanaVendedor.java`
   - Concepto: Validación de datos y lanzamiento explícito de `IllegalArgumentException` mediante `throw`

3. **Ejercicio 6.6 (pág. 412)** - Catchs múltiples
   - Archivos: `Excepciones/CalculosNumericos.java`, `Excepciones/VentanaCalculosNumericos.java`
   - Concepto: Manejo de múltiples bloques `catch` (`ArithmeticException` y `NumberFormatException`)

4. **Ejercicio 6.7 (pág. 418)** - Validación de campos
   - Archivos: `Excepciones/EquipoMaratonProgramacion.java`, `Excepciones/Programador.java`, `Excepciones/VentanaEquipo.java`
   - Concepto: Validación de cadenas de caracteres, composición con arreglos de objetos y propagación de excepciones (`throws`)

5. **Ejercicio 6.8 (pág. 427)** - Lectura de archivos
   - Archivos: `Archivos/LeerArchivo.java`, `Archivos/VentanaLeerArchivo.java`
   - Concepto: Lectura de archivos `.txt` mediante `FileInputStream`, `InputStreamReader`, `BufferedReader` y control de `IOException`

6. **Menú Principal** - Integración de la Actividad 4
   - Archivos: `Excepciones/Principal.java`, `Excepciones/VentanaPrincipal.java`
   - Concepto: Interfaz gráfica principal (`JFrame`) para ejecutar cada uno de los cinco ejercicios

## Compilación

```bash
cd POO-Andres-Avilez-Tejada/src/Activity4
javac Excepciones/*.java Archivos/*.java
```

## Ejecución

```bash
java Excepciones.Principal
```

## Fecha de Entrega

12 de noviembre de 2026