package ventas;

import java.util.Arrays;

public class Orden{
    private final int idOrden;
    private Producto[] productos;
    private int contadorProductos;
    private static final int MAX_PRODUCTOS = 10;
    private static int contadorOrdenes;

    public Orden(){
        this.idOrden = ++Orden.contadorOrdenes;
        this.productos = new Producto[Orden.MAX_PRODUCTOS];
    }

    public void agregarProducto(Producto producto){
        if (this.contadorProductos < Orden.MAX_PRODUCTOS)
            this.productos[this.contadorProductos++] = producto;
        else System.out.println("Se ha alcanzado el máximo de productos: " + Orden.MAX_PRODUCTOS);
    }

    public double calcularTotal() {
        double total = 0;
        for (var i = 0; i < this.contadorProductos; i++)
        {
            var producto = this.productos[i];
            total += producto.getPrecio();
        }
        return total;
    }

    @Override
    public String toString() {
        var resultado = "ID orden: " + this.idOrden + "\n";
        var totalOrden = this.calcularTotal();
        resultado += "\tTotal de la orden: " + totalOrden + "\n";
        resultado += "\tProductos de la orden: " + "\n";
        for (var i = 0; i < this.contadorProductos; i++) {
            resultado += "\t\t" + this.productos[i] + "\n";
        }
        return resultado;
    }
}
