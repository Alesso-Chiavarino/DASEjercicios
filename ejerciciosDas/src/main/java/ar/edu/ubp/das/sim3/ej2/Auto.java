package ar.edu.ubp.das.sim3.ej2;

public class Auto extends Vehiculo {

    private boolean tieneGnc;

    public Auto(String patente, double valor, boolean tieneGnc) {
        super(patente, valor);
        this.tieneGnc = tieneGnc;
    }

    public boolean isTieneGnc() {
        return tieneGnc;
    }

}
