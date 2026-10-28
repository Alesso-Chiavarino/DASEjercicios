package ar.edu.ubp.das.ejemplo02.original;

public class Direccion {

    private String ciudad;
    private String calle;
    private String nroCalle;

    public Direccion(String ciudad, String calle, String nroCalle) {
        this.ciudad = ciudad;
        this.calle = calle;
        this.nroCalle = nroCalle;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getCalle() {
        return calle;
    }

    public String getNroCalle() {
        return nroCalle;
    }

}
