package ar.edu.ubp.das.ej04_gruposdedatos.resolucion;

public class Direccion {

    private String calle;
    private int numero;
    private String ciudad;
    private String codigoPostal;

    public Direccion(String calle, int numero, String ciudad, String codigoPostal) {
        this.calle = calle;
        this.numero = numero;
        this.ciudad = ciudad;
        this.codigoPostal = codigoPostal;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public boolean esMismaCiudad(Direccion otra) {
        return ciudad.equals(otra.getCiudad());
    }

    public boolean esMismaProvincia(Direccion otra) {
        return codigoPostal.charAt(0) == otra.getCodigoPostal().charAt(0);
    }

    public String getDescripcionCompleta() {
        return calle + " " + numero + " - " + ciudad + " (CP " + codigoPostal + ")";
    }

    public String getDescripcionCorta() {
        return calle + " " + numero + ", " + ciudad;
    }

}
