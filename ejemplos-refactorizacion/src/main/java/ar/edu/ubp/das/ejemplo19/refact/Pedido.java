package ar.edu.ubp.das.ejemplo19.refact;

public class Pedido {

    private double[] precios;
    private int antiguedadCliente;

    public Pedido(double[] precios, int antiguedadCliente) {
        this.precios = precios;
        this.antiguedadCliente = antiguedadCliente;
    }

    public double[] getPrecios() {
        return precios;
    }

    public int getAntiguedadCliente() {
        return antiguedadCliente;
    }

}
