package ar.edu.ubp.das.ej19_cambioencadena;

public class Presupuesto {

    private static final double IVA = 0.21;

    private String cliente;
    private double neto;
    private int diasValidez;

    public Presupuesto(String cliente, double neto, int diasValidez) {
        this.cliente = cliente;
        this.neto = neto;
        this.diasValidez = diasValidez;
    }

    private double redondear(double valor) {
        return Math.round(valor * 100) / 100.0;
    }

    public void imprimir() {
        double iva = redondear(neto * IVA);
        System.out.println("PRESUPUESTO - " + cliente + " (válido " + diasValidez + " días)");
        System.out.println("  Neto: $" + neto + " | IVA (21%): $" + iva + " | Total: $" + redondear(neto + iva));
    }

}
