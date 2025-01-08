import java.util.Set;
import java.util.TreeSet;

public class Sets {
    public static void main(String[] args) {
        //Sets o estructuras de datos:
        Set<String> conjunto = new TreeSet<>();
        conjunto.add("Elemento primero");
        conjunto.add("Elemento segundo");
        conjunto.add("Elemento segundo");
        conjunto.add("Elemento tercero");
        conjunto.add("Elemento cuarto...");
        conjunto.forEach(System.out::println);
        conjunto.remove("Elemento cuarto...");
        System.out.println("\nNuevos elementos:");
        conjunto.forEach(System.out::println);
    }
}
