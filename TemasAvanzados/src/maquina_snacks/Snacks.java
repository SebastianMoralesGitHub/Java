package maquina_snacks;

import java.util.ArrayList;
import java.util.List;

public class Snacks {
    private static final List<Snack> snacks;

    //bloque estatico inicializador:
    static {
        snacks = new ArrayList<>();
        snacks.add(new Snack("Papitas picantes",1700));
        snacks.add(new Snack("Energizante genérico",2200));
        snacks.add(new Snack("Galletas",1500));
    }

    public static void agregarSnack(Snack snack){
        snacks.add(snack);
    }

    public static void mostrarSnacks(){
        var inventarioSnacks = "";
        for (var snack: snacks){
            inventarioSnacks += snack.toString() + "\n";
        }
        System.out.println("\n--- SNACKS DISPONIBLES ---");
        System.out.println(inventarioSnacks);
    }

    public static List<Snack> getSnacks(){
        return snacks;
    }
}
