package ar.edu.ubp.das.sim3.ej2;

public class Moto extends Vehiculo {

    private int cilindrada;

    public Moto(String patente, double valor, int cilindrada) {
        super(patente, valor);
        this.cilindrada = cilindrada;
    }

    public int getCilindrada() {
        return cilindrada;
    }

}
