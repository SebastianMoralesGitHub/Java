package zona_fit.presentacion;

import com.mysql.cj.xdevapi.Client;
import zona_fit.datos.ClienteDAO;
import zona_fit.datos.IClienteDAO;
import zona_fit.dominio.Cliente;

import java.util.Scanner;

public class ZonaFitAPP {
    public static void main(String[] args) {
        zonaFitAPP();
    }

    private static void zonaFitAPP(){
        var salir = false;
        var consola = new Scanner(System.in);
        // Se crea el objeto de la clase clienteDao:
        IClienteDAO clienteDao = new ClienteDAO();
        while(!salir){
            try{
                var opcion = mostrarMenu(consola);
                salir = ejecutarOpciones(consola,opcion,clienteDao);
            }catch (Exception e){
                System.out.println("Error al ejecutar opciones: " + e.getMessage());
            }
            System.out.println();
        }
    }

    private static int mostrarMenu(Scanner consola){
        System.out.print("""
                *** ZONA FIT GYM ***
                1) Listar clientes.
                2) Buscar cliente.
                3) Agregar cliente.
                4) Modificar cliente.
                5) Eliminar cliente.
                6) Salir.
                Selecciona una opción:\s""");
        return Integer.parseInt(consola.nextLine());
    }

    private static boolean ejecutarOpciones(Scanner consola, int opcion, IClienteDAO clienteDAO){
        var salir = false;
        switch (opcion){
            case 1 -> { //Listar clientes
                System.out.println("--- LISTADO DE CLIENTES ---");
                var clientes = clienteDAO.listarClientes();
                clientes.forEach(System.out::println);
            }
            case 2 -> {//Buscar cliente por ID
                System.out.print("Proporciona un ID a buscar: ");
                var idCliente = Integer.parseInt(consola.nextLine());
                var cliente = new Cliente(idCliente);
                var encontrado = clienteDAO.buscarClientePorId(cliente);
                if (encontrado)
                    System.out.println("Cliente encontrado: " + cliente);
                else
                    System.out.printf("El cliente con el id %d no fue encontrado.%n",cliente.getId());
            }
            case 3 -> {//Agregar cliente:
                System.out.print("Proporciona el nombre del nuevo cliente: ");
                var nombreNuevo = consola.nextLine();
                System.out.print("proporciona el apellido del nuevo cliente: ");
                var apellidoNuevo = consola.nextLine();
                System.out.print("Digita la membresia del nuevo cliente: ");
                var membresiaNueva = Integer.parseInt(consola.nextLine());
                var clienteNuevo = new Cliente(nombreNuevo,apellidoNuevo,membresiaNueva);
                var agregado = clienteDAO.agregarCliente(clienteNuevo);
                if (agregado)
                    System.out.println("Se ha agregado al nuevo cliente: " + clienteNuevo);
                else
                    System.out.println("No se ha agregado al nuevo cliente: " + clienteNuevo);
            }
            case 4 -> {//Modificar cliente:
                System.out.print("Ingresa el id del cliente a modificar: ");
                var idAModificar = Integer.parseInt(consola.nextLine());
                System.out.print("Ingresa el nombre actualizado: ");
                var nombreAModificar = consola.nextLine();
                System.out.print("Ingresa el apellido actualizado: ");
                var apellidoAModificar = consola.nextLine();
                System.out.print("Ingresa la membresia actualizada: ");
                var membresiaAModificar = Integer.parseInt(consola.nextLine());
                var clienteModificado = new Cliente(idAModificar,nombreAModificar,apellidoAModificar,membresiaAModificar);
                var modificado = clienteDAO.modificarCliente(clienteModificado);
                if (modificado)
                    System.out.println("Se han actualizado los datos del cliente: " + clienteModificado);
                else
                    System.out.println("No se han podido actualizar los datos: " + clienteModificado);
            }
            case 5 -> {//Eliminar cliente:
                System.out.print("Ingresa el id del cliente que desea eliminar: ");
                var idAEliminar = Integer.parseInt(consola.nextLine());
                var clienteEliminado = new Cliente(idAEliminar);
                var eliminado = clienteDAO.eliminarCliente(clienteEliminado);
                if (eliminado)
                    System.out.printf("El cliente con el id %d fué eliminado!%n",clienteEliminado.getId());
                else
                    System.out.printf("El cliente con el id %d no se ha podido eliminar!%n",clienteEliminado.getId());
            }
            case 6 -> {//Salir de la app:
                System.out.println("Hasta luego!");
                salir = true;
            }
            default -> System.out.println("Selecciona una opción válida!");
        }
            return salir;
    }
}
