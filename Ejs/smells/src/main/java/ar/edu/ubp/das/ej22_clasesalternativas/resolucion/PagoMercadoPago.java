package ar.edu.ubp.das.ej22_clasesalternativas.resolucion;

public class PagoMercadoPago extends Pago {

    private String alias;

    public PagoMercadoPago(String alias) {
        this.alias = alias;
    }

    @Override
    public void cobrar(double monto) {
        System.out.println("Transferencia recibida desde " + alias + ": $" + monto);
    }

}
