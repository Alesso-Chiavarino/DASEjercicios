package ar.edu.ubp.das.ej13_cadenademensajes;

public class Provincia {

    private String nombre;
    private double recargoEnvio;

    public Provincia(String nombre, double recargoEnvio) {
        this.nombre = nombre;
        this.recargoEnvio = recargoEnvio;
    }

    public String getNombre() {
        return nombre;
    }

    public double getRecargoEnvio() {
        return recargoEnvio;
    }

}
