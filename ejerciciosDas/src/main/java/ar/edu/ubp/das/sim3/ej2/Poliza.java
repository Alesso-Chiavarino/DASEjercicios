package ar.edu.ubp.das.sim3.ej2;

public abstract class Poliza {

    protected int numero;

    public Poliza(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public abstract double calcularPrima();

    public abstract String descripcion();

}
