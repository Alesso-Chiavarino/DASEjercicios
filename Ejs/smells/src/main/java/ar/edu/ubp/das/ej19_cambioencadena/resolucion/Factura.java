package ar.edu.ubp.das.ej19_cambioencadena.resolucion;

public class Factura {

    private String cliente;
    private double neto;

    public Factura(String cliente, double neto) {
        this.cliente = cliente;
        this.neto = neto;
    }

    public void imprimir() {
        double iva = CalculadoraIva.calcularIva(neto);
        System.out.println("FACTURA - " + cliente);
        System.out.println("  Neto: $" + neto + " | IVA (" + CalculadoraIva.getPorcentaje() + "): $" + iva
                + " | Total: $" + CalculadoraIva.redondear(neto + iva));
    }

}
