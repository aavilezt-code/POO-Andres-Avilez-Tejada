# Ejercicio 8.2 - Cálculo de notas

Este ejercicio consiste en una pequeña aplicación en Java con interfaz Swing que permite ingresar 5 notas, calcular su promedio, la desviación estándar, la nota mayor y la menor, y mostrar los resultados en pantalla.

## Archivos principales

- `Notas.java`: contiene la lógica de cálculo.
- `VentanaPrincipal.java`: define la interfaz gráfica.
- `Principal.java`: clase principal para iniciar la aplicación.

## Requisitos

- Java JDK 8 o superior
- NetBeans, Eclipse o cualquier IDE Java
- O, si prefieres, línea de comandos con `javac` y `java`

## Ejecutarlo en NetBeans

1. Abre NetBeans.
2. Ve a `File > Open Project`.
3. Selecciona la carpeta del repositorio.
4. Busca la clase `Principal.java`.
5. Haz clic derecho sobre ella y selecciona `Run File`.

## Ejecutarlo desde la línea de comandos

Desde la raíz del repositorio, ejecuta:

```bash
mkdir -p out
javac -d out \
  "src/Activity3/Ejercicio 8.2/Notas.java" \
  "src/Activity3/Ejercicio 8.2/VentanaPrincipal.java" \
  "src/Activity3/Ejercicio 8.2/Principal.java"

java -cp out Notas.Principal
```

> Nota: la carpeta del ejercicio tiene espacios en el nombre (`Ejercicio 8.2`), por eso es importante usar comillas en las rutas.

## Como funciona la app

- Se ingresan 5 notas en los campos correspondientes.
- Se valida que no queden vacíos.
- Se comprueban que los datos ingresados sean numéricos.
- La aplicación calcula:
  - promedio
  - desviación estándar
  - nota mayor
  - nota menor

## Observación

La clase usa el paquete `Notas`, por lo que es recomendable mantener la estructura del proyecto intacta para que la ejecución funcione correctamente.

Si deseas, también puedes convertir este ejercicio en un proyecto Java estándar con una estructura más clara (`src/`, `bin/`, `lib/`) para que sea más fácil de abrir y compilar en cualquier máquina.
