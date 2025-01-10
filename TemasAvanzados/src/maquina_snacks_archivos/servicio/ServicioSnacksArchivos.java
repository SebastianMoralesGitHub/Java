package maquina_snacks_archivos.servicio;

import maquina_snacks_archivos.dominio.Snack;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ServicioSnacksArchivos implements IServicioSnacks{
    private final String NOMBRE_ARCHIVO = "snacks.txt";
    //Crear la lista de snacks
    private List<Snack> snacks = new ArrayList<>();

    //Constructor:
    public ServicioSnacksArchivos(){
        //Se crea el archivo si no existe:
        var archivo = new File(NOMBRE_ARCHIVO);
        var existe = false;
        try{
            existe = archivo.exists();
            if (existe){
                this.snacks = obtenerSnacks();
            }else{
                var salida = new PrintWriter(new FileWriter(archivo));
                salida.close();
                System.out.println("Se ha creado el archivo correctamente...");
            }
        }catch (Exception e){
            System.out.println("Error al crear el archivo: " + e);
        }
        //Si no existe, cargamos algunos snacks por defecto:
        if (!existe)
            cargarSnacksIniciales();
    }

    private void cargarSnacksIniciales(){
        this.agregarSnack(new Snack("Papitas",2000));
        this.agregarSnack(new Snack("Vive100",1800));
        this.agregarSnack(new Snack("Perrito",3500));
    }

    private List<Snack> obtenerSnacks(){
        var snacks = new ArrayList<Snack>();
        try{
            List<String> lineas = Files.readAllLines(Paths.get(NOMBRE_ARCHIVO));
            for (String linea: lineas){
                String[] lineaSnack = linea.split(",");
                var idSnack = lineaSnack[0]; //No se usará.
                var nombreSnack = lineaSnack[1];
                var precioSnack = Double.parseDouble(lineaSnack[2]);
                var snack = new Snack(nombreSnack,precioSnack);
                snacks.add(snack); //Agregamos el snack leído a la lista de snacks.
            }
        }
        catch (Exception e) {
            System.out.println("Error al leer el archivo de snacks!");
            e.printStackTrace();
        }
        return snacks;
    }

    @Override
    public void agregarSnack(Snack snack) {
        //Agregamos el nuevo snack, 1. a la lista en memoria:
        this.snacks.add(snack);
        //Guardamos el nuevo snack, 2 en el archivo:
        this.agregarSnackArchivo(snack);
    }

    private void agregarSnackArchivo(Snack snack){
        boolean anexar = false;
        var archivo = new File(NOMBRE_ARCHIVO);
        try{
            anexar = archivo.exists();
            var salida = new PrintWriter(new FileWriter(archivo,anexar));
            salida.println(snack.escribirSnack());
            salida.close(); //Se guarda la info en el archivo.
        }catch (Exception e){
            System.out.println("Error al agregar el snack: " + e.getMessage());
        }
    }

    @Override
    public void mostrarSnacks() {
        System.out.println("--- SNACKS DISPONIBLES ---");
        //Mostramos la lista de snacks en el archivo:
        var inventarioSnacks = "";
        for (var snack: this.snacks){
            inventarioSnacks += snack.toString() + "\n";
        }
        System.out.println(inventarioSnacks);
    }

    @Override
    public List<Snack> getSnacks() {
        return this.snacks;
    }
}
