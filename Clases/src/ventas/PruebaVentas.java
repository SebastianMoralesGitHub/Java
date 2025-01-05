package ventas;

public class PruebaVentas {
    public static void main(String[] args) {
        System.out.println("*** SISTEMA DE VENTAS ***");
        var producto1 = new Producto("Tenis",57.5);
        var producto2 = new Producto("Camiseta",21.3);
//        System.out.println(producto1);
//        System.out.println(producto2);
        var primeraOrden = new Orden();
        primeraOrden.agregarProducto(producto1);
        primeraOrden.agregarProducto(producto2);
        //primeraOrden.mostrarOrden();
        System.out.println(primeraOrden);
        //Segunda Orden:
        var segundaOrden = new Orden();
        segundaOrden.agregarProducto(new Producto("Teclado mecánico",15.9));
        segundaOrden.agregarProducto(new Producto("Vacuum PC cleaner",20.2));
        //segundaOrden.mostrarOrden();
        System.out.println(segundaOrden);
    }
}
