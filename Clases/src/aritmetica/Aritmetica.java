package aritmetica;

public class Aritmetica {
    private int primerOperando;
    private int segundoOperando;

    public Aritmetica(){}

    public Aritmetica(int primerOperando, int segundoOperando){
        this.primerOperando = primerOperando;
        this.segundoOperando = segundoOperando;
    }

    public void sumar(){
        var resultado = this.primerOperando + this.segundoOperando;
        System.out.printf("%nLa suma de %d + %d es: %d",this.primerOperando,this.segundoOperando,resultado);
    }

    public void restar(){
        var resultado = this.primerOperando - this.segundoOperando;
        System.out.printf("%nLa resta de %d - %d es: %d",this.primerOperando,this.segundoOperando,resultado);
    }

    public int getPrimerOperando(){
        return this.primerOperando;
    }

    public void setPrimerOperando(int primerOperando){
        this.primerOperando = primerOperando;
    }

    public int getSegundoOperando(){
        return this.segundoOperando;
    }

    public void setSegundoOperando(int segundoOperando){
        this.segundoOperando = segundoOperando;
    }

}
