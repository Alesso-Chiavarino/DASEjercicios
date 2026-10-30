package ar.edu.ubp.das.ej13_cadenademensajes.resolucion;

public class Ciudad {

    private String nombre;
    private Provincia provincia;

    public Ciudad(String nombre, Provincia provincia) {
        this.nombre = nombre;
        this.provincia = provincia;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNombreProvincia() {
        return provincia.getNombre();
    }

    public double getRecargoEnvio() {
        return provincia.getRecargoEnvio();
    }

}
