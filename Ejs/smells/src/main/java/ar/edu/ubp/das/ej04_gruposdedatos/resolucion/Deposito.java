package ar.edu.ubp.das.ej04_gruposdedatos.resolucion;

public class Deposito {

    private String nombre;
    private Direccion direccion;

    public Deposito(String nombre, Direccion direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public Direccion getDireccion() {
        return direccion;
    }

}
