package archivos;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class AgregarContenidoArchivo {
    public static void main(String[] args) {
        boolean anexar = false;
        var nombreArchivo = "mi_archivo.txt";
        var archivo = new File(nombreArchivo);
        try{
            //Revisar si el archivo existe:
            anexar = archivo.exists();
            var salida = new PrintWriter(new FileWriter(archivo,anexar));
            var nuevoContenido = "Nuevo\nContenido\nEpaaa";
            salida.println(nuevoContenido);
            salida.close();
            System.out.println("Se agregó el contenido al archivo...");
        }catch (Exception e){
            System.out.println("Error al escribir en el archivo: " + e);
        }
    }
}
