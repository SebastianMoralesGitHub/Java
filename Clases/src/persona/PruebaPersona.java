package persona;

public class PruebaPersona {
    public static void main(String[] args) {
        System.out.printf("*** Creación de clase y objetos de tipo persona ***%n");
        System.out.println("Contador de personas: " + Persona.getContadorPersonas());
        var objeto1 = new Persona("CR7","Siiuuuu");
        System.out.println(objeto1);
        System.out.println("Contador de personas: " + Persona.getContadorPersonas());
        var objeto2 = new Persona("Messi","La cabra");
        System.out.println(objeto2);
        System.out.println("Contador de personas: " + Persona.getContadorPersonas());
    }
}
