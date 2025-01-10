package maquina_snacks_archivos.servicio;

import maquina_snacks_archivos.dominio.Snack;

import java.util.ArrayList;
import java.util.List;

public class ServicioSnacksLista implements IServicioSnacks {
    private static final List<Snack> snacks;

    //bloque estatico inicializador:
    static {
        snacks = new ArrayList<>();
        snacks.add(new Snack("Papitas picantes",1700));
        snacks.add(new Snack("Energizante genérico",2200));
        snacks.add(new Snack("Galletas",1500));
    }

    public void agregarSnack(Snack snack){
        snacks.add(snack);
    }

    public void mostrarSnacks(){
        var inventarioSnacks = "";
        for (var snack: snacks){
            inventarioSnacks += snack.toString() + "\n";
        }
        System.out.println("\n--- SNACKS DISPONIBLES ---");
        System.out.println(inventarioSnacks);
    }

    public List<Snack> getSnacks(){
        return snacks;
    }
}
