package ar.edu.ubp.das.sim1.ej1;

public class Auto {

    private String patente;
    private String modelo;
    private double precioPorDia;

    public Auto(String patente, String modelo, double precioPorDia) {
        this.patente = patente;
        this.modelo = modelo;
        this.precioPorDia = precioPorDia;
    }

    public String getPatente() {
        return patente;
    }

    public String getModelo() {
        return modelo;
    }

    public double getPrecioPorDia() {
        return precioPorDia;
    }

}
