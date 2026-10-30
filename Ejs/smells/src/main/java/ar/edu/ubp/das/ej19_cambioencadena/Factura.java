package ar.edu.ubp.das.ej19_cambioencadena;

public class Factura {

    private static final double IVA = 0.21;

    private String cliente;
    private double neto;

    public Factura(String cliente, double neto) {
        this.cliente = cliente;
        this.neto = neto;
    }

    private double redondear(double valor) {
        return Math.round(valor * 100) / 100.0;
    }

    public void imprimir() {
        double iva = redondear(neto * IVA);
        System.out.println("FACTURA - " + cliente);
        System.out.println("  Neto: $" + neto + " | IVA (21%): $" + iva + " | Total: $" + redondear(neto + iva));
    }

}
