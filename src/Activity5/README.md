# Actividad 5 - Excepciones, Validación de Campos y Lectura de Archivos con Interfaz Gráfica (20%)

## Descripción

Actividad 5 del curso de Programación Orientada a Objetos. Basada en los ejercicios del libro de Leonardo Bermón Angarita (págs. 400 - 427), implementados con interfaz gráfica de usuario (`Swing`) e integrados en una ventana principal mediante pestañas (`JTabbedPane`).

## Ejercicios

1. **Ejercicio 6.4 (pág. 400)** - Excepciones (`try`, `catch`, `finally`)
   - Archivos: `ejercicio6_4/Ejercicio6_4Panel.java`
   - Concepto: Captura de excepciones (`ArithmeticException`, `NumberFormatException`, `NullPointerException`) y ejecución garantizada con `finally`

2. **Ejercicio 6.5 (pág. 406)** - Lanzamiento de excepciones
   - Archivos: `ejercicio6_5/Vendedor.java`, `ejercicio6_5/Ejercicio6_5Panel.java`
   - Concepto: Validación de datos y lanzamiento explícito de `IllegalArgumentException` mediante `throw`

3. **Ejercicio 6.6 (pág. 412)** - Catchs múltiples
   - Archivos: `ejercicio6_6/CalculosNumericos.java`, `ejercicio6_6/Ejercicio6_6Panel.java`
   - Concepto: Manejo de múltiples bloques `catch` (`ArithmeticException` y `NumberFormatException`)

4. **Ejercicio 6.7 (pág. 418)** - Validación de campos
   - Archivos: `ejercicio6_7/Programador.java`, `ejercicio6_7/EquipoMaratonProgramacion.java`, `ejercicio6_7/Ejercicio6_7Panel.java`
   - Concepto: Validación de cadenas de caracteres, composición con arreglos de objetos y propagación de excepciones (`throws`)

5. **Ejercicio 6.8 (pág. 427)** - Lectura de archivos
   - Archivos: `ejercicio6_8/LeerArchivo.java`, `ejercicio6_8/Ejercicio6_8Panel.java`
   - Concepto: Lectura de archivos `.txt` mediante `FileInputStream`, `InputStreamReader`, `BufferedReader` y control de `IOException`

6. **Ventana Principal** - Integración de la Actividad 5
   - Archivos: `MainActivity5.java`
   - Concepto: Interfaz gráfica principal (`JFrame` con `JTabbedPane`) para ejecutar cada uno de los cinco ejercicios

## Compilación

```bash
cd POO-Andres-Avilez-Tejada
javac -d out src/Activity5/*.java src/Activity5/*/*.java
