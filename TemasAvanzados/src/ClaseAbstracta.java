public class ClaseAbstracta {
    public static void main(String[] args) {
        //FiguraGeometrica figuraGeometrica = new FiguraGeometrica(); No se puede instanciar.
        FiguraGeometrica primeraFigura = new Rectangulo();
        primeraFigura.dibujar();
        primeraFigura = new Circulo();
        primeraFigura.dibujar();
    }
}

//Clase abstracta:

abstract class  FiguraGeometrica { //No se puede instanciar
public abstract void dibujar();
}

class Rectangulo extends FiguraGeometrica{
    public void dibujar(){
        System.out.printf("Rectangulo dibujado...%n");
    }
}

class Circulo extends FiguraGeometrica{
    public void dibujar(){
        System.out.printf("Circulo dibujado...%n");
    }
}