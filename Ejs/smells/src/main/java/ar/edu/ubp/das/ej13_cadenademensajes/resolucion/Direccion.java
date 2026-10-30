package ar.edu.ubp.das.ej13_cadenademensajes.resolucion;

public class Direccion {

    private String calle;
    private Ciudad ciudad;

    public Direccion(String calle, Ciudad ciudad) {
        this.calle = calle;
        this.ciudad = ciudad;
    }

    public String getCalle() {
        return calle;
    }

    public String getDireccionCompleta() {
        return calle + ", " + ciudad.getNombre() + " (" + ciudad.getNombreProvincia() + ")";
    }

    public double getRecargoEnvio() {
        return ciudad.getRecargoEnvio();
    }

}
