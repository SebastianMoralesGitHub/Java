package persona;

//Clase:
public class Persona {
    //Atributos:
    private static int contadorPersonas = 0;
    private String nombre;
    private String apellido;
    private int idPersona;
    //Constructor vácio:
    public Persona(){}
    //Constructor público con los dos atributos:
    public Persona(String nombre, String apellido){
        this.nombre = nombre;
        this.apellido = apellido;
        //Asignacion de id unico con ayuda de la variable estatica
        this.idPersona = ++Persona.contadorPersonas;
    }
    //Metodos:
    public String getNombre(){
        return this.nombre;
    }
    public String getApellido(){
        return this.apellido;
    }
    public int getIdPersona() {
        return this.idPersona;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setApellido(String apellido){
        this.apellido = apellido;
    }
    @Override
    public String toString(){
        return "ID: " + idPersona + " nombre: " + this.nombre + ", apellido: " + this.apellido + " Dir: " + super.toString();
    }
    public static int getContadorPersonas(){
        return Persona.contadorPersonas;
    }
}
