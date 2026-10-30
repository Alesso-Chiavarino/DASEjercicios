package ar.edu.ubp.das.ej22_clasesalternativas.resolucion;

public class Caja {

    private double totalVendido = 0;

    public void cobrar(Pago pago, double monto) {
        pago.cobrar(monto);
        totalVendido += monto;
    }

    public void cerrar() {
        System.out.println("Total vendido: $" + totalVendido);
    }

}
