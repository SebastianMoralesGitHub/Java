package aritmetica.prueba;

import aritmetica.Aritmetica;

public class PruebaAritmetica {
    public static void main(String[] args) {
        System.out.println("*** EJEMPLO ARITMETICA ***");
        var aritmetica1 = new Aritmetica(5,7);
        System.out.println("Atributo primerOperando del objeto aritmetica1: " + aritmetica1.getPrimerOperando() );
        aritmetica1.setPrimerOperando(64);
        aritmetica1.setSegundoOperando(254);
        aritmetica1.sumar();
        aritmetica1.restar();
        //Creamos un segundo objeto:
        var aritmetica2 = new Aritmetica(20,9);
        aritmetica2.sumar();
        aritmetica2.restar();
    }
}
