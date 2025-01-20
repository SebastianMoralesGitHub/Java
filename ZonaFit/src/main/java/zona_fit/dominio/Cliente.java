package zona_fit.dominio;

import java.util.Objects;

public class Cliente {
    private int id;
    private String nombreCliente;
    private String apellidoCliente;
    private int membresia;

    public Cliente(){}

    public Cliente(int id){
        this.id = id;
    }

    public Cliente(String nombreCliente, String apellidoCliente, int membresia){
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
        this.membresia = membresia;
    }

    public Cliente(int id, String nombreCliente, String apellidoCliente, int membresia){
        this(nombreCliente,apellidoCliente,membresia);
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMembresia() {
        return this.membresia;
    }

    public void setMembresia(int membresia) {
        this.membresia = membresia;
    }

    public String getApellidoCliente() {
        return this.apellidoCliente;
    }

    public void setApellidoCliente(String apellidoCliente) {
        this.apellidoCliente = apellidoCliente;
    }

    public String getNombreCliente() {
        return this.nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nombreCliente='" + nombreCliente + '\'' +
                ", apellidoCliente='" + apellidoCliente + '\'' +
                ", membresia=" + membresia +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return id == cliente.id && membresia == cliente.membresia && Objects.equals(nombreCliente, cliente.nombreCliente) && Objects.equals(apellidoCliente, cliente.apellidoCliente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombreCliente, apellidoCliente, membresia);
    }
}
