package zona_fit.datos;
import zona_fit.dominio.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import static zona_fit.conexion.Conexion.getConexion;

public class ClienteDAO implements IClienteDAO{

    @Override
    public List<Cliente> listarClientes() {
        List<Cliente> clientes = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        Connection con = getConexion();
        var sql = "SELECT * FROM cliente ORDER BY idcliente";
        try{
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                var cliente = new Cliente();
                cliente.setId(rs.getInt("idcliente"));
                cliente.setNombreCliente(rs.getString("nombre"));
                cliente.setApellidoCliente(rs.getString("apellido"));
                cliente.setMembresia(rs.getInt("membresia"));
                clientes.add(cliente);
            }
        }catch (Exception e) {
            System.out.println("Error al listar clientes: " + e);
        }
        finally {
            try {
            con.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar la conexión. " + e);
            }
        }
        return clientes;
    }

    @Override
    public boolean buscarClientePorId(Cliente cliente) {
        PreparedStatement ps;
        ResultSet rs;
        var con = getConexion();
        var sql = "SELECT * FROM cliente WHERE idcliente = ?";
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1,cliente.getId());
            rs = ps.executeQuery();
            if (rs.next()){
                cliente.setNombreCliente(rs.getString("nombre"));
                cliente.setApellidoCliente(rs.getString("apellido"));
                cliente.setMembresia(rs.getInt("membresia"));
                return true;
            }
        }catch (Exception e){
            System.out.println("Error al recuperar cliente por id: " + e);
        }
        finally {
            try{
                con.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar la conexión: " + e);
            }
        }
        return false;
    }

    @Override
    public boolean agregarCliente(Cliente cliente) {
        PreparedStatement ps;
        Connection con = getConexion();
        String sql = "INSERT INTO cliente(nombre,apellido,membresia) "
                + "VALUES(?,?,?)";
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1,cliente.getNombreCliente());
            ps.setString(2,cliente.getApellidoCliente());
            ps.setInt(3,cliente.getMembresia());
            ps.execute();
            return true;
        } catch (Exception e) {
            System.out.println("Error al agregar cliente: " + e);
        }
        finally {
            try{
                con.close();
            }catch (Exception e) {
                System.out.println("Error al cerrar la conexión: " + e);
            }
        }
        return false;
    }

    @Override
    public boolean modificarCliente(Cliente cliente) {
        PreparedStatement ps;
        Connection con = getConexion();
        var sql = "UPDATE cliente SET nombre=?, apellido=?, membresia=? " +
                "WHERE idcliente = ?";
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1,cliente.getNombreCliente());
            ps.setString(2,cliente.getApellidoCliente());
            ps.setInt(3,cliente.getMembresia());
            ps.setInt(4,cliente.getId());
            ps.execute();
            return true;
        } catch (Exception e) {
            System.out.println("Error al modificar cliente: " + e);
        }
        finally {
            try{
                con.close();
            }catch (Exception e) {
                System.out.println("Error al cerrar la conexión: " + e);
            }
        }
        return false;
    }

    @Override
    public boolean eliminarCliente(Cliente cliente) {
        PreparedStatement ps;
        Connection con = getConexion();
        String sql = "DELETE FROM cliente WHERE idcliente = ?";
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1,cliente.getId());
            ps.execute();
            return true;
        }catch(Exception e){
            System.out.println("Error al eliminar el cliente: " + e);
        }
        finally {
            try{
                con.close();
            }catch (Exception e){
                System.out.println("Error al cerrar la conexión: " + e);
            }
        }
        return false;
    }
}
