package ar.edu.ubp.das.ej22_clasesalternativas;

public class PagoTarjeta {

    private String titular;
    private int cuotas;

    public PagoTarjeta(String titular, int cuotas) {
        this.titular = titular;
        this.cuotas = cuotas;
    }

    public void realizarPago(double importe) {
        double recargo = (cuotas > 1) ? importe * 0.10 : 0;
        System.out.println("Cobro con tarjeta de " + titular + " en " + cuotas + " cuota(s): $" + (importe + recargo));
    }

}
