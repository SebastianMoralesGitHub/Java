package ej.zona_fit;

import ej.zona_fit.modelo.Cliente;
import ej.zona_fit.servicio.IClienteServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class ZonaFitApplication implements CommandLineRunner {

	@Autowired
	private IClienteServicio clienteServicio;

	private static final Logger logger = LoggerFactory.getLogger(ZonaFitApplication.class);

	String nl = System.lineSeparator();

	public static void main(String[] args) {
		logger.info("Iniciando la aplicación");
		//Se levanta la fábrica de spring:
		SpringApplication.run(ZonaFitApplication.class, args);
		logger.info("Aplicación finalizada.");
	}

	@Override
	public void run(String... args) throws Exception {
		zonaFitApp();
	}

	private void zonaFitApp(){
		logger.info(nl + nl + "*** APLICACIÓN ZONA FIT GYM ***" + nl);
		var salir = false;
		var consola = new Scanner(System.in);
		while (!salir) {
				var opcionSeleccionada = mostrarMenu(consola);
				salir = ejecutarOpcionSeleccionada(consola,opcionSeleccionada);
				logger.info(nl);
		}

	}

	private int mostrarMenu(Scanner consola){
		logger.info("""
				1) Listar clientes.
				2) Buscar cliente.
				3) Agregar cliente.
				4) Modificar cliente.
				5) Eliminar cliente.
				6) Salir.
				Selecciona una opción:\s""");
		return Integer.parseInt(consola.nextLine());
	}

	private boolean ejecutarOpcionSeleccionada(Scanner consola, int opcionSeleccionada){
		var salir = false;
		switch (opcionSeleccionada) {
			case 1 -> { //Listar los clientes:
				logger.info(nl + "--- LISTADO DE CLIENTES ---" + nl);
				List<Cliente> clientes = clienteServicio.listarCliente();
				clientes.forEach(cliente -> logger.info(cliente.toString() + nl));
			}
			case 2 -> {//Buscar cliente por id:
				logger.info(nl + "Proporciona un Id para buscar: ");
				var idCliente = Integer.parseInt(consola.nextLine());
				Cliente cliente = clienteServicio.buscarClientePorId(idCliente);
				if (cliente != null)
					logger.info("Cliente encontrado: " + cliente + nl);
				else
					logger.info("Cliente no encontrado: " + cliente + nl);
			}
			case 3 -> {//Agregar cliente:
				logger.info(nl + "Ingresa el nombre del cliente: ");
				var nombreCliente = consola.nextLine();
				logger.info(nl + "Ingresa el apellido del cliente: ");
				var apellidoCliente = consola.nextLine();
				logger.info(nl + "Ingresa la membresía del cliente: ");
				var membresia = Integer.parseInt(consola.nextLine());
				var clienteNuevo = new Cliente();
				clienteNuevo.setNombre(nombreCliente);
				clienteNuevo.setApellido(apellidoCliente);
				clienteNuevo.setMembresia(membresia);
				clienteServicio.guardarCliente(clienteNuevo);
				logger.info(nl + "Cliente agregado: " + clienteNuevo + nl);
			}
			case 4 -> {//Modificar cliente:
				logger.info(nl + "Ingresa el Id del cliente a modificar: ");
				var idModificacion = Integer.parseInt(consola.nextLine());
				Cliente cliente = clienteServicio.buscarClientePorId(idModificacion);
				if (cliente != null) {
					logger.info(nl + "Ingresa el nombre actualizado: ");
					var nombre = consola.nextLine();
					logger.info(nl + "Ingresa el apellido actualizado: ");
					var apellido = consola.nextLine();
					logger.info(nl + "Ingresa la membresia actualizada: ");
					var membresia = Integer.parseInt(consola.nextLine());
					cliente.setNombre(nombre);
					cliente.setApellido(apellido);
					cliente.setMembresia(membresia);
					clienteServicio.guardarCliente(cliente);
					logger.info("Cliente modificado correctamente: " + cliente + nl);
				} else {
					logger.info(nl + "El cliente con el id " + idModificacion + " no existe!" + nl);
				}
			}
			case 5 -> {//Eliminar cliente:
				logger.info(nl + "Ingresa el id del cliente a eliminar: ");
				var idEliminar = Integer.parseInt(consola.nextLine());
				var cliente = clienteServicio.buscarClientePorId(idEliminar);
				if (cliente != null){
					clienteServicio.eliminarCliente(cliente);
					logger.info("Cliente eliminado: " + cliente + nl);
				}
				else {
					logger.info("El cliente con el id " + idEliminar + " no se ha encontrado!");
				}
			}
			case 6 -> {
				logger.info("Hasta pronto!!!" + nl + nl);
				salir = true;
			}
			default -> logger.info("Opción invalida!" + nl);
		}
		return salir;
	}
}
