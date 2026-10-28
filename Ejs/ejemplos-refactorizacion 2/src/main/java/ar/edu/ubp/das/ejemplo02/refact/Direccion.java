package ar.edu.ubp.das.ejemplo02.refact;

public class Direccion {

    private String ciudad;
    private String calle;
    private int nroCalle;

    public Direccion(String ciudad, String calle, int nroCalle) {
        this.ciudad = ciudad;
        this.calle = calle;
        this.nroCalle = nroCalle;
    }

    public String getDireccionCompleta() {
        return calle + " " + nroCalle + ", " + ciudad;
    }

}
