package ar.edu.ubp.das.ej19_cambioencadena;

public class NotaDeCredito {

    private static final double IVA = 0.21;

    private String cliente;
    private double netoDevuelto;

    public NotaDeCredito(String cliente, double netoDevuelto) {
        this.cliente = cliente;
        this.netoDevuelto = netoDevuelto;
    }

    private double redondear(double valor) {
        return Math.round(valor * 100) / 100.0;
    }

    public void imprimir() {
        double iva = redondear(netoDevuelto * IVA);
        System.out.println("NOTA DE CRÉDITO - " + cliente);
        System.out.println("  Se devuelve: $" + redondear(netoDevuelto + iva) + " (IVA 21% incluido)");
    }

}
