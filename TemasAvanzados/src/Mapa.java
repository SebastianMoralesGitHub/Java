import java.util.HashMap;
import java.util.Map;

public class Mapa {
    public static void main(String[] args) {
        Map<String,String> persona = new HashMap<>();
        persona.put("nombre","Diego");
        persona.put("apellido","Morales");
        persona.put("edad","29");
        System.out.println("Valores del mapa:");
        persona.entrySet().forEach(System.out::println);
        persona.put("edad","28");
        persona.remove("apellido");
        System.out.println("Valores del mapa nuevo:");
        persona.entrySet().forEach(System.out::println);
        //Iterar sobre el mapa por separado
        System.out.println("\nIterando los elementos por separado (llave/valor)");
        persona.forEach((llave,valor)->
            System.out.printf("Llave: %s, Valor: %s%n",llave,valor));
        System.out.println("Xd");
    }
}
