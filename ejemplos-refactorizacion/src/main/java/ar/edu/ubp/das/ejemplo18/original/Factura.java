package ar.edu.ubp.das.ejemplo18.original;

public class Factura {

    private double montoNeto;
    private CalculadoraIVA calculadoraIVA;

    public Factura(double montoNeto) {
        this.montoNeto = montoNeto;
        this.calculadoraIVA = new CalculadoraIVA();
    }

    public double calcularTotal() {
        return montoNeto + calculadoraIVA.calcular(montoNeto);
    }

}
