package ar.edu.ubp.das.ejemplo18.refact;

public class Factura {

    private static final double ALICUOTA_IVA = 0.21;

    private double montoNeto;

    public Factura(double montoNeto) {
        this.montoNeto = montoNeto;
    }

    public double calcularTotal() {
        return montoNeto + (montoNeto * ALICUOTA_IVA);
    }

}
