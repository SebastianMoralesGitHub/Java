package excepciones;

public class PruebaAritmetica {
    public static void main(String[] args) {
        try {
            var resultado = Aritmetica.division(15, 0);
            System.out.println("Resultado = " + resultado);
        }
        catch (Exception e){
            System.out.println("Ha ocurrido un error: " + e.getLocalizedMessage());
        }
        finally {
            System.out.println("Se realizó la validación de dividir entre cero.");
        }
    }
}
