package Archivos;

import java.io.*;

/**
 * Esta clase denominada LeerArchivo tiene como objetivo leer los datos
 * presentes en un archivo de texto con extension .txt (ejercicio 6.8).
 * @version 1.2/2020
 */
public class LeerArchivo {

    /**
     * Lee un archivo de texto utilizando FileInputStream, InputStreamReader y BufferedReader
     * @param nombreArchivo Ruta del archivo de texto a leer
     * @return Contenido completo del archivo
     * @throws IOException Excepcion que indica que no se pudo leer el archivo
     */
    public static String leer(String nombreArchivo) throws IOException {
        FileInputStream archivo;      // Definicion de flujo de datos
        InputStreamReader conversor;  // Definicion del flujo de lectura
        BufferedReader filtro;        // Definicion del buffer
        String linea;
        StringBuilder contenido = new StringBuilder();

        archivo = new FileInputStream(nombreArchivo);
        conversor = new InputStreamReader(archivo);
        filtro = new BufferedReader(conversor);
        linea = filtro.readLine();
        while (linea != null) {
            contenido.append(linea).append("\n");
            linea = filtro.readLine(); // Lee la siguiente linea
        }
        filtro.close(); // Cierra el archivo
        return contenido.toString();
    }

    /**
     * Metodo main que lee un archivo de texto y muestra su contenido en pantalla
     * @param args Argumentos de la linea de comandos
     * @throws Exception Si ocurre un error de entrada/salida
     */
    public static void main(String[] args) throws Exception {
        String nombreArchivo = "C:/prueba.txt"; // Definicion del archivo de texto a leer
        try {
            System.out.print(leer(nombreArchivo));
        } catch (IOException e) {
            System.out.println("No se pudo leer el archivo.");
        }
    }
}
