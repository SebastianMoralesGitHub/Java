public class ArgumentosVariables {
    public static void main(String[] args) {
        //imprimirNumeros(1,2,99,4,64,74,0,-9);
        variosParametros("Saski",10,20);
    }

    private static void variosParametros(String saski, int...numeros) {
        System.out.printf("Nombre recibido: %s%n",saski);
        imprimirNumeros(numeros);
    }

    private static void imprimirNumeros(int... numeros) {
        for (int numero : numeros) {
            System.out.printf("%d ", numero);
        }
    }
}
