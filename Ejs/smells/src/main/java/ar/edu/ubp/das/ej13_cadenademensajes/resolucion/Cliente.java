package ar.edu.ubp.das.ej13_cadenademensajes.resolucion;

public class Cliente {

    private String nombre;
    private Direccion direccion;

    public Cliente(String nombre, Direccion direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccionCompleta() {
        return direccion.getDireccionCompleta();
    }

    public double getRecargoEnvio() {
        return direccion.getRecargoEnvio();
    }

}
