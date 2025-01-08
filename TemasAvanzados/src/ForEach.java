public class ForEach {
    public static void main(String[] args) {
        int edades[] = {20,16,18,17,21,28,19};
        for (int edad : edades) {
            if (edad == edades[edades.length - 1])
                System.out.printf("%d.",edad);
            else System.out.printf("%d, ",edad);
        }
    }
}
