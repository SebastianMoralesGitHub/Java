import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Listas {
    public static void main(String[] args) {
        List <String> miLista = new ArrayList<>();
        miLista.add("Lunes");
        miLista.add("Martes");
        miLista.add("Miercoles");
        miLista.add("Jueves");
        miLista.add("Viernes");
        miLista.add("Sabado");
        miLista.add("Domingo");
        miLista.add("Domingo");
        miLista.add("Dia festivo");
        for (String dia : miLista){
            System.out.printf("%s ",dia);
        }
        System.out.println();
        //Funciones Lambda (Funcion anonima y compacta)
        miLista.forEach(elemento -> {
            System.out.println("Elemento: " + elemento);
        });
        //Metodo de referencia
        miLista.forEach(System.out::println);

        List<String> nombres = Arrays.asList("Pedro","Pablo","Power Ranger rojo","CR7");
        System.out.println("\nNombres:");
        nombres.forEach(System.out::println);
    }
}
