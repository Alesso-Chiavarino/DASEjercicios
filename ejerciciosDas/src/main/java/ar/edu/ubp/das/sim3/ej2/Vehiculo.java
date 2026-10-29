package ar.edu.ubp.das.sim3.ej2;

public abstract class Vehiculo {

    protected String patente;
    protected double valor;

    public Vehiculo(String patente, double valor) {
        this.patente = patente;
        this.valor = valor;
    }

    public String getPatente() {
        return patente;
    }

    public double getValor() {
        return valor;
    }

}
