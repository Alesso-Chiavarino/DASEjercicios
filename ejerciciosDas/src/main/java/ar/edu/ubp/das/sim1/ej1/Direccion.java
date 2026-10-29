package ar.edu.ubp.das.sim1.ej1;

public class Direccion {

    private String calle;
    private int numero;
    private Localidad localidad;

    public Direccion(String calle, int numero, Localidad localidad) {
        this.calle = calle;
        this.numero = numero;
        this.localidad = localidad;
    }

    public String getCalle() {
        return calle;
    }

    public int getNumero() {
        return numero;
    }

    public Localidad getLocalidad() {
        return localidad;
    }

}
