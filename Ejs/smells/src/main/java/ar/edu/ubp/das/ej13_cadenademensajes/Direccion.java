package ar.edu.ubp.das.ej13_cadenademensajes;

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

    public Ciudad getCiudad() {
        return ciudad;
    }

}
