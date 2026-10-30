package ar.edu.ubp.das.ej15_claseperezosa.resolucion;

public class Facturador {

    public void facturar(Cliente cliente, double neto) {
        double iva = calcularIva(neto);
        System.out.println("Factura para " + cliente.getNombre() + " (DNI " + cliente.getDni() + ")");
        System.out.println("  Neto: " + formatear(neto)
                + " - IVA: " + formatear(iva)
                + " - Total: " + formatear(neto + iva));
    }

    private double calcularIva(double neto) {
        return neto * 0.21;
    }

    private String formatear(double precio) {
        return "$" + precio;
    }

}
