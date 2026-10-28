package ar.edu.ubp.das.ejemplo08.refact;

public class Direccion {

    private String calle;
    private String nroCalle;
    private String ciudad;
    private String codigoPostal;
    private String pais;

    public Direccion(String calle, String nroCalle, String ciudad, String codigoPostal, String pais) {
        this.calle = calle;
        this.nroCalle = nroCalle;
        this.ciudad = ciudad;
        this.codigoPostal = codigoPostal;
        this.pais = pais;
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

    public String getPais() {
        return pais;
    }

    public String mostrarDireccion() {
        return calle + " " + nroCalle + ", " + ciudad + ", " + codigoPostal + ", " + pais;
    }

}

