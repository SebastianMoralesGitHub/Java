package maquina_snacks;

import java.io.Serializable;
import java.util.Objects;

public class Snack implements Serializable {
    private static int contadorSnacks = 0;
    private int idSnack;
    private String nombreSnack;
    private double precioSnack;

    public Snack(){
        this.idSnack = ++ Snack.contadorSnacks;
    }

    public Snack(String nombreSnack, double precioSnack){
        this();
        this.nombreSnack = nombreSnack;
        this.precioSnack = precioSnack;
    }

    public int getIdSnack() {
        return this.idSnack;
    }

    public double getPrecioSnack() {
        return this.precioSnack;
    }

    public void setPrecioSnack(double precioSnack) {
        this.precioSnack = precioSnack;
    }

    public String getNombreSnack() {
        return this.nombreSnack;
    }

    public void setNombreSnack(String nombreSnack) {
        this.nombreSnack = nombreSnack;
    }

    public static int getContadorSnacks() {
        return contadorSnacks;
    }

    @Override
    public String toString() {
        return "ID del snack: " + idSnack +
                ", nombre: '" + nombreSnack + '\'' +
                ", precio: $" + precioSnack;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Snack snack = (Snack) o;
        return idSnack == snack.idSnack && Double.compare(precioSnack, snack.precioSnack) == 0 && Objects.equals(nombreSnack, snack.nombreSnack);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSnack, nombreSnack, precioSnack);
    }
}
