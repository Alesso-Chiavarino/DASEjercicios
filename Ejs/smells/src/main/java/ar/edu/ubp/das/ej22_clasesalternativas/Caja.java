package ar.edu.ubp.das.ej22_clasesalternativas;

public class Caja {

    private double totalVendido = 0;

    public void cobrarEnEfectivo(PagoEfectivo pago, double monto) {
        pago.cobrar(monto);
        totalVendido += monto;
    }

    public void cobrarConTarjeta(PagoTarjeta pago, double monto) {
        pago.realizarPago(monto);
        totalVendido += monto;
    }

    public void cobrarConMercadoPago(PagoMercadoPago pago, String alias, double monto) {
        pago.procesarTransferencia(alias, monto);
        totalVendido += monto;
    }

    public void cerrar() {
        System.out.println("Total vendido: $" + totalVendido);
    }

}
