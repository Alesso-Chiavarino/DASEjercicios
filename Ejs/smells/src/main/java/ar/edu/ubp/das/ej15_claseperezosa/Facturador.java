package ar.edu.ubp.das.ej15_claseperezosa;

public class Facturador {

    private CalculadoraIva calculadoraIva = new CalculadoraIva();
    private FormateadorPrecio formateador = new FormateadorPrecio();

    public void facturar(Cliente cliente, double neto) {
        double iva = calculadoraIva.calcular(neto);
        System.out.println("Factura para " + cliente.getNombre() + " (DNI " + cliente.getDni() + ")");
        System.out.println("  Neto: " + formateador.formatear(neto)
                + " - IVA: " + formateador.formatear(iva)
                + " - Total: " + formateador.formatear(neto + iva));
    }

}
