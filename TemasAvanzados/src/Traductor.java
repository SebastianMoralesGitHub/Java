public interface Traductor {
    //Son publicos y abstractos public y abstract
    void traducir();
    //Metodos con implementación por default:
    default void iniciarTraductor(){
        System.out.println("El traductor se está iniciando...");
    }
}

class Ingles implements Traductor{
    @Override
    public void iniciarTraductor(){
        System.out.println("Iniciando traductor de inglés...");
    }
    @Override
    public void traducir(){
        System.out.println("Traduciendo a inglés...");
    }
}

class Frances implements Traductor{
    @Override
    public void traducir(){
        System.out.println("Traduciendo a francés...");
    }
    @Override
    public void iniciarTraductor(){
        System.out.println("Iniciando traductor de francés...");
    }
}

class PruebaTraductor{
    public static void main(String[] args) {
        Traductor traductorIngles = new Ingles();
        traductorIngles.iniciarTraductor();
        traductorIngles.traducir();
        Traductor traductorFrances = new Frances();
        traductorFrances.iniciarTraductor();
        traductorFrances.traducir();
    }
}