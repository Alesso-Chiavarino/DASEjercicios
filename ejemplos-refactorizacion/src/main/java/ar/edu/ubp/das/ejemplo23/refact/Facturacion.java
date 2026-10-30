package ar.edu.ubp.das.ejemplo23.refact;

public class Facturacion {

    public void emitir(Fecha fecha, double monto) {
        if (fecha.esDiaHabil()) {
            System.out.println("Factura emitida el " + fecha + " por $" + monto);
        }
        else {
            System.out.println("No se emiten facturas los fines de semana.");
        }
    }

}
