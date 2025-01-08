package excepciones;

public class Aritmetica {
    public static int division(int numerador, int denominador){
        if (denominador == 0){
            throw new RuntimeException("División entre cero no válida.");
        }
        return numerador / denominador;
    }
}
