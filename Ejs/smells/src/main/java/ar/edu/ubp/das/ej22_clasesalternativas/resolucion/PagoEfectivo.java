package ar.edu.ubp.das.ej22_clasesalternativas.resolucion;

public class PagoEfectivo extends Pago {

    @Override
    public void cobrar(double monto) {
        System.out.println("Cobro en efectivo: $" + monto);
    }

}
