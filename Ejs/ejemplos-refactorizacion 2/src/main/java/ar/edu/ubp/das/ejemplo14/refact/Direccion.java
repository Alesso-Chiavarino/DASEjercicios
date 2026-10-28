package ar.edu.ubp.das.ejemplo14.refact;

public class Direccion {

    private String calle;
    private String nroCalle;
    private String ciudad;
    private String codigoPostal;

    public Direccion(String calle, String nroCalle, String ciudad, String codigoPostal) {
        this.calle = calle;
        this.nroCalle = nroCalle;
        this.ciudad = ciudad;
        this.codigoPostal = codigoPostal;
    }

    public String getCalle() {
        return calle;
    }

    public String getNroCalle() {
        return nroCalle;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public String mostrarDireccion() {
        return calle + " " + nroCalle + ", " + ciudad + ", " + codigoPostal;
    }

}

