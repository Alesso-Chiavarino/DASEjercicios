package ar.edu.ubp.das.ej19_cambioencadena.resolucion;

public class Presupuesto {

    private String cliente;
    private double neto;
    private int diasValidez;

    public Presupuesto(String cliente, double neto, int diasValidez) {
        this.cliente = cliente;
        this.neto = neto;
        this.diasValidez = diasValidez;
    }

    public void imprimir() {
        double iva = CalculadoraIva.calcularIva(neto);
        System.out.println("PRESUPUESTO - " + cliente + " (válido " + diasValidez + " días)");
        System.out.println("  Neto: $" + neto + " | IVA (" + CalculadoraIva.getPorcentaje() + "): $" + iva
                + " | Total: $" + CalculadoraIva.redondear(neto + iva));
    }

}
