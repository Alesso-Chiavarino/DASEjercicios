package ar.edu.ubp.das.ej19_cambioencadena.resolucion;

public class NotaDeCredito {

    private String cliente;
    private double netoDevuelto;

    public NotaDeCredito(String cliente, double netoDevuelto) {
        this.cliente = cliente;
        this.netoDevuelto = netoDevuelto;
    }

    public void imprimir() {
        double iva = CalculadoraIva.calcularIva(netoDevuelto);
        System.out.println("NOTA DE CRÉDITO - " + cliente);
        System.out.println("  Se devuelve: $" + CalculadoraIva.redondear(netoDevuelto + iva)
                + " (IVA " + CalculadoraIva.getPorcentaje() + " incluido)");
    }

}
