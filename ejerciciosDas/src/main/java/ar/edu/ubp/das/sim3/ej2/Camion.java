package ar.edu.ubp.das.sim3.ej2;

public class Camion extends Vehiculo {

    private int toneladas;

    public Camion(String patente, double valor, int toneladas) {
        super(patente, valor);
        this.toneladas = toneladas;
    }

    public int getToneladas() {
        return toneladas;
    }

}
