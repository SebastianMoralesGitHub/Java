package ej.zona_fit.gui;

import ej.zona_fit.modelo.Cliente;
import ej.zona_fit.servicio.ClienteServicio;
import ej.zona_fit.servicio.IClienteServicio;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@Component
public class ZonaFitForma extends JFrame{
    private JPanel panelPrincipal;
    private JPanel panelTitulo;
    private JTable clientesTabla;
    private JPanel tablaPanel;
    private JPanel botonesPanel;
    private JPanel formularioPanel;
    private JTextField nombreTexto;
    private JLabel nombreEtiqueta;
    private JLabel apellidoEtiqueta;
    private JTextField apellidoTexto;
    private JTextField membresiaTexto;
    private JButton guardarButton;
    private JButton eliminarBoton;
    private JButton limpiarBoton;
    IClienteServicio clienteServicio;
    private DefaultTableModel tablaModeloClientes;
    private Integer idCliente;

    @Autowired
    public ZonaFitForma(ClienteServicio clienteServicio){
        this.clienteServicio = clienteServicio;
        iniciarForma();
        guardarButton.addActionListener(e -> {
            guardarCliente();
        });
        limpiarBoton.addActionListener(e -> {
            limpiarFormulario();
        });
        clientesTabla.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                cargarClienteSeleccionado();
            }
        });
        eliminarBoton.addActionListener(e -> {
            eliminarCliente();
        });
    }

    private void iniciarForma(){
        setContentPane(panelPrincipal);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900,700);
        setLocationRelativeTo(null); //Para centrar la ventana.
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        //Se evita la edición de las celdas:
        this.tablaModeloClientes = new DefaultTableModel(0,4){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        String[] cabeceros = {"ID","Nombre","Apellidos","Membresia"};
        this.tablaModeloClientes.setColumnIdentifiers(cabeceros);
        this.clientesTabla = new JTable(tablaModeloClientes);
        //Se restringe la selección a solo un registro:
        this.clientesTabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        //Cargar listado de clientes:
        listarClientes();
    }

    private void listarClientes(){
        this.tablaModeloClientes.setRowCount(0);
        var clientes = this.clienteServicio.listarCliente();
        clientes.forEach(cliente -> {
            Object[] renglonCliente = {
                    cliente.getIdCliente(),
                    cliente.getNombre(),
                    cliente.getApellido(),
                    cliente.getMembresia()
            };
            this.tablaModeloClientes.addRow(renglonCliente);
        });
    }

    private void guardarCliente(){
        if (nombreTexto.getText().isBlank()){
            mostrarMensaje("Se debe registrar el nombre del cliente!");
            nombreTexto.requestFocusInWindow();
            return;
        }
        if (membresiaTexto.getText().isBlank()) {
            mostrarMensaje("Se debe registrar un número de membresía!");
            membresiaTexto.requestFocusInWindow();
            return;
        }
        //Recuperamos los valores ingresados:
        var nombre = nombreTexto.getText();
        var apellido = apellidoTexto.getText();
        var membresia = Integer.parseInt(membresiaTexto.getText());
        var cliente = new Cliente(this.idCliente,nombre,apellido,membresia);
        this.clienteServicio.guardarCliente(cliente); //Insertar / modificar
        if (this.idCliente == null)
            mostrarMensaje("Se agregó el cliente nuevo!");
        else
            mostrarMensaje("Se actualizó el cliente!");
        limpiarFormulario();
        listarClientes();
    }

    private void cargarClienteSeleccionado(){
        var renglon = clientesTabla.getSelectedRow();
        if (renglon != -1) { //-1 significa que no se seleccionó ningún registro
            var id = clientesTabla.getModel().getValueAt(renglon, 0).toString();
            this.idCliente = Integer.parseInt(id);
            var nombre = clientesTabla.getModel().getValueAt(renglon, 1).toString();
            this.nombreTexto.setText(nombre);
            var apellido = clientesTabla.getModel().getValueAt(renglon, 2).toString();
            this.apellidoTexto.setText(apellido);
            var membresia = clientesTabla.getModel().getValueAt(renglon, 3).toString();
            this.membresiaTexto.setText(membresia);
        }
    }

    private void eliminarCliente(){
        if (this.idCliente == null)
            mostrarMensaje("No se ha seleccionado un cliente para realizar esta operación!");
        else {
            var cliente = new Cliente();
            cliente.setIdCliente(this.idCliente);
            clienteServicio.eliminarCliente(cliente);
            mostrarMensaje("Se eliminó el cliente con el id " + this.idCliente);
            limpiarFormulario();
            listarClientes();
        }
    }

    private void limpiarFormulario(){
        nombreTexto.setText("");
        apellidoTexto.setText("");
        membresiaTexto.setText("");
        //Limpiar el id del cliente seleccionado:
        this.idCliente = null;
        //Deseleccionar el registro de la tabla:
        this.clientesTabla.getSelectionModel().clearSelection();
    }

    private void mostrarMensaje(String mensaje){
        JOptionPane.showMessageDialog(this, mensaje);
    }
}
