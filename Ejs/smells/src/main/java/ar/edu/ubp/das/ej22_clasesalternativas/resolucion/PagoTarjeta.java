package ar.edu.ubp.das.ej22_clasesalternativas.resolucion;

public class PagoTarjeta extends Pago {

    private String titular;
    private int cuotas;

    public PagoTarjeta(String titular, int cuotas) {
        this.titular = titular;
        this.cuotas = cuotas;
    }

    @Override
    public void cobrar(double monto) {
        double recargo = (cuotas > 1) ? monto * 0.10 : 0;
        System.out.println("Cobro con tarjeta de " + titular + " en " + cuotas + " cuota(s): $" + (monto + recargo));
    }

}
