package maquina_snacks;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MaquinaSnacks {
    public static void main(String[] args) {
        maquinaSnacks();
    }

    public static void maquinaSnacks(){
        var salir = false;
        var consola = new Scanner(System.in);
        //Se crea la lista de productos de tipo snack:
        List<Snack> productos = new ArrayList<>();
        System.out.println(" --- *** MAQUINA DE SNACKS *** ---");
        Snacks.mostrarSnacks(); //Mostrar el inventario de snacks disponibles
        while (!salir) {
            try{
                var opcion = mostrarMenu(consola);
                salir = ejecutarOpciones(opcion,consola, productos);
            }catch (Exception e) {
                System.out.println("Ha ocurrido un error: " + e.getLocalizedMessage());
            } finally {
                System.out.println(); //Salto de linea despues de cada iteración.
            }
        }
    }

    private static int mostrarMenu(Scanner consola){
        System.out.print("""
                Menu:
                1) Comprar Snack.
                2) Mostrar ticket de compra.
                3) Agregar nuevo snack.
                4) Salir
                Elige una opción:\s""");
        //Leemos y retornamos la opción seleccionada:
        return Integer.parseInt(consola.nextLine());
    }

    private static boolean ejecutarOpciones(int opcion, Scanner consola, List<Snack> productos){
        var salir = false;
        switch (opcion){
            case 1 -> comprarSnack(consola, productos);
            case 2 -> mostrarTicket(productos);
            case 3 -> agregarSnack(consola);
            case 4 -> {
                System.out.println("Gracias, regresa pronto!");
                salir = true;
            }
            default -> System.out.println("Opción inválida: " + opcion);
        }
        return salir;
    }

    private static void comprarSnack(Scanner consola, List<Snack> productos){
        System.out.print("Qué snack quieres comprar (ID)? ");
        var idSnack = Integer.parseInt(consola.nextLine());
        //Validar que el snack exista en la lista de snacks
        var snackEncontrado = false;
        for (var snack: Snacks.getSnacks()){
            if (idSnack == snack.getIdSnack()){
                //Agregamos el snack a la lista:
                productos.add(snack);
                System.out.println("Se ha agregado el snack: " + snack);
                snackEncontrado = true;
                break;
            }
        }
        if (!snackEncontrado){
            System.out.println("El ID ingresado no se encuentra: " + idSnack);
        }
    }

    private static void mostrarTicket(List<Snack> productos){
        var ticket = "*** TICKET DE VENTA ***";
        var total = 0.0;
        for(var producto: productos){
            ticket += "\n\t-" + producto.getNombreSnack() + " - $" + producto.getPrecioSnack();
            total += producto.getPrecioSnack();
        }
        ticket += "\n\tTotal -> $" + total;
        System.out.println(ticket);
    }

    private static void agregarSnack(Scanner consola){
        System.out.print("Ingresa el nombre del snack a agregar: ");
        var nombre = consola.nextLine();
        System.out.print("Ingresa el precio del snack a agregar: ");
        var precio = Double.parseDouble(consola.nextLine());
        Snacks.agregarSnack(new Snack(nombre,precio));
        System.out.println("Se ha agregado el nuevo snack correctamente");
        Snacks.mostrarSnacks();
    }
}
