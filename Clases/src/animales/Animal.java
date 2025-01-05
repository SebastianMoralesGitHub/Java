package animales;

public class Animal {
    protected void hacerSonido(){
        System.out.println("El animal hace un sonido...");
    }
}

class Perro extends Animal{
    @Override
    protected void hacerSonido(){
        System.out.println("El perro hace guau xd.");
    }
}

class Gato extends Animal{
    @Override
    protected void hacerSonido(){
        System.out.println("El gato hace miau xd.");
    }
}


class PruebaAnimal{
    //Metodo polimorfico:
    static void imprimirSonido(Animal animal){
        animal.hacerSonido();
    }

    public static void main(String[] args) {
        System.out.println("*** EJEMPLO DE HERENCIA ***");
        //objeto clase padre animal:
        var animal = new Gato();
        imprimirSonido(animal);
    }
}
