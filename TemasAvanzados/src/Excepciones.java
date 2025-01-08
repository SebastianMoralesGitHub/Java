import java.util.Scanner;

public class Excepciones {
    public static void main(String[] args) {
        var consola = new Scanner(System.in);
        System.out.print("Ingresa el primer valor: ");
        var primerValor = Integer.parseInt(consola.nextLine());
        System.out.print("Ingresa el segundo valor: ");
        var segundoValor = Integer.parseInt(consola.nextLine());
        try {
            var resultado = primerValor / segundoValor;
            System.out.println("Resultado = " + resultado);
        }catch (Exception e){
            System.out.println("Ocurrió un error: " + e.getLocalizedMessage());
        }
    }
}
