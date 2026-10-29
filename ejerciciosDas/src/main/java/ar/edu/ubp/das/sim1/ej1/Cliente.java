package ar.edu.ubp.das.sim1.ej1;

public class Cliente {

    private String nombre;
    private String dni;
    private Direccion direccion;

    public Cliente(String nombre, String dni, Direccion direccion) {
        this.nombre = nombre;
        this.dni = dni;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    public Direccion getDireccion() {
        return direccion;
    }

}
