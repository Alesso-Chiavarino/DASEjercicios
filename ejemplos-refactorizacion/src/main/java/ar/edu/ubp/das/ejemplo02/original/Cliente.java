package ar.edu.ubp.das.ejemplo02.original;

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

    public Direccion getDireccion() {
        return direccion;
    }

}
